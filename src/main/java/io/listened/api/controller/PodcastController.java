package io.listened.api.controller;

import io.listened.api.configuration.QueueConfig;
import io.listened.api.model.Podcast;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Clay on 6/21/2015.
 */
@RestController
@RequestMapping("/podcast")
public class PodcastController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(method= RequestMethod.POST)
    private Podcast submit(@RequestParam(value = "feedUrl", required = true) String feedUrl) {
        rabbitTemplate.convertAndSend(QueueConfig.podcastSubmitQueueName, feedUrl);
        rabbitTemplate.convertAndSend(QueueConfig.podcastUpdateQueue, feedUrl);
        return new Podcast();
    }

}
