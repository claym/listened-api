package io.listened.api;

import com.google.common.collect.Sets;
import io.listened.api.model.Role;
import io.listened.api.model.User;
import io.listened.api.repo.RoleRepository;
import io.listened.api.repo.UserRepository;
import io.listened.api.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class ListenedAPI {


    public static void main(String[] args) {

        SpringApplication.run(ListenedAPI.class, args);
    }

    @Bean
    @Order(1)
    CommandLineRunner setupRoles(final RoleRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {


                Collection<Role> roles = Arrays.asList(
                        new Role("ROLE_SUPER_ADMIN", "Highest available role"),
                        new Role("ROLE_ADMIN", "Administrator role"),
                        new Role("ROLE_OWNER", "Subject owner"),
                        new Role("ROLE_MODERATOR", "Subject moderator"),
                        new Role("ROLE_USER", "Normal user role"),
                        new Role("ROLE_USER_UNVERIFIED", "Unverified user")
                );

                repo.save(roles);
            }
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner setupUser(final UserService userService, final UserRepository userRepo, RoleRepository roleRepo) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                if (userRepo.findAll().size() == 0) {
                    User user = userService.createUser("clay@pfd.net", "temppassword");
                    Iterable<Role> roles = roleRepo.findAll();
                    user.setRoles(Sets.newHashSet(roles));
                    userRepo.save(user);
                }
            }

        };

    }


}
