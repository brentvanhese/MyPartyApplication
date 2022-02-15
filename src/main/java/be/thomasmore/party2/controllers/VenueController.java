package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Venue;
import be.thomasmore.party2.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venuedetails")
    public String venueDetails(Model model) {
        Optional<Venue> optionalVenue = venueRepository.findById(1);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        return "venuedetails";
    }
}
