package vn.plantpal.mobile_backend.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Cho phép truy cập từ tất cả các domain
                .allowedMethods("*") // Cho phép tất cả các phương thức HTTP như GET, POST, etc.
                .allowedHeaders("*"); // Cho phép tất cả headers
    }
}