package com.devitwithgreg.website.helper;

import com.devitwithgreg.website.domain.google.api.responce.YouTubeItemResponse;
import com.devitwithgreg.website.domain.google.api.shred.Snippet;
import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import com.devitwithgreg.website.service.dto.YouTubeVideoDTO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YouTubeHelper {

    private static final String API_BASE_URL = "https://www.googleapis.com/youtube/v3/";


    public static YouTubeItemResponse getPlayLists(@NotEmpty String channel, @NotEmpty String apiKey){
        Map<String, String> query = new LinkedHashMap<>();
        query.put("part", "snippet");
        query.put("channelId", channel);
        query.put("maxResults", "50");
        String url = WebserviceHelper.buildYoutubeUrl(API_BASE_URL, "playlists", query, apiKey);

        HttpEntity<YouTubeItemResponse> entity = new HttpEntity<>(WebserviceHelper.createHeaders());
        RestTemplate restTemplate = WebserviceHelper.createRestTemplate();

        return restTemplate.exchange(url, HttpMethod.GET, entity, YouTubeItemResponse.class).getBody();
    }

    private static YouTubeItemResponse getVideoLists(@NotEmpty String playListId, @NotEmpty String apiKey){
        Map<String, String> query = new LinkedHashMap<>();
        query.put("part", "snippet,contentDetails");
        query.put("playlistId", playListId);
        query.put("maxResults", "50");
        String url = WebserviceHelper.buildYoutubeUrl(API_BASE_URL, "playlistItems", query, apiKey);

        HttpEntity<YouTubeItemResponse> entity = new HttpEntity<>(WebserviceHelper.createHeaders());
        RestTemplate restTemplate = WebserviceHelper.createRestTemplate();

        return restTemplate.exchange(url, HttpMethod.GET, entity, YouTubeItemResponse.class).getBody();
    }

    public static List<YouTubePlaylistDTO> convertYouTubeResponseToDto(@NotEmpty YouTubeItemResponse youTubeItemResponse, @NotEmpty String apiKey ) {

        List<YouTubePlaylistDTO> youTubePlaylistDTOs = new ArrayList<>();
        youTubeItemResponse.getItems().forEach(playList -> {
            YouTubeItemResponse videoResponse = YouTubeHelper.getVideoLists(playList.getId(),apiKey);
            YouTubePlaylistDTO playlistDTO = new YouTubePlaylistDTO(playList.getSnippet().getTitle(), playList.getId());
            videoResponse.getItems().forEach(item -> {
                Snippet snp = item.getSnippet();
                playlistDTO.addVideo(new YouTubeVideoDTO(snp.getTitle(),item.getContentDetails().getVideoId(),snp.getThumbnails().getMedium()));
            });
            youTubePlaylistDTOs.add(playlistDTO);
        });
        return youTubePlaylistDTOs;
    }

}
