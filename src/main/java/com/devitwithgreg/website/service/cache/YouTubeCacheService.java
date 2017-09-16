package com.devitwithgreg.website.service.cache;

import com.devitwithgreg.website.domain.YouTubeChannel;
import com.devitwithgreg.website.repository.YouTubeChannelRepository;
import com.devitwithgreg.website.runnable.YouTubeChannelUpdater;
import com.devitwithgreg.website.service.YouTubeService;
import com.devitwithgreg.website.service.dto.YouTubePlaylistDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YouTubeCacheService {

    private YouTubeChannelUpdater youTubeChannelUpdater;
    private YouTubeChannelRepository youTubeChannelRepository;
    private YouTubeService youTubeService;

    public YouTubeCacheService(YouTubeChannelRepository youTubeChannelRepository, YouTubeService youTubeService) {
        this.youTubeService = youTubeService;
        this.youTubeChannelRepository = youTubeChannelRepository;
        this.youTubeChannelUpdater = new YouTubeChannelUpdater(youTubeService, youTubeChannelRepository);
    }

    public YouTubeChannelUpdater getYouTubeChannelUpdater() {
        return this.youTubeChannelUpdater;
    }

    public List<YouTubePlaylistDTO> getDefaultPlayList() {
        List<YouTubePlaylistDTO> response = new ArrayList<>();
        String defaultChannelId = youTubeService.getGoogleProperties().getChannel();
        if (defaultChannelId != null) {
            YouTubeChannel channel = this.youTubeChannelRepository.findOne(defaultChannelId);
            if (channel != null) {
                response = channel.getYouTubePlaylist();
            }
        }
        return response;
    }
}
