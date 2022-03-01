package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Artist;
import be.thomasmore.party2.model.Venue;
import be.thomasmore.party2.repositories.ArtistRepository;
import be.thomasmore.party2.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Optional;

@Controller
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;
    private Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @GetMapping("/artistlist")
    public String artistlist(Model model){
        Iterable<Artist> allArtists = artistRepository.findAll();
        model.addAttribute("artists", allArtists);
        model.addAttribute("nrArtists", artistRepository.count());
        return "artistlist";
    }

    @GetMapping("/artistlist/filter")
    public String artistlistWithFilter(Model model, @RequestParam(required = false) String keyword) {
        Iterable<Artist> allArtists = null;
        if(keyword==null){
            allArtists = artistRepository.findAll();
        }else{
            allArtists = artistRepository.findByArtistNameContainsIgnoreCase(keyword);
        }
        model.addAttribute("showFilter", true);
        model.addAttribute("artists", allArtists);
        model.addAttribute("nrArtists", allArtists.spliterator().getExactSizeIfKnown());
        model.addAttribute("keyword", keyword);
        return "artistlist";
    }

    @GetMapping({"artistdetails", "/artistdetails/{id}"})
    public String artistDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "venuedetails";
        Optional<Artist> optionalArtist = artistRepository.findById(id);
        if (optionalArtist.isPresent()) {
            model.addAttribute("artist", optionalArtist.get());
        }
        return "artistdetails";
    }
}
