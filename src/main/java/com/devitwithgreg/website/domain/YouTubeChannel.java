package com.devitwithgreg.website.domain;

import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "YouTubeChannels")
public class YouTubeChannel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private List<YouTubePlaylistDTO> youTubePlaylist;

    public YouTubeChannel() {
    }

    public YouTubeChannel(String id, List<YouTubePlaylistDTO> youTubePlaylist) {
        this.id = id;
        this.youTubePlaylist = youTubePlaylist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<YouTubePlaylistDTO> getYouTubePlaylist() {
        return youTubePlaylist;
    }

    public void setYouTubePlaylist(List<YouTubePlaylistDTO> youTubePlaylist) {
        this.youTubePlaylist = youTubePlaylist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YouTubeChannel that = (YouTubeChannel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return youTubePlaylist != null ? youTubePlaylist.equals(that.youTubePlaylist) : that.youTubePlaylist == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (youTubePlaylist != null ? youTubePlaylist.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "YouTubeChannel{" +
            "id='" + id + '\'' +
            ", youTubePlaylist=" + youTubePlaylist +
            '}';
    }
}
