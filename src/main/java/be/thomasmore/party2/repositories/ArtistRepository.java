package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Artist;
import be.thomasmore.party2.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    Iterable<Artist> findByArtistNameContainsIgnoreCase(String artistName);
}
