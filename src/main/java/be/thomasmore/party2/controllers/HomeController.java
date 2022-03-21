package be.thomasmore.party2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model, Principal principal){
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);
        return "about";
    }

    @GetMapping("/pay")
    public String pay(Model model, Principal principal){
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

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info("homepage - logged in as " + loginName);
        model.addAttribute("principal", principal);

        return "pay";
    }

}
