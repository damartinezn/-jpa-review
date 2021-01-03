package org.formacion.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
