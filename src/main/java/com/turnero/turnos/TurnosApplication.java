package com.turnero.turnos;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TurnosApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(TurnosApplication.class, args);
	}
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//configuro para que no me de error crossorigin, autorizo los request de este origen para todos los metodos y para todos los encabezados
				//MUCHO CUIDADO EN PRODUCCION, HAY QUE LIMITAR LOS METODOS Y A QUE API Y DESDE DONDE
				registry.addMapping("/**").allowedOrigins("http://localhost:63342").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
