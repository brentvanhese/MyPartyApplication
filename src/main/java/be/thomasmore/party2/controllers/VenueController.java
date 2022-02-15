package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Venue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenueController {

    @GetMapping("/venuedetails")
    public String venuedetails(Model model) {
        Venue v = new Venue("Den Aalmoeznier", "https://denaalmoeznier.weebly.com/");
        v.setCapacity(100);
        v.setFoodProvided(true);
        v.setIndoor(true);
        v.setOutdoor(false);
        v.setFreeParkingAvailable(false);
        v.setDistanceFromPublicTransportInKm(1.0);
        v.setCity("Antwerpen");
        model.addAttribute("venue", v);
        return "venuedetails";
    }
}
