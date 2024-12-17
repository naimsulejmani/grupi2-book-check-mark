package dev.naimsulejmani.grupi2bookcheckmark.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class SessionSimpleFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //skip filter for assets - image, css, js, etc static folder
        if (request.getRequestURI().startsWith("/assets")) {
            filterChain.doFilter(request, response);
            return;
        }

        // get current session
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            if (request.getRequestURI().startsWith("/login") || request.getRequestURI().startsWith("/register")) {
                filterChain.doFilter(request, response);
                return;
            }
            response.sendRedirect("/login?returnUrl=" + request.getRequestURI());
            return;
        }

        // if you have session, you will not go into login and register
        if(request.getRequestURI().startsWith("/login") || request.getRequestURI().startsWith("/register")) {
            response.sendRedirect("/");
            return;
        }
        //ketu kishum mujt me validu user-in sipas rolit
//        UserDto userDto = (UserDto) session.getAttribute("user");
//
//        if(userDto.getRole().equals("ADMIN")) {
//            AdminFilter.doFilter(request, response, filterChain);
//            return;
//        } else if (userDto.getRole().equals("USER")) {
//
//        } else {
//            // nese nuk eshte as admin as user, atehere shko ne login
//            response.sendRedirect("/login");
//            return;
//        }

        // perndryshe shko ku ja ke msy me shku!
        filterChain.doFilter(request, response);


    }
}
