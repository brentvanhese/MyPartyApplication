package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Party;
import be.thomasmore.party2.model.Venue;
import be.thomasmore.party2.repositories.PartyRepository;
import be.thomasmore.party2.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private PartyRepository partyRepository;

    private Logger logger = LoggerFactory.getLogger(VenueController.class);

    @GetMapping({"venuedetails", "/venuedetails/{id}"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {
        if (id==null) return "venuedetails";
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        Iterable<Party> optionalParties = partyRepository.findByVenueId(optionalVenue.get().getId());
        Optional<Venue> optionalPrev = venueRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Venue> optionalNext = venueRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
            model.addAttribute("parties", optionalParties);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", venueRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", venueRepository.findFirstByOrderByIdAsc().get().getId());
        }

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("principal", principal);

        return "venuedetails";
    }

    @GetMapping({"/venuelist", "/venuelist/{something}"})
    public String venuelist(Model model, Principal principal) {
        Iterable<Venue> allVenues = venueRepository.findAllVenues();
        model.addAttribute("venues", allVenues);
        model.addAttribute("nrVenues", venueRepository.count());

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("principal", principal);

        return "venuelist";
    }

    @GetMapping("/venuelist/filter")
    public String venueListWithFilter(Model model, @RequestParam(required = false) Integer minimumCapacity, @RequestParam(required = false) Integer maximumCapacity, @RequestParam(required = false) Double maxDistance, @RequestParam(required = false) String filterFood, @RequestParam(required = false) String filterIndoor, @RequestParam(required = false) String filterOutdoor, Principal principal) {
        logger.info(String.format("venueListWithFilter -- min=%d", minimumCapacity));
        Iterable<Venue> allVenues = venueRepository.findByCapacityBetweenQuery(minimumCapacity, maximumCapacity, maxDistance, filterFood, filterIndoor, filterOutdoor);
        model.addAttribute("venues", allVenues);
        model.addAttribute("nrVenues", allVenues.spliterator().getExactSizeIfKnown());
        model.addAttribute("showFilter", true);
        model.addAttribute("minCapacity", minimumCapacity);
        model.addAttribute("maxCapacity", maximumCapacity);
        model.addAttribute("maxDistance", maxDistance);
        model.addAttribute("foodProvided", filterFood);
        model.addAttribute("indoor", filterIndoor);
        model.addAttribute("outdoor", filterOutdoor);

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("principal", principal);

        return "venuelist";
    }
}
