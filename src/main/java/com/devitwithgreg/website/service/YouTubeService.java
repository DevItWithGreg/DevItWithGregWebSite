package com.devitwithgreg.website.service;

import com.devitwithgreg.website.config.exetrnalService.properties.ExternalServiceProperties;
import com.devitwithgreg.website.config.exetrnalService.properties.GoogleProperties;
import com.devitwithgreg.website.domain.google.api.responce.YouTubeItemResponse;
import com.devitwithgreg.website.helper.YouTubeHelper;
import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class YouTubeService {
    private final Logger log = LoggerFactory.getLogger(YouTubeService.class);

    private ExternalServiceProperties externalServiceProperties;

    public YouTubeService(ExternalServiceProperties externalServiceProperties) {
        this.externalServiceProperties = externalServiceProperties;
    }

    public List<YouTubePlaylistDTO> getPlaylist() throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        GoogleProperties googleProperties = this.externalServiceProperties.getGoogle();
        YouTubeItemResponse response = YouTubeHelper.getPlayLists(googleProperties.getChannel(),googleProperties.getKey());
        return YouTubeHelper.convertYouTubeResponseToDto(response,googleProperties.getKey());
    }


}
