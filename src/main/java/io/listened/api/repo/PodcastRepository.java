package io.listened.api.repo;

import io.listened.common.model.Podcast;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Clay on 6/21/2015.
 */
public interface PodcastRepository extends CrudRepository<Podcast, Long> {
    Optional<Podcast> findByFeedUrlIgnoreCase(String feedUrl);
}
