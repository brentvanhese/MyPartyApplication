package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Integer> {
    Iterable<Venue> findByOutdoor(boolean isOutdoor);
    Iterable<Venue> findByIndoor(boolean isIndoor);
    Iterable<Venue> findByCapacityLessThan(int equal);
    Iterable<Venue> findByCapacityIsBetween(int less, int equal);
    Iterable<Venue> findByCapacityGreaterThan(int equal);
}