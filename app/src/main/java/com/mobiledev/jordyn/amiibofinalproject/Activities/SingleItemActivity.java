package com.mobiledev.jordyn.amiibofinalproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobiledev.jordyn.amiibofinalproject.ImageLoader;
import com.mobiledev.jordyn.amiibofinalproject.R;

public class SingleItemActivity extends DrawerActivity {

    String image;
    String name;
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
        image = i.getStringExtra("amiibo");
        name = i.getStringExtra("name");

        ImageView amiiboimg = (ImageView) findViewById(R.id.amiibo_img);

        nameView.setText(name);
        imageLoader.DisplayImage(image, amiiboimg);
    }
}
