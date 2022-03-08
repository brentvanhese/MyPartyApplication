package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Artist;
import be.thomasmore.party2.model.Party;
import be.thomasmore.party2.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PartyController {
    @Autowired
    private PartyRepository partyRepository;

    @GetMapping({"/partylist", "/partylist/{something}"})
    public String partylist(Model model) {
        Iterable<Party> allParties = partyRepository.findAll();
        model.addAttribute("parties", allParties);
        model.addAttribute("nrParties", partyRepository.count());
        return "partylist";
    }

    @GetMapping({"partydetails", "/partydetails/{id}"})
    public String partydetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "venuedetails";
        Optional<Party> optionalParty = partyRepository.findById(id);
        Optional<Party> optionalPrev = partyRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Party> optionalNext = partyRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalParty.isPresent()) {
            model.addAttribute("party", optionalParty.get());
            model.addAttribute("artists", optionalParty.get().getArtists());
            model.addAttribute("animals", optionalParty.get().getAnimals());
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
}
