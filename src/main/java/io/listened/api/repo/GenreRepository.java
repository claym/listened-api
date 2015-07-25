package io.listened.api.repo;

import io.listened.common.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Clay on 6/29/2015.
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findByNameLikeIgnoreCase(String name);
}
