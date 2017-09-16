package com.devitwithgreg.website.runnable;

import com.devitwithgreg.website.config.exetrnalService.properties.GoogleProperties;
import com.devitwithgreg.website.domain.YouTubeChannel;
import com.devitwithgreg.website.repository.YouTubeChannelRepository;
import com.devitwithgreg.website.service.YouTubeService;

import java.util.List;

public class YouTubeChannelUpdater implements Runnable {
    private YouTubeService youTubeService;
    private YouTubeChannelRepository youTubeChannelRepository;

    public YouTubeChannelUpdater(YouTubeService youTubeService, YouTubeChannelRepository youTubeChannelRepository) {
        this.youTubeService = youTubeService;
        this.youTubeChannelRepository = youTubeChannelRepository;
    }

    @Override
    public void run() {
        // we get the google property from the youtube service
        GoogleProperties googleProperties = youTubeService.getGoogleProperties();
        // we get all the playlist from the database
        List<YouTubeChannel> youTubeChannels = youTubeChannelRepository.findAll();
        // if the database document contain data we refresh the data in the other case we create the default channel
        if (youTubeChannels != null && !youTubeChannels.isEmpty()) {
            youTubeChannels.forEach(youTubeChannel -> {
                youTubeChannel.setYouTubePlaylist(youTubeService.getPlaylist(youTubeChannel.getId()));
                youTubeChannelRepository.save(youTubeChannel);
            });
        }

        // the default channel should be allays refresh or present
        String defaultYouTubeChannelId = googleProperties.getChannel();
        YouTubeChannel defaultChannel = youTubeChannelRepository.findOne(defaultYouTubeChannelId);
        if (defaultChannel == null) {
            youTubeChannelRepository.save(new YouTubeChannel(defaultYouTubeChannelId, youTubeService.getPlaylist(defaultYouTubeChannelId)));
        }
    }
}
