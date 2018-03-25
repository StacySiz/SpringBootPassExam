package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.models.Users;
import ru.itis.repository.UserRepository;
import ru.itis.security.enums.Role;

@Controller
public class TestDBController {
    @Autowired
    UserRepository repository;
    @GetMapping(value = "/index")
    public String fillIn(Model model){
        Users newUser = new Users();
        newUser.setFirstName("Stacy");
        newUser.setLastName("Sizova");
        newUser.setEmail("this@mail.ru");
        newUser.setPassword("password");
        newUser.setRole(Role.USER);
        newUser.setId((long) 3);
        repository.save(newUser);
        model.addAttribute("user",newUser);
        return "index";
    }
}
