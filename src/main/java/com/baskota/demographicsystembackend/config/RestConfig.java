package com.baskota.demographicsystembackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins (you can change this to specific domains like http://localhost:4200)
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")  // Specify Angular frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Specify allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow cookies or authorization headers
    }
}
