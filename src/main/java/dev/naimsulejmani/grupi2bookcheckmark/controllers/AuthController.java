package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.LoginRequestDto;
import dev.naimsulejmani.grupi2bookcheckmark.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequestDto", new LoginRequestDto());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginRequestDto loginRequestDto
            , BindingResult bindingResult
            , HttpServletResponse response
    ) {
        if (bindingResult.hasErrors()) {
            return "auth/login";
        }

        var userDto = userService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        if (userDto == null) {
            bindingResult.rejectValue("username", "", "Wrong username or password!");
            bindingResult.rejectValue("password", "", "Wrong username or password!");
            return "auth/login";
        }

        Cookie cookie = new Cookie("userId", String.valueOf(userDto.getId()));
        if (loginRequestDto.isRememberMe())
            cookie.setMaxAge(60 * 60 * 24); // 1 day cookie
        else
            cookie.setMaxAge(60 * 60); //1 hour
        response.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}
