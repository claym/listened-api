package io.listened.api.repo;

import io.listened.common.model.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Clay on 6/29/2015.
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {

}
