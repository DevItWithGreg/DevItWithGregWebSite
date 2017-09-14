package com.devitwithgreg.website.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class YouTubePlaylistDTO {
    private String playlistName;
    private String playlistId;
    private List<YouTubeVideoDTO> videos;

    public YouTubePlaylistDTO(String playlistName, String playlistId) {
        this.playlistName = playlistName;
        this.playlistId = playlistId;
        this.videos = new ArrayList<>();
    }

    @JsonIgnore
    public void addVideo(YouTubeVideoDTO youTubeVideoDTO){
        this.videos.add(youTubeVideoDTO);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<YouTubeVideoDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<YouTubeVideoDTO> videos) {
        this.videos = videos;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }
}
