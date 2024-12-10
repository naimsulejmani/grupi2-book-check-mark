package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class HomeController {

    @GetMapping("")
    public String home(HttpServletRequest request, HttpServletResponse response) {

//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("id")) {
//                    System.out.println("Cookie found: " + cookie.getValue());
//                    return "redirect:/authors";
//                }
//            }
//        }
//        //service mi jep userlistdto
//
//        Cookie cookie = new Cookie("id", UUID.randomUUID().toString());
//        cookie.setMaxAge(60 * 60 * 24 * 365); // 1 year
//        response.addCookie(cookie);
        return "index";
    }
}
