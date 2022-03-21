package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Party;
import be.thomasmore.party2.repositories.PartyRepository;
import be.thomasmore.party2.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private VenueRepository venueRepository;

    @ModelAttribute("party")
    public Party findParty(Model model, @PathVariable(required = false) Integer id, Principal principal) {
        logger.info("findParty "+id);
        if (id!=null) {
            Optional<Party> optionalParty = partyRepository.findById(id);
            if (optionalParty.isPresent()) return optionalParty.get();
        }

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return new Party();
    }

    @GetMapping("/partyedit/{id}")
    public String partyEdit(Model model, @PathVariable int id, Principal principal) {
        logger.info("partyedit : "+id);
        model.addAttribute("venues", venueRepository.findAllVenues());

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return "admin/partyedit";
    }

    @PostMapping("/partyedit/{id}")
    public String partyEditPost(Model model, @PathVariable int id, @ModelAttribute("party") Party party, Principal principal) {
        logger.info("partyEditPost " + id + " -- new name=" + party.getName());
        partyRepository.save(party);

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return "redirect:/partydetails/"+id;
    }

    @GetMapping("/partynew")
    public String partyNew(Model model, Principal principal) {
        model.addAttribute("venues", venueRepository.findAllVenues());

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return "admin/partynew";
    }

    @PostMapping("/partynew")
    public String partyNewPost(Model model, @ModelAttribute("party") Party party, Principal principal) {
        logger.info("partyNewPost -- new name=" + party.getName() + ", date=" + party.getDate());
        partyRepository.save(party);

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return "redirect:/partydetails/"+party.getId();
    }
}
