package vn.plantpal.mobile_backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**")
                      .allowedOrigins("*")
                      .allowedMethods("*")
                      .allowedHeaders("*")
                      .allowCredentials(false);
            }
        };
    }
}