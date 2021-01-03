package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Servicio {
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private WebService ws;
	
	public String consultaAntencedentes (long id) {
		
		Persona persona = em.find(Persona.class, id);
		
		String info = ws.antecedentesPenales(persona);
		
		return info;
	}

	
	public String consultaNombre (long id) {
		
		Persona persona = em.find(Persona.class, id);
		return persona.getNombre();
	}

}
