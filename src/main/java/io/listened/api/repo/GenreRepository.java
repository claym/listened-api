package io.listened.api.repo;

import io.listened.common.model.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Clay on 6/29/2015.
 */
@RepositoryRestResource(itemResourceRel = "genre", collectionResourceRel = "genre", path="genre")
public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {
    /**
    Genre findByNameIgnoreCase(@Param("name") String name);

    @Query("select g from Genre g where upper(g.name) like upper(concat('%', :name, '%'))")
    List<Genre> searchByName(@Param("name") String name);

    @Query("select g from Genre g where g.subGenres is empty order by id")
    List<Genre> findGenreLeafs();

    @Query("select g from Genre g where upper(g.name) like upper(:name) and g.subGenres is empty")
    Genre findGenreLeafByName(@Param("name") String name);
    **/

    Genre findByName(@Param("name") String name);
}
