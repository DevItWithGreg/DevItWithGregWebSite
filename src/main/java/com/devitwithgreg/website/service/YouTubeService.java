package com.devitwithgreg.website.service;

import com.devitwithgreg.website.config.exetrnalService.ExternalServiceProperties;
import com.devitwithgreg.website.config.exetrnalService.GoogleProperties;
import com.devitwithgreg.website.domain.google.api.responce.YouTubeItemResponse;
import com.devitwithgreg.website.helper.YouTubeHelper;
import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YouTubeService {
    private final Logger log = LoggerFactory.getLogger(YouTubeService.class);

    private ExternalServiceProperties externalServiceProperties;

    public YouTubeService(ExternalServiceProperties externalServiceProperties) {
        this.externalServiceProperties = externalServiceProperties;
    }

    public List<YouTubePlaylistDTO> getPlaylist(String channelId) {
        GoogleProperties googleProperties = this.externalServiceProperties.getGoogle();
        YouTubeItemResponse response = YouTubeHelper.getPlayLists(channelId, googleProperties.getKey());
        return YouTubeHelper.convertYouTubeResponseToDto(response, googleProperties.getKey());
    }

    public GoogleProperties getGoogleProperties() {
        return this.externalServiceProperties.getGoogle();
    }


}
