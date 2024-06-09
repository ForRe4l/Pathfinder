package com.example.Pathfinder.web;

import com.example.Pathfinder.service.DTO.UserRegisterDTO;
import com.example.Pathfinder.service.LoginService;
import com.example.Pathfinder.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private RegisterService registerService;
    private LoginService loginService;

    //Login:

    public UserController(LoginService loginService,RegisterService registerService) {}

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

    @GetMapping("/users/register")
    public String showRegisterPage() {return "register";}

    @PostMapping("/users/register")
    public String registerUser(Model model,
                               @Valid UserRegisterDTO data,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerData", data);
            return "redirect:/users/register";
        }

            return "redirect:/users/login";
    }
}
