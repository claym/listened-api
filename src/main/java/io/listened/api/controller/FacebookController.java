package io.listened.api.controller;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Clay on 6/16/2015.
 */
@RestController
@RequestMapping("/user/auth/facebook")
public class FacebookController {

    @Inject
    private ConnectionRepository connectionRepository;

    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model) {

        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        if (connection == null) {
            return connectionRepository.findAllConnections().toString();
        }

        return connection.getApi().userOperations().getUserProfile().getId();
    }

}
