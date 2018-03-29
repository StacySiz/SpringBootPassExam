package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.Users;
import ru.itis.services.AuthenticationService;
import ru.itis.services.DocumentStatsService;
import ru.itis.services.DocumentStatsServiceImpl;
import ru.itis.services.EmailService;

@Controller
public class StatController {

    @Autowired
    private DocumentStatsServiceImpl statsService;

    @Autowired
    private AuthenticationService service;

    @Autowired
    EmailService emailService;

    @GetMapping("/stat")
    public String sendStat(Authentication authentication, ModelMap model){
        Users user = service.getUserByAuthentication(authentication);
        model.addAttribute(service.getUserByAuthentication(authentication));
        String stats = statsService.getResultStat();
        emailService.sendMail(stats,"Stat by OkiDoki", user.getEmail() );
        return "stat";
    }
}
