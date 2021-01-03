package org.formacion.jpa.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Persona {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    public String nombre;
    
    @ManyToOne
    private Persona padre;
    
    public Persona() {
	}
    
    public Persona(String nombre) {
		this.nombre = nombre;
	}

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public Persona getPadre() {
		return padre;
	}

	public void setPadre(Persona padre) {
		this.padre = padre;
	}
    
}
