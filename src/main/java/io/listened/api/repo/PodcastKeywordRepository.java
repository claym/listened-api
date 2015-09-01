package io.listened.api.repo;

import io.listened.common.model.podcast.PodcastKeyword;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Clay on 8/31/2015.
 */
@RepositoryRestResource(itemResourceRel = "podcastKeyword", collectionResourceRel = "podcastKeyword", path = "podcastKeyword")
public interface PodcastKeywordRepository extends PagingAndSortingRepository<PodcastKeyword, Long> {
}
