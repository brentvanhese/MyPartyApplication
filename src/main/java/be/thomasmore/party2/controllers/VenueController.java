package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Venue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenueController {

    @GetMapping("/venuedetails")
    public String venuedetails(Model model) {
        Venue v = new Venue("BoesjKammeree", "https://www.facebook.com/boesjKammeree");
        model.addAttribute("venue", v);
        return "venuedetails";
    }
}
