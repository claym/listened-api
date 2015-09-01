package io.listened.api.event;

import io.listened.common.constants.JobQueues;
import io.listened.common.model.podcast.Podcast;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by Clay on 8/14/2015.
 */
@Slf4j
@Component
@RepositoryEventHandler(Podcast.class)
public class PodcastEventHandler {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @HandleBeforeCreate(Podcast.class)
    public void handleBeforeCreate(Podcast podcast) {
        log.info("Before create {}", podcast.getFeedUrl());
    }

    @HandleAfterCreate(Podcast.class)
    public void handleAfterCreate(Podcast podcast) {
        log.info("Submitting: Podcast {}", podcast.getId());
        rabbitTemplate.convertAndSend(JobQueues.JOB_PODCAST_ADD, podcast.getId());
    }

}
