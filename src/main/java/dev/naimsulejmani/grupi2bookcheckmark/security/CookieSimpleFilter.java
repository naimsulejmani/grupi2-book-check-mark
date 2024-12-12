package dev.naimsulejmani.grupi2bookcheckmark.security;

import dev.naimsulejmani.grupi2bookcheckmark.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class CookieSimpleFilter extends OncePerRequestFilter {

    private final UserService userService;

    public CookieSimpleFilter(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //skip filter for assets - image, css, js, etc static folder
        if (request.getRequestURI().startsWith("/assets")) {
            filterChain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            if (request.getRequestURI().startsWith("/login") || request.getRequestURI().startsWith("/register")) {
                filterChain.doFilter(request, response);
                return;
            }
            response.sendRedirect("/login?returnUrl=" + request.getRequestURI());
            return;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {

                if (request.getRequestURI().startsWith("/login") || request.getRequestURI().startsWith("/register")) {
                    response.sendRedirect("/");
                    return;
                }

                var user = userService.findById(Long.parseLong(cookie.getValue()));

                // reseto Cookie
                //redirect ne login
                // check if user is active, disabled, banned to redirect on specific page

                // perndryshe add user to request

                request.setAttribute("user", user);


                //shko te filteri i rradhes (per ne controlleri)
                filterChain.doFilter(request, response);
                return;
            }
        }

        if (!request.getRequestURI().startsWith("/login"))
            response.sendRedirect("/login?returnUrl=" + request.getRequestURI());
        else
            filterChain.doFilter(request, response);
    }
}



