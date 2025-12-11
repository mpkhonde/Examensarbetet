package se.projektarbete.examearbete; // ändra till ditt package

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())           // Stäng av CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()       // Tillåt ALL trafik utan login
                )
                .formLogin(form -> form.disable())       // Stäng av login-formuläret
                .httpBasic(httpBasic -> httpBasic.disable()); // Stäng av Basic Auth

        return http.build();
    }
}
