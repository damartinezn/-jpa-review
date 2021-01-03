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

	/**
	 * Implementacion "por defecto" de eclipse de equals y hashcode
	 * 
	 * Lo interesante del caso es que esta implementación que NO funciona con
	 * Hibernate sí que funciona con eclipselink
	 * 
	 * Por supuesto, recomendamos ENCARECIDAMENTE usar la implementación más
	 * solida mostrada en la lección anterior.
	 * 
	 * Esta lección simplemente incide en la necesidad de  revisar concienzudamente
	 * el código si pensamos migrar una aplicación de un provider a otro.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
