package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Party;
import be.thomasmore.party2.repositories.PartyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private PartyRepository partyRepository;

    @GetMapping("/partyedit/{id}")
    public String partyEdit(Model model, @PathVariable int id) {
        logger.info("partyedit"+id);
        Optional<Party> optionalParty = partyRepository.findById(id);
        if (optionalParty.isPresent()) {
            model.addAttribute("party", optionalParty.get());
        }
        return "admin/partyedit";
    }

    @PostMapping("/partyedit/{id}")
    public String partyEditPost(Model model, @PathVariable int id, @ModelAttribute("party") Party party) {
        logger.info("partyeditpost : " + id + " -- new name: " + party.getName());
        Optional<Party> optionalParty = partyRepository.findById(id);
        if (optionalParty.isPresent()) {
            Party partyToUpdate = optionalParty.get();
            partyToUpdate.setName(party.getName());
            partyToUpdate.setPriceInEur(party.getPriceInEur());
            partyToUpdate.setPricePresaleInEur(party.getPricePresaleInEur());
            partyToUpdate.setExtraInfo(party.getExtraInfo());
            partyRepository.save(partyToUpdate);
        }
        return "redirect:/partydetails/"+id;
    }
}
