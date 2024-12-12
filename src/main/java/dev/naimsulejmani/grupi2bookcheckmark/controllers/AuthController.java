package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.LoginRequestDto;
import dev.naimsulejmani.grupi2bookcheckmark.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String login(
            @Valid @ModelAttribute LoginRequestDto loginRequestDto
            , BindingResult bindingResult
            , HttpServletRequest request
            , HttpServletResponse response
            , @RequestParam(value = "returnUrl", required = false) String returnUrl
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

        HttpSession session = request.getSession(); // krijo nje session te ri
        session.setAttribute("user", userDto);
        session.setAttribute("grupi", "2");
//        session.setAttribute("items", "laptop lenovo x carbon");


        Cookie cookie = new Cookie("userId", String.valueOf(userDto.getId()));
        if (loginRequestDto.isRememberMe())
            cookie.setMaxAge(60 * 60 * 24); // 1 day cookie
        else
            cookie.setMaxAge(60 * 60); //1 hour
        response.addCookie(cookie);

        if (returnUrl != null && !returnUrl.isBlank())
            return "redirect:" + returnUrl;

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        // make cookie expire / invalid
        Cookie cookie = new Cookie("userId", "");
        cookie.setMaxAge(0); // 0 seconds available
        response.addCookie(cookie);
        return "redirect:/login";
    }

}


















