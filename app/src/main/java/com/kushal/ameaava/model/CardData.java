package com.kushal.ameaava.model;

/**
 * Created by Kushal on 02-08-2015.
 */
public class CardData {

    private String videoTitle, videoURL;

    public CardData(String videoTitle, String videoURL) {
        this.videoTitle = videoTitle;
        this.videoURL = videoURL;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoURL() {
        return videoURL;
    }
}
