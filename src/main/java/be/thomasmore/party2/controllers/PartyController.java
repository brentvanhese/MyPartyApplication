package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Animal;
import be.thomasmore.party2.model.Artist;
import be.thomasmore.party2.model.Party;
import be.thomasmore.party2.repositories.AnimalRepository;
import be.thomasmore.party2.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@Controller
public class PartyController {
    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping({"/partylist", "/partylist/{something}"})
    public String partylist(Model model) {
        Iterable<Party> allParties = partyRepository.findAll();
        model.addAttribute("parties", allParties);
        model.addAttribute("nrParties", partyRepository.count());

        return "partylist";
    }

    @GetMapping({"partydetails", "/partydetails/{id}"})
    public String partydetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {
        if (id==null) return "venuedetails";
        Optional<Party> optionalParty = partyRepository.findById(id);
        Optional<Party> optionalPrev = partyRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Party> optionalNext = partyRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalParty.isPresent()) {
            model.addAttribute("party", optionalParty.get());
            model.addAttribute("artists", optionalParty.get().getArtists());
            model.addAttribute("animals", optionalParty.get().getAnimals());
            model.addAttribute("id", optionalParty.get().getId());
            if(principal!=null){
                Optional<Animal> optionalAnimal = animalRepository.findByUsername(principal.getName());
                model.addAttribute("animal", optionalAnimal.get());
            }
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", partyRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", partyRepository.findFirstByOrderByIdAsc().get().getId());
        }

        return "partydetails";
    }

    @PostMapping("/partygoing")
    public String partyGoingPost(Principal principal, @RequestParam int partyId, @RequestParam int animalId) {
        Optional<Party> optionalParty = partyRepository.findById(partyId);
        if (optionalParty.isPresent() && principal!=null) {
            Party party = optionalParty.get();
            Optional<Animal> optionalAnimal = animalRepository.findById(animalId);
            if (optionalAnimal.isPresent()) {
                Animal animal = optionalAnimal.get();
                if (animal.getUser()!=null && animal.getUser().getUsername()==principal.getName()) {
                    Collection<Animal> goingAnimals = party.getAnimals();
                    if (goingAnimals.contains(animal)) {
                        goingAnimals.remove(animal);
                    } else {
                        goingAnimals.add(animal);
                    }
                    party.setAnimals(goingAnimals);
                    partyRepository.save(party);
                }
            }
        }
        return "redirect:/partydetails/"+partyId;
    }
}
