package io.listened.api.controller;

import io.listened.api.exception.FeedExistsException;
import io.listened.api.exception.PodcastNotFoundException;
import io.listened.api.repo.PodcastRepository;
import io.listened.api.service.PodcastService;
import io.listened.common.model.podcast.Podcast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Clay on 6/21/2015.
 * REST Controller for handling retrieval, submission and updates of podcasts
 */

//@RequestMapping("/podcast")
public class PodcastController {

    private static final Logger log = LoggerFactory.getLogger(PodcastController.class);

    @Autowired
    PodcastService podcastService;

    @Autowired
    PodcastRepository podcastRepository;

    @RequestMapping(method = RequestMethod.POST)
    private Podcast submit(@RequestParam(value = "feedUrl", required = true) String feedUrl) {
        log.info("Podcast submitted: {}", feedUrl);
        Podcast podcast = podcastService.submitPodcast(feedUrl);
        log.info("Podcast created: {}", podcast.getId());
        return podcast;
    }

    @RequestMapping(value = "/{podcastId}", method = RequestMethod.GET)
    private Podcast load(@PathVariable Long podcastId) {
        log.debug("Retrieving podcast {}", podcastId);
        Podcast podcast = podcastRepository.findOne(podcastId);
        log.debug("Retrieved podcast: {}", podcast.toString());
        return podcast;
    }

    @RequestMapping(value = "/{podcastId}/ping", method = RequestMethod.GET)
    private String ping(@PathVariable Long podcastId) {
        Podcast podcast = podcastRepository.findOne(podcastId);
        if (podcast == null) {
            throw new PodcastNotFoundException(podcastId);
        }
        return null;
    }

    @RequestMapping(value = "/{podcastId}", method = RequestMethod.PUT)
    private Podcast update(@PathVariable Long podcastId, @RequestBody Podcast updatedPodcast) {
        log.info("Got podcast: {}", podcastId);
        log.debug(updatedPodcast.toString());
        Podcast podcast = podcastRepository.findOne(podcastId);
        if (podcast == null) {
            throw new PodcastNotFoundException(podcastId);
        }
        podcast = podcastRepository.save(updatedPodcast);
        log.info("Saved podcast {}", podcast.getId());
        log.debug(podcast.toString());
        return podcast;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Podcast id not found")
    @ExceptionHandler(PodcastNotFoundException.class)
    public void podcastNotFoundHandler(HttpServletResponse response, Exception ex) throws IOException {
        // do nothing
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Feed already exists")
    @ExceptionHandler(FeedExistsException.class)
    public void feedExistsException(HttpServletResponse response, Exception ex) throws IOException {
        // do nothing
    }

}
