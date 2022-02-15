package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Client;
import be.thomasmore.party2.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
