package org.formacion.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    private String nombre;
    private String municipio;
    
    @Column(unique=true)
    private String dni;
    
  	public Persona() {
  	}
    
  	public Persona(String nombre) {
  		this.nombre = nombre;
  	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
