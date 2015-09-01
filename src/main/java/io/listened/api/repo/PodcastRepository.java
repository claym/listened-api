package io.listened.api.repo;

import io.listened.common.model.podcast.Podcast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Created by Clay on 6/21/2015.
 */
@RepositoryRestResource(itemResourceRel = "podcast", collectionResourceRel = "podcast", path="podcast")
public interface PodcastRepository extends PagingAndSortingRepository<Podcast, Long> {
    Optional<Podcast> findByFeedUrlIgnoreCase(String feedUrl);
}
