package be.thomasmore.party2.repositories;

import be.thomasmore.party2.model.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Integer> {
}
