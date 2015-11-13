package com.mobiledev.jordyn.amiibofinalproject.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jordyn on 2015-10-28.
 */
public class Amiibo {

    private String amiiboID;
    private String name;
    private Date releaseDate;
    private String amiiboImage;
    private String description;

    public String getAmiiboID() { return amiiboID; }

    public void setAmiiboID(String amiiboID) { this.amiiboID = amiiboID; }

    public String getAmiiboImage() {
        return amiiboImage;
    }

    public void setAmiiboImage(String amiiboImage) { this.amiiboImage = amiiboImage; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public Date getReleaseDate() { return releaseDate; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public String getDescription() { return description; }

    public void setDescription( String description) { this.description = description; }
}
