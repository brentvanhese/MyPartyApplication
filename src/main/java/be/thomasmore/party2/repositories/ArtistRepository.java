package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Artist;
import be.thomasmore.party2.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    Iterable<Artist> findByArtistNameContainsIgnoreCase(String artistName);

    @Query("SELECT a FROM Artist a WHERE :word IS NULL OR LOWER(a.artistName) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(a.bio) LIKE LOWER(CONCAT('%',:word,'%')) " +
            "OR LOWER(a.portfolio) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(a.genre) LIKE LOWER(CONCAT('%',:word,'%'))")
    Iterable<Artist> findByKeyword(@Param("word") String word);
}
