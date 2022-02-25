package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Venue;
import be.thomasmore.party2.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping({"venuedetails", "/venuedetails/{id}"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "venuedetails";
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        return "venuedetails";
    }

    @GetMapping({"/venuelist", "/venuelist/{something}"})
    public String venuelist(Model model) {
        Iterable<Venue> allVenues = venueRepository.findAll();
        model.addAttribute("venues", allVenues);
        return "venuelist";
    }

    @GetMapping({ "/venuelist/outdoor", "/venuelist/outdoor/{filter}"})
    public String venuelistOutdoor(Model model, @PathVariable(required = false) String filter) {
        boolean boolFilter = true;
        if (filter!=null && (filter.equals("no") || filter.equals("false"))) boolFilter = false;
        Iterable<Venue> venues = venueRepository.findByOutdoor(boolFilter);
        model.addAttribute("outdoorFilter", boolFilter);
        model.addAttribute("venues", venues);
        return "venuelist";
    }

    @GetMapping({"/venuelist/indoor", "/venuelist/indoor/{filter}"})
    public String venuelistIndoor(Model model, @PathVariable(required = false) String filter){
        boolean boolFilter = true;
        if (filter!=null && (filter.equals("no") || filter.equals("false"))) boolFilter = false;
        Iterable<Venue> venues = venueRepository.findByIndoor(boolFilter);
        model.addAttribute("indoorFilter", boolFilter);
        model.addAttribute("venues", venues);
        return "venuelist";
    }

    @GetMapping({"/venuelist/size/{filter}", "/venuelist/size"})
    public String venuelistSize(Model model, @PathVariable(required = false) String filter){
        if (filter==null) filter = "all";
        if (filter.equals("s")) filter = "S";
        if (filter.equals("m")) filter = "M";
        if (filter.equals("l")) filter = "L";
        if (!filter.equals("S") && !filter.equals("M") && !filter.equals("L")) filter = "all";
        Iterable<Venue> venues;
        if (filter.equals("all")) {
            venues = venueRepository.findAll();
        } else if (filter.equals("S")) {
            venues = venueRepository.findByCapacityLessThan(200);
        } else if (filter.equals("M")) {
            venues = venueRepository.findByCapacityIsBetween(200, 500);
        } else {
            venues = venueRepository.findByCapacityGreaterThan(500);
        }
        model.addAttribute("sizeFilter", filter);
        model.addAttribute("venues", venues);
        return "venuelist";
    }
}
