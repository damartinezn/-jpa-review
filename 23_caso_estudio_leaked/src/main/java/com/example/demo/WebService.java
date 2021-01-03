package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class WebService {

	public String antecedentesPenales(Persona persona) {

		System.out.println("esperando informe antecedentes " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000 * 20);
		} catch (InterruptedException e) {
			System.out.println("despierto !");
		}
		System.out.println("obtenida respuesta");
 		return "muy mal todo !";
	}
}
