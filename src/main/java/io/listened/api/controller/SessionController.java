package io.listened.api.controller;

import io.listened.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Clay on 5/27/2015.
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    UserRepository repo;

    @RequestMapping(method = RequestMethod.DELETE)
    public void logout() {

    }

    @RequestMapping(method = RequestMethod.POST)
    public void login(@RequestParam(value = "email", required = true) String email,
                      @RequestParam(value = "password", required = true) String password) {

    }
}
