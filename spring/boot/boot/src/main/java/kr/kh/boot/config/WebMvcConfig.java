package kr.kh.boot.config;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.kh.boot") 
public class WebMvcConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:///D:/uploads/");
    }
}
