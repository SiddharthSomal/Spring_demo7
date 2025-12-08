package com.pixel0.Ex11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizationSuccessHandler;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, OAuthAuthorizationSuccessHandler oAuthAuthorizationSuccessHandler) throws Exception{
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        auth->auth
                                .requestMatchers("/","/public/**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth->oauth
                        .successHandler(oAuthAuthorizationSuccessHandler));
        return http.build();
    }
}
