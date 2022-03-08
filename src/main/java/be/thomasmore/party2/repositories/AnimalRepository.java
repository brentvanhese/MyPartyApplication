package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
