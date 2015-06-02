package io.listened.api.controller;

import io.listened.api.model.User;
import io.listened.api.repo.UserRepository;
import io.listened.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Clay on 5/24/2015.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserRepository repo;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestParam(value = "email", required = true) String email,
                          @RequestParam(value = "password", required = true) String password) {
        User user = userService.createUser(email, password);
        return user;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Collection<User> list() {
        return repo.findAll();
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "authed", method = RequestMethod.GET)
    public String authed() {
        return "hello, authenticated";
    }

}


