package io.listened.api.delegate;

import io.listened.api.repo.PodcastRepository;
import io.listened.api.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Clay on 6/21/2015.
 */
@Component
public class PodcastSubmitDelegate {

    @Autowired
    PodcastRepository podcastRepo;

    @Autowired
    PodcastService podcastService;

    public void handleMessage(String message) {
        System.out.println(this.getClass().toGenericString() + " " + message);
    }

}
