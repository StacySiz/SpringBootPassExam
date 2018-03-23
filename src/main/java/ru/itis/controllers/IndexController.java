//package ru.itis.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import ru.itis.models.Users;
//import ru.itis.repository.UserRepository;
//
//@Controller
//public class IndexController {
//    private UserRepository repository;
//
//    @GetMapping("/index")
//    public String showIndexandUsers(Model model){
//        Users users = new Users();
//        users.setFirstName("Stacy");
//        users.setLastName("Sizova");
//        users.setEmail("ssssss@mail.ru");
//        users.setPassword("qwerty123");
//        repository.save(users);
////        model.addAttribute("name", users.getFirstName());
//        System.out.println(users.getFirstName());
//        System.out.println(repository.findByEmail(users.getEmail()));
//        return "index";
//    }
//}
