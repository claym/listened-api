package io.listened.api.repo;

import io.listened.api.model.Podcast;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Clay on 6/21/2015.
 */
public interface PodcastRepository extends CrudRepository<Podcast, Long> {

}
