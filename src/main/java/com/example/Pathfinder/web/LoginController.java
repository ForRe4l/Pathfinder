package com.example.Pathfinder.web;

import com.example.Pathfinder.service.DTO.RouteShortDTO;
import com.example.Pathfinder.service.DTO.UserLoginDTO;
import com.example.Pathfinder.service.LoginService;
import com.example.Pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
@GetMapping("/users/login")
    public String showLoginPage() {

//26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b
    return "login";
}
    @PostMapping("/users/login")
    public String login( Model model,@RequestParam("username") String username,@RequestParam("password") String password) {

        if(loginService.checkCredentials(username,password)){
            System.out.println("here");
            return "index";
        }else {
            System.out.println("here2");
            return "login";
        }



    }
}
