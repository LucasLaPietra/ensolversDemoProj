package com.ensolversdemoproj.demoproj;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("Authorization",
        "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials","Access-Control-Allow-Headers", "Access-Control-Expose-Headers")
        .allowedOriginPatterns("http://localhost:8100").allowedOrigins("http://localhost:8100");
    }
}
