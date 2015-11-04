package com.mobiledev.jordyn.amiibofinalproject;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Jordyn on 2015-10-28.
 */
public class Amiibo {
    private String id;
    private String name;
    private String description;
    private ParseFile image_url;

    Amiibo(String id, String name, String description, ParseFile image_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_url = image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ParseFile getImageURL() {
        return image_url;
    }

    public void setImageURL(ParseFile image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return this.getName();
    }


}
