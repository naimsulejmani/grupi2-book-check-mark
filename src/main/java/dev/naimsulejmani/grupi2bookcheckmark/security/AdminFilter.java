package dev.naimsulejmani.grupi2bookcheckmark.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminFilter {
    public static void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getRequestURI().startsWith("/admin")) {
            filterChain.doFilter(request,response);
            return;
        }
        response.sendRedirect("/error403");
    }
}
