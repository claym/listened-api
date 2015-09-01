package io.listened.api.repo;

import io.listened.common.model.podcast.Keyword;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Clay on 8/31/2015.
 */
@RepositoryRestResource(itemResourceRel = "keyword", collectionResourceRel = "keyword", path = "keyword")
public interface KeywordRepository extends PagingAndSortingRepository<Keyword, Long> {
}
