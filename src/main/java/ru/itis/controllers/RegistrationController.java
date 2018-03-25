package ru.itis.controllers;

import ru.itis.forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.services.UserRegistrationService;
import ru.itis.validators.RegistrationValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
   private UserRegistrationService registrationService;

    @Autowired
    private RegistrationValidator registrationValidator;

    @InitBinder("regForm")
    public void addValidator(WebDataBinder dataBinder){
        dataBinder.addValidators(registrationValidator);
    }

//    @GetMapping("/hey")
//    public String hey(){
//        return "registration";
//    }

    @GetMapping(value = "/registration")
    public String showRegPage(){
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String reg(@Valid @ModelAttribute("regForm") RegistrationForm registrationForm,
                      BindingResult result, RedirectAttributes attributes){
//        if(result.hasErrors()){
//            attributes.addFlashAttribute("error",result.getAllErrors().get(0).getDefaultMessage());
//            return "redirect:/registration";
//        }
        System.out.println("hello there #1!");
        registrationService.registration(registrationForm);
        System.out.println("TEST IS HERE 3");

        return "redirect:/signIn";
    }
}
