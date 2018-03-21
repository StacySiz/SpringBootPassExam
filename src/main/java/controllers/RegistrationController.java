package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validators.RegistrationValidator;

@RestController
public class RegistrationController {

    RegistrationValidator registrationValidator;

    @InitBinder
    public void addValidator(WebDataBinder dataBinder){
        dataBinder.addValidators(registrationValidator);
    }

    @RequestMapping("/registration")
    public String showRegPage(){
        return "registration";
    }
}
