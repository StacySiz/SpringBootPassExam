package controllers;

import forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.UserRegistrationService;
import validators.RegistrationValidator;

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


    @GetMapping("/registration")
    public String showRegPage(){
        return "registration";
    }

    @PostMapping("registration")
    public String reg(@Valid @ModelAttribute("regForm") RegistrationForm registrationForm,
                      BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("error",result.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/registration";
        }
        registrationService.registration(registrationForm);
        return "index";
    }
}
