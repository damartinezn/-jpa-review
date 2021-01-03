package org.formacion.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNombre()  == null) ? 0 : getNombre() .hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (getNombre()  == null) {
			if (other.getNombre()  != null)
				return false;
		} else if (!getNombre() .equals(other.getNombre() ))
			return false;
		return true;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof Persona))
//			return false;
//		Persona other = (Persona) obj;
//		if (getId() == null) {
//			if (other.getId() != null)
//				return false;
//		} else if (!getId().equals(other.getId()))
//			return false;
//		return true;
//	}

//aplicamos hash al nombre
	
	
}
