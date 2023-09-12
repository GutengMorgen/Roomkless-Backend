package com.gutengmorgen.Roomkless.Infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class CrosConfiguration {

    // @Bean
    // public SecurityWebFilterChain filterChain(ServerHttpSecurity httpSecurity){
    // return httpSecurity.authorizeExchange(spec ->
    // spec.anyExchange().permitAll())
    // .csrf(ServerHttpSecurity.CsrfSpec::disable)
    // .build();
    // }

    @Bean
    public WebSecurityCustomizer securityCustomizer() {
        return (web -> web.ignoring().requestMatchers("/**"));
    }

    @Bean
    public WebMvcConfigurer crosConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/roomkless/**")
                        .allowedOrigins("http://localhost:5173/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(true);
            }
        };
    }
}
