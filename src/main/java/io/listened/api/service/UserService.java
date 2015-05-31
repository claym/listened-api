package io.listened.api.service;

import io.listened.api.exception.EmailExistsException;
import io.listened.api.model.User;
import io.listened.api.repo.RoleRepository;
import io.listened.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Clay on 5/29/2015.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    public User createUser(String email, String password) {
        this.userRepo.findByEmailIgnoreCase(email).ifPresent(e -> { throw new EmailExistsException(e.getEmail()); });
        User user = new User();
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String encoded = b.encode(password);
        user.setEmail(email);
        user.setPassword(encoded);
        user = userRepo.save(user);
        return user;
    }


}
