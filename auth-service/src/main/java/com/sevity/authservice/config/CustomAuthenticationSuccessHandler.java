package com.sevity.authservice.config;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        HttpSession session = request.getSession(false);
        request.getSession().setAttribute("userId", user.getId());  // gRPC를 위해 저장해둠
        //response.addHeader("Set-Cookie", "MyCookieName=YourCookieValue;Path=/; Secure; HttpOnly; SameSite=None");  //되는거 확인함
        response.getWriter().write("Login successful!! User info: " + user.toString() + "session:" + session);
    }
}
