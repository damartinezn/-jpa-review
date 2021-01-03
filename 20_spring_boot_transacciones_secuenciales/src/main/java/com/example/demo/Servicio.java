package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Servicio {
	
	@PersistenceContext
	private EntityManager em;

	public Persona consulta (long id) {
		
		Persona persona = em.find(Persona.class, id);
		
		return persona;
	}
	
	//lee los datos no hace flush se generea error con esta linea
	//no se elimina el persistence context y no genera una nueva consulta
	//@Transactional(readOnly = true)
	public void modifica (long id, String nombre) {
		Persona persona = consulta(id);
		persona.setNombre(nombre);
	}

}
