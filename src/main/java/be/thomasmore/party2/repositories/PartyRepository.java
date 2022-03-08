package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Party;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Integer> {
    @Query("SELECT p FROM Party p WHERE p.venue.id = ?1")
    Iterable<Party> findByVenueId(int venueId);
}
