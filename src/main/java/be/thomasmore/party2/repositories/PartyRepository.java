package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Party;
import be.thomasmore.party2.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartyRepository extends CrudRepository<Party, Integer> {
    Optional<Party> findFirstByIdLessThanOrderByIdDesc(Integer id);
    Optional<Party> findFirstByIdGreaterThanOrderById(Integer id);
    Optional<Party> findFirstByOrderByIdDesc();
    Optional<Party> findFirstByOrderByIdAsc();

    @Query("SELECT p FROM Party p WHERE p.venue.id = ?1")
    Iterable<Party> findByVenueId(int venueId);
}
