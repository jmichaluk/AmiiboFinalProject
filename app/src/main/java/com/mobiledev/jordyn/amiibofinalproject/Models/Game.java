package com.mobiledev.jordyn.amiibofinalproject.Models;

/**
 * Created by Jordyn on 2015-11-12.
 */
public class Game {

    private String name;
    private String gameID;
    private String image;

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
