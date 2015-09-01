package io.listened.api.repo;

import io.listened.common.model.podcast.EpisodeKeyword;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Clay on 8/31/2015.
 */
@RepositoryRestResource(itemResourceRel = "episodeKeyword", collectionResourceRel = "episodeKeyword", path = "episodeKeyword")
public interface EpisodeKeywordRepository extends PagingAndSortingRepository<EpisodeKeyword, Long> {
}
