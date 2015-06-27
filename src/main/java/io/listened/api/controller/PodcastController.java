package io.listened.api.controller;

import io.listened.api.repo.PodcastRepository;
import io.listened.api.service.PodcastService;
import io.listened.common.model.Podcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Clay on 6/21/2015.
 */
@RestController
@RequestMapping("/podcast")
public class PodcastController {

    @Autowired
    PodcastService podcastService;

    @Autowired
    PodcastRepository podcastRepository;

    @RequestMapping(method = RequestMethod.POST)
    private Podcast submit(@RequestParam(value = "feedUrl", required = true) String feedUrl) {
        Podcast podcast = podcastService.submitPodcast(feedUrl);
        return podcast;
    }

    @RequestMapping(value = "/{podcastId}", method = RequestMethod.GET)
    private Podcast load(@PathVariable Long podcastId) {
        Podcast podcast = podcastRepository.findOne(podcastId);
        return podcast;
    }

}
