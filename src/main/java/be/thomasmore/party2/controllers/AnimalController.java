package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Animal;
import be.thomasmore.party2.model.Artist;
import be.thomasmore.party2.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping({"animaldetails", "/animaldetails/{id}"})
    public String artistDetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {
        if (id==null) return "venuedetails";
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            model.addAttribute("animal", optionalAnimal.get());
            model.addAttribute("parties", optionalAnimal.get().getParties());
        }

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("principal", principal);

        return "animaldetails";
    }
}
