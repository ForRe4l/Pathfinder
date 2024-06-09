package com.example.Pathfinder.web;

import com.example.Pathfinder.model.User;
import com.example.Pathfinder.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {}

    @GetMapping("/users/register")
    public String showRegisterPage() {return "register";}

    @PostMapping("/users/register")
    public String registerUser(Model model ) {

       if(registerService.isUnique()){

           return "redirect:/users/login";
       }else{
           return "redirect:/users/register";
       }
    }
}
