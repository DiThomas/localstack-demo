package nl.jdriven.myapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/ping").permitAll()
                .antMatchers("/api/ping").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "*").permitAll()//allow CORS option calls
                .antMatchers(HttpMethod.POST, "/api/quiz").permitAll()//allow CORS option calls
                .antMatchers(HttpMethod.POST, "/api/quiz/**").permitAll()//allow CORS option calls
                .anyRequest().permitAll()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .httpBasic();
    }

    //Change/Customize as necessary


    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
