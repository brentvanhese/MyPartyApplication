package be.thomasmore.party2.controllers;

import be.thomasmore.party2.model.Client;
import be.thomasmore.party2.model.Venue;
import be.thomasmore.party2.repositories.ClientRepository;
import be.thomasmore.party2.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    private String clientCode;

    @GetMapping("/newclient")
    public String greetingNewClient(Model model) {
        Optional<Client> optionalClient = clientRepository.findById(1);
        if (optionalClient.isPresent()) {
            model.addAttribute("client", optionalClient.get());
        }
        //create greeting
        LocalDateTime now = LocalDateTime.now();
        String greeting = "";

        if (now.getHour() <= 12){
            greeting += "Goedemorgen ";
        }
        else if (now.getHour() <= 17){
            greeting += "Goedemiddag ";
        }
        else{
            greeting += "Goedenavond ";
        }

        if (optionalClient.get().getGender().equals("M")){
            greeting += "meneer ";
        }
        else if (optionalClient.get().getGender().equals("F")){
            greeting += "mevrouw ";
        }

        greeting += optionalClient.get().getName();

        model.addAttribute("greeting", greeting);

        return "newClient";
    }

    @GetMapping("/showcode")
    public String showSecretCode(Model model){
        Optional<Client> optionalClient = clientRepository.findById(1);
        if (optionalClient.isPresent()) {
            model.addAttribute("client", optionalClient.get());
        }
        generateClientCode(optionalClient.get().getName(), optionalClient.get().getBirthdate());

        //show client code
        String showClientCode = "";

        if (optionalClient.get().getGender().equals("M")){
            showClientCode += "meneer ";
        }
        else if (optionalClient.get().getGender().equals("F")){
            showClientCode += "mevrouw ";
        }

        showClientCode += optionalClient.get().getName() + ", uw secretcode is " + clientCode;

        model.addAttribute("clientCode", showClientCode);

        return "showSecretCode";
    }

    public void generateClientCode(String name, Date birthDate){
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);

        String firstLetters = name.substring(0,2);
        String lastLetters = name.substring(name.length() - 2);
        int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
        int randomNum = random.nextInt(calendar.get(Calendar.YEAR));

        clientCode = firstLetters + lastLetters + birthDay + randomNum;
    }

}
