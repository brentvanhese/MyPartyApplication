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

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        Iterable<Venue> allVenues = venueRepository.findAll();
        Boolean allSelected = true;
        model.addAttribute("venues", allVenues);
        model.addAttribute("allSelected", allSelected);
        return "venuelist";
    }

    @GetMapping({ "/venuelist/outdoor", "/venuelist/outdoor/{filter}"})
    public String venueListOutdoor(Model model, @PathVariable(required = false) String filter) {
        if (filter==null){
            return "venuelist";
        }
        Iterable<Venue> venues;
        Boolean selectedOutdoor = null;
        if (filter.equals("no")){
            venues = venueRepository.findByOutdoor(false);
            Boolean noSelectedOutdoor = true;
            model.addAttribute("noSelectedOutdoor", noSelectedOutdoor);
        }
        else{
            venues = venueRepository.findByOutdoor(true);
            Boolean yesSelectedOutdoor = true;
            model.addAttribute("yesSelectedOutdoor", yesSelectedOutdoor);
        }
        model.addAttribute("venues", venues);
        return "venuelist";
    }

    @GetMapping({"/venuelist/indoor", "/venuelist/indoor/{filter}"})
    public String venueListIndoor(Model model, @PathVariable(required = false) String filter){
        if (filter==null){
            return "venuelist";
        }
        Iterable<Venue> venues;
        Boolean selectedindoor = null;
        if (filter.equals("no")){
            venues = venueRepository.findByIndoor(false);
            Boolean noSelectedIndoor = true;
            model.addAttribute("noSelectedIndoor", noSelectedIndoor);
        }
        else{
            venues = venueRepository.findByIndoor(true);
            Boolean yesSelectedIndoor = true;
            model.addAttribute("yesSelectedIndoor", yesSelectedIndoor);
        }
        model.addAttribute("venues", venues);
        return "venuelist";
    }
}
