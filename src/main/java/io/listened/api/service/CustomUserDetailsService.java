package io.listened.api.service;

import io.listened.api.model.User;
import io.listened.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Clay on 5/27/2015.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Email: " + email);
        User user = userRepository.findByEmailIgnoreCase(email).orElseThrow(() ->
                        new UsernameNotFoundException(String.format("'%s' not found", email))
        );
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
        return userDetails;
    }
}
