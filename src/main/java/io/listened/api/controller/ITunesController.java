package io.listened.api.controller;

import com.google.common.collect.Lists;
import io.listened.api.repo.GenreRepository;
import io.listened.api.service.ITunesService;
import io.listened.common.model.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Clay on 6/28/2015.
 * Handles loading, saving, retrieving itunes genres
 */
//@RestController
//@RequestMapping(value = "/genre")
public class ITunesController {

    private static final Logger log = LoggerFactory.getLogger(ITunesController.class);

    @Autowired
    ITunesService iTunesService;

    @Autowired
    GenreRepository genreRepository;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    private List<Genre> findAllGenre() {
        return Lists.newArrayList(genreRepository.findAll());
    }

    @RequestMapping(value = "/{genreId}", method = RequestMethod.GET)
    private Genre getGenre(@PathVariable Long genreId) {
        return genreRepository.findOne(genreId);
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<Genre> search(@RequestParam("name") String name) {
        if(name != null) {
            //return genreRepository.findByName("%"+name+"%");
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    private Genre saveGenre(@RequestBody Genre genre) {
        log.info("Got genre:");
        log.info(genre.toString());
        Genre saved = iTunesService.saveGenre(genre);
        return saved;
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    private void loadGenres() {
        iTunesService.sendGenreLoadMessage();
    }

}
