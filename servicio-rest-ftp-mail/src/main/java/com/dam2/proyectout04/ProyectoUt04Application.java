package com.dam2.proyectout04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoUt04Application {

	public static void main(String[] args) {
        // arranca la app de spring boot y listo
		SpringApplication.run(ProyectoUt04Application.class, args);
		System.out.println(">>> APLICACION INICIADA EN PUERTO 8080 <<<");
	}

}