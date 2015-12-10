package com.mobiledev.jordyn.amiibofinalproject;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Jordyn on 2015-10-28.
 */
public class AmiiboApplication extends Application {

    public static final String APPLICATION_ID = "YKiyBUToi7itElMzzd6Hweag68pD7ybgIbqZMMQC";
    public static final String CLIENT_KEY = "0iorg1wNTTJ0K3ZWsdczJZWTso2nHzXaCTuveNdb";

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

//        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
