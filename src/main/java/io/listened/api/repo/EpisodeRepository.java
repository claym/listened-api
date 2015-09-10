package io.listened.api.repo;

import io.listened.common.model.podcast.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Clay on 8/31/2015.
 */
@RepositoryRestResource(itemResourceRel = "episode", collectionResourceRel = "episode", path="episode")
public interface EpisodeRepository  extends CrudRepository<Episode, Long> {

    @Query("select e from Episode e where e.podcast.id = :podcastId and e.guid = :guid")
    public Episode findByGuid(@Param("podcastId") Long podcastId, @Param("guid") String guid);

}
