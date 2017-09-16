package com.devitwithgreg.website.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.devitwithgreg.website.service.cache.YouTubeCacheService;
import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/youtube")
public class YouTubeController {

    private final Logger log = LoggerFactory.getLogger(YouTubeController.class);

    private YouTubeCacheService youTubeCacheService;


    public YouTubeController(YouTubeCacheService youTubeCacheService) {
        this.youTubeCacheService = youTubeCacheService;
    }

    @GetMapping("/playlist")
    @Timed
    public List<YouTubePlaylistDTO> getPlaylist() {
        return youTubeCacheService.getDefaultPlayList();
    }


}

