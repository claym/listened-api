package io.listened.api.service;

import io.listened.api.exception.FeedExistsException;
import io.listened.api.repo.PodcastRepository;
import io.listened.common.constants.JobQueues;
import io.listened.common.model.podcast.Podcast;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Clay on 6/21/2015.
 */
@Service
public class PodcastService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    PodcastRepository podcastRepository;

    public Podcast submitPodcast(String feedUrl) {
        podcastRepository.findByFeedUrlIgnoreCase(feedUrl).ifPresent(e -> {
            throw new FeedExistsException(feedUrl);
        });
        Podcast podcast = new Podcast();
        podcast.setFeedUrl(feedUrl);
        podcast = podcastRepository.save(podcast);
        rabbitTemplate.convertAndSend(JobQueues.JOB_PODCAST_ADD, podcast.getId());
        return podcast;
    }

    public void updatePodcast(Long podcastId, boolean fullUpdate) {
        if(fullUpdate) {
            rabbitTemplate.convertAndSend(JobQueues.JOB_PODCAST_REFRESH, podcastId);
        } else {
            rabbitTemplate.convertAndSend(JobQueues.JOB_PODCAST_UPDATE, podcastId);
        }
    }

    public Podcast getPodcast(Long podcastId) {
        return podcastRepository.findOne(podcastId);
    }
}
