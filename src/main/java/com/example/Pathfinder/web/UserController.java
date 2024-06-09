package com.example.Pathfinder.web;

import com.example.Pathfinder.service.DTO.UserRegisterDTO;
import com.example.Pathfinder.service.LoginService;
import com.example.Pathfinder.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {

    //Login:

    private LoginService loginService;

    public UserController(LoginService loginService) {this.loginService = loginService;}

    @GetMapping("/users/login")
    public String showLoginPage() {return "login";}

    @PostMapping("/users/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {

        if(loginService.checkCredentials(username,password)){
            return "index";
        }else {
            return "login";
        }
    }

    //Register:

    private RegisterService registerService;

    public UserController(RegisterService registerService) {}

    @GetMapping("/users/register")
    public String showRegisterPage() {return "register";}

    @PostMapping("/users/register")
    public String registerUser(Model model, @Valid UserRegisterDTO data, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){

            return "redirect:/users/register";
        }

            return "redirect:/users/login";

    }
}
