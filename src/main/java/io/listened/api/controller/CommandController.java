package io.listened.api.controller;

import io.listened.api.exception.PodcastNotFoundException;
import io.listened.api.service.ITunesService;
import io.listened.api.service.PodcastService;
import io.listened.common.model.podcast.Podcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Clay on 7/25/2015.
 */
@RestController
@RequestMapping("/command")
public class CommandController {
    @Autowired
    ITunesService iTunesService;

    @Autowired
    PodcastService podcastService;

    @RequestMapping(value = "/genre/load", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    private void genreLoad() {
        iTunesService.sendGenreLoadMessage();
    }

    @RequestMapping(value = "/podcast/refresh/{podcastId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    private void podcastFullUpdate(@PathVariable Long podcastId) {
        Podcast podcast = podcastService.getPodcast(podcastId);
        if (podcast == null) {
            throw new PodcastNotFoundException(podcastId);
        }
        podcastService.updatePodcast(podcastId, true);
    }

    @RequestMapping(value = "/podcast/update/{podcastId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    private void podcastUpdate(@PathVariable Long podcastId) {
        Podcast podcast = podcastService.getPodcast(podcastId);
        if (podcast == null) {
            throw new PodcastNotFoundException(podcastId);
        }
        podcastService.updatePodcast(podcastId, false);
    }


}
