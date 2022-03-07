package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VenueRepository extends CrudRepository<Venue, Integer> {
    Iterable<Venue> findByOutdoor(boolean isOutdoor);
    Iterable<Venue> findByIndoor(boolean isIndoor);
    Iterable<Venue> findByCapacityLessThanEqual(int equal);
    Iterable<Venue> findByCapacityIsBetween(int less, int equal);
    Iterable<Venue> findByCapacityIsGreaterThanEqual(int equal);
    Optional<Venue> findFirstByIdLessThanOrderByIdDesc(Integer id);
    Optional<Venue> findFirstByIdGreaterThanOrderById(Integer id);
    Optional<Venue> findFirstByOrderByIdDesc();
    Optional<Venue> findFirstByOrderByIdAsc();

    @Query("SELECT v FROM Venue v")
    Iterable<Venue> findAllVenues();

    @Query("SELECT v FROM Venue v WHERE (:min IS NULL OR v.capacity >= :min) AND (:max IS NULL OR v.capacity <= :max) AND (:maxDistance IS NULL OR v.distanceFromPublicTransportInKm <= :maxDistance) AND (:food = 'all' OR :food IS NULL OR v.foodProvided = :food) AND (:indoor = 'all' OR :indoor IS NULL OR v.indoor = :indoor) AND (:outdoor = 'all' OR :outdoor IS NULL OR v.outdoor = :outdoor)")
    Iterable<Venue> findByCapacityBetweenQuery(@Param("min") Integer min, @Param("max") Integer max, @Param("maxDistance") Double maxDistance, @Param("food") String food, @Param("indoor") String indoor, @Param("outdoor") String outdoor);



    @Query("SELECT v FROM Venue v WHERE v.capacity <= ?1")
    Iterable<Venue> findByCapacityLessThanEqualQuery(int equal);

    @Query("SELECT v FROM Venue v WHERE v.capacity >= ?1")
    Iterable<Venue> findByCapacityIsGreaterThanEqualQuery(int equal);


    @Query("SELECT v FROM Venue v WHERE :min IS NULL OR v.capacity >= :min")
    List<Venue> findByBigCapacity(@Param("min") Integer min);
}