package com.mobiledev.jordyn.amiibofinalproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class AmiibosActivity extends DrawerActivity {

    private GridView amiiboGrid;
    private List<Amiibo> amiibos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(R.layout.activity_amiibos, null, false);
        frameLayout.addView(activityView);

        amiiboGrid = (GridView) findViewById(R.id.amiibo_grid);
        amiibos = new ArrayList<Amiibo>();
        ArrayAdapter<Amiibo> adapter = new ArrayAdapter<Amiibo>(this, R.layout.amiibo_list_item, amiibos);
        amiiboGrid.setAdapter(adapter);

        refreshPostList();
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
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshPostList() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Amiibos");

        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    amiibos.clear();
                    for (ParseObject amiibo : list) {
                        Amiibo amiiboObject = new Amiibo(amiibo.getObjectId(), amiibo.getString("Name"), amiibo.getString("Description"), amiibo.getParseFile("Image_URL"));
                        ParseFile image = (ParseFile) amiibo.get("Image_URL");
                        amiiboObject.setImageURL(image);
                        amiibos.add(amiiboObject);

                    }
                    ((ArrayAdapter<Amiibo>) amiiboGrid.getAdapter()).notifyDataSetChanged();
                } else {
                    Log.d(getClass().getSimpleName(), "Error: " + e.getMessage());
                }
            }
        });
    }
}
