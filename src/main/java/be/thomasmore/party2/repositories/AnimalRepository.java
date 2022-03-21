package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    @Query("SELECT DISTINCT a FROM Animal a JOIN a.user u WHERE u.username = ?1")
    Optional<Animal> findByUsername(String name);
}
