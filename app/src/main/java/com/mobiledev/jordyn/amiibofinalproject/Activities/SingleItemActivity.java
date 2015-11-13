package com.mobiledev.jordyn.amiibofinalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobiledev.jordyn.amiibofinalproject.ImageLoader;
import com.mobiledev.jordyn.amiibofinalproject.R;
import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.List;

public class SingleItemActivity extends DrawerActivity {

    String image;
    String name;
    String amiiboID;
    String description;
    ImageLoader imageLoader = new ImageLoader(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.activity_frame);

        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View activityView = layoutInflater.inflate(R.layout.activity_single_item, null, false);

        frameLayout.addView(activityView);

        TextView nameView = (TextView) findViewById(R.id.amiibo_name);

        Intent i = getIntent();
        amiiboID = i.getStringExtra("amiiboID");
        image = i.getStringExtra("image");
        name = i.getStringExtra("name");
        description = i.getStringExtra("description");

        ImageView amiiboimg = (ImageView) findViewById(R.id.amiibo_img);

        nameView.setText(name);
        imageLoader.DisplayImage(image, amiiboimg);

        TextView descriptionView = (TextView) findViewById(R.id.amiibo_description);
        descriptionView.setText(description);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("AmiiboGames");
        query.whereEqualTo("amiiboID", amiiboID);

        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("JordynTest", "I think a game was found?");
                } else {
                    Log.e("JordynTest", "No games found... Something must be wrong.");
                }
            }
        });

    }
}
