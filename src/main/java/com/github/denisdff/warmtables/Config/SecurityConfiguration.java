package com.github.denisdff.warmtables.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/static/**").permitAll()
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/games-catalog").permitAll()
//                        .requestMatchers("/game/**").permitAll()
//                        .requestMatchers("/game/**/Rules").permitAll()
//                        .requestMatchers("/game/**/Items").permitAll()
//                        .requestMatchers("/game/**/Character").permitAll()
//                        .requestMatchers("/game/**/Equipment").permitAll()
                        .anyRequest().permitAll()
                );
        return http.build();
    }

}