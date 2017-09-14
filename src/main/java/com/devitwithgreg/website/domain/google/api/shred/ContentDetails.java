package com.devitwithgreg.website.domain.google.api.shred;

public class ContentDetails {
    private int itemCount;
    private String videoId;
    private String videoPublishedAt;

    public ContentDetails() {
    }

    public ContentDetails(int itemCount) {
        this.itemCount = itemCount;
    }

    public ContentDetails(String videoId, String videoPublishedAt) {
        this.videoId = videoId;
        this.videoPublishedAt = videoPublishedAt;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoPublishedAt() {
        return videoPublishedAt;
    }

    public void setVideoPublishedAt(String videoPublishedAt) {
        this.videoPublishedAt = videoPublishedAt;
    }
}
