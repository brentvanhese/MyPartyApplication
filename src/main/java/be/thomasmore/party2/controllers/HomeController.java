package be.thomasmore.party2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    @GetMapping({"/", "/home"})
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){

        return "about";
    }

    @GetMapping("/pay")
    public String pay(Model model){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before formatting: " + now);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatDateTimeNow = now.format(format);
        System.out.println("After formatting: " + formatDateTimeNow);
        model.addAttribute("dateToday", formatDateTimeNow);

        LocalDateTime dateToPay = now.plusDays(30);
        System.out.println("Before formatting: " + dateToPay);
        String formatDateTime30Days = dateToPay.format(format);
        System.out.println("After formatting: " + formatDateTime30Days);
        model.addAttribute("dateToPay", formatDateTime30Days);

        boolean weekend = now.getDayOfWeek().equals(DayOfWeek.SATURDAY) || now.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        model.addAttribute("weekend", weekend);

        return "pay";
    }

}
