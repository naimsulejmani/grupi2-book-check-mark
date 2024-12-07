package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.LoginRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequestDto", new LoginRequestDto());
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}
