package com.devitwithgreg.website.service.dto;

import com.devitwithgreg.website.domain.google.api.shred.Thumbnail;

public class YouTubeVideoDTO {
    private String title;
    private String videoId;
    private Thumbnail thumbnail;
    private boolean displayFrame;

    public YouTubeVideoDTO(String title, String videoId, Thumbnail thumbnail) {
        this.title = title;
        this.videoId = videoId;
        this.thumbnail = thumbnail;
        this.displayFrame = false;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDisplayFrame() {
        return displayFrame;
    }

    public void setDisplayFrame(boolean displayFrame) {
        this.displayFrame = displayFrame;
    }
}
