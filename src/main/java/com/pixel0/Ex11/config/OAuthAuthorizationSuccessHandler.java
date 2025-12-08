package com.pixel0.Ex11.config;

import com.pixel0.Ex11.dto.UserDto;
import com.pixel0.Ex11.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerErrorException;

import java.io.IOException;

@Component
public class OAuthAuthorizationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public UserService service;
    public OAuthAuthorizationSuccessHandler(UserService service){
        this.service = service;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse
                                        response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        UserDto dto = new UserDto();
        dto.setName(oAuth2User.getAttribute("name"));
        dto.setEmail(oAuth2User.getAttribute("email"));
        service.addUser(dto);

        try{
            response.sendRedirect("/api/home");
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
