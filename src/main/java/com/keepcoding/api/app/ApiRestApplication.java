package com.keepcoding.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}
	// Permisos en spring: se agrega este BEAN.Ejecuta permisos de Cors y se 
	//ejecuta solo. Permiso para q m api se pueda consumir dd cualquier sitio
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

}
