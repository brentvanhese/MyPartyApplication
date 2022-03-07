package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Venue;
import be.thomasmore.party2.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    private Logger logger = LoggerFactory.getLogger(VenueController.class);

    @GetMapping({"venuedetails", "/venuedetails/{id}"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "venuedetails";
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        Optional<Venue> optionalPrev = venueRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Venue> optionalNext = venueRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
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
        return "venuedetails";
    }

    @GetMapping({"/venuelist", "/venuelist/{something}"})
    public String venuelist(Model model) {
        Iterable<Venue> allVenues = venueRepository.findAllVenues();
        model.addAttribute("venues", allVenues);
        model.addAttribute("nrVenues", venueRepository.count());
        return "venuelist";
    }

    @GetMapping("/venuelist/filter")
    public String venueListWithFilter(Model model, @RequestParam(required = false) Integer minimumCapacity, @RequestParam(required = false) Integer maximumCapacity, @RequestParam(required = false) Double maxDistance, @RequestParam(required = false) String filterFood, @RequestParam(required = false) String filterIndoor, @RequestParam(required = false) String filterOutdoor) {
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
        return "venuelist";
    }
}
