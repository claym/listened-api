package io.listened.api.service;

import io.listened.api.repo.GenreRepository;
import io.listened.common.constants.JobQueues;
import io.listened.common.model.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Clay on 6/29/2015.
 * Assorted services for dealing with iTunes objects
 */
@Service
public class ITunesService {

    private static final Logger log = LoggerFactory.getLogger(ITunesService.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    GenreRepository genreRepo;

    public void sendGenreLoadMessage() {
        log.info("Request genre load");
        rabbitTemplate.convertAndSend(JobQueues.JOB_ITUNES_GENRE, "go");
    }

    public Genre saveGenre(Genre genre) {
        Genre saved = genreRepo.save(genre);
        return saved;
    }

}
