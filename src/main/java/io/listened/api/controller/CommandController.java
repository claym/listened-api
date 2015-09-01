package io.listened.api.controller;

import io.listened.api.service.ITunesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Clay on 7/25/2015.
 */
@RestController
@RequestMapping("/command")
public class CommandController {
    @Autowired
    ITunesService iTunesService;

    @RequestMapping(value = "/genre/load", method = RequestMethod.POST)
    private void loadGenres() {
        iTunesService.sendGenreLoadMessage();
    }

}
