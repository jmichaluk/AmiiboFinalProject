package com.mobiledev.jordyn.amiibofinalproject.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.mobiledev.jordyn.amiibofinalproject.Models.Amiibo;
import com.mobiledev.jordyn.amiibofinalproject.Adapters.AmiiboAdapter;
import com.mobiledev.jordyn.amiibofinalproject.R;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class AmiibosActivity extends DrawerActivity {

    private GridView amiiboGrid;
    private List<ParseObject> object;
    ProgressDialog mProgressDialog;
    AmiiboAdapter adapter;
    private List<Amiibo> amiiboArrayList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(R.layout.activity_amiibos, null, false);
        frameLayout.addView(activityView);

        new RemoteDataTask().execute();
    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(AmiibosActivity.this);
            mProgressDialog.setTitle("Amiibo List");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            amiiboArrayList = new ArrayList<Amiibo>();
            try {
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Amiibos");
                query.orderByAscending("position");
                object = query.find();
                for (ParseObject amiibo : object) {
                    Log.d("jordyntest", "Amiibo found");
                    try {
                        ParseFile image = (ParseFile) amiibo.get("Image_URL");
                        Amiibo map = new Amiibo();
                        map.setAmiiboImage(image.getUrl());
                        map.setName((String) amiibo.get("Name"));
                        map.setAmiiboID((String) amiibo.get("objectID"));
                        map.setDescription((String) amiibo.get("Description"));
                        amiiboArrayList.add(map);
                    } catch (NullPointerException e) {
                        Log.e("Error", "No image found");
                        e.printStackTrace();
                    }
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("JordynTest", "Do I get here?");
            amiiboGrid = (GridView) findViewById(R.id.amiibo_grid);
            Log.d("JordynTest", "Amiibo grid found");
            adapter = new AmiiboAdapter(AmiibosActivity.this, amiiboArrayList);
            Log.d("JordynTest", "Adapter created");
            amiiboGrid.setAdapter(adapter);
            Log.d("JordynTest", "Adapter set");

            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_amiibos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent Activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
