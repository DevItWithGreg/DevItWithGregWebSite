package com.devitwithgreg.website.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.devitwithgreg.website.service.YouTubeService;
import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/youtube")
public class YouTubeController {

    private final Logger log = LoggerFactory.getLogger(YouTubeController.class);

    private YouTubeService youTubeService;


    public YouTubeController(YouTubeService youTubeService) {
        this.youTubeService = youTubeService;
    }

    @GetMapping("/playlist")
    @Timed
    public List<YouTubePlaylistDTO> getPlaylist() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {
        return youTubeService.getPlaylist();
    }



}

