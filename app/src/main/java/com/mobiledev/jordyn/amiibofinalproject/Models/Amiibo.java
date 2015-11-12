package com.mobiledev.jordyn.amiibofinalproject.Models;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;
import java.util.List;

/**
 * Created by Jordyn on 2015-10-28.
 */
public class Amiibo {

    private String name;
    private Date releaseDate;
    private String amiibo;

    public String getAmiibo() {
        return amiibo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAmiibo(String amiibo) {
        this.amiibo = amiibo;
    }
}
