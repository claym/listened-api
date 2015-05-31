package io.listened.api.repo;

import io.listened.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Clay on 5/24/2015.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Collection<User> findAll();
    Optional<User> findByNameIgnoreCase(String name);
    Optional<User> findByEmailIgnoreCase(String email);
    User findOne(Long aLong);
}
