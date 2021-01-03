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
	private ServicioAuditoria auditoria;
	
	public Persona alta (String nombre) {
		
		auditoria.log("alta de " + nombre);
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		
		em.persist(persona);
		
		return persona;
	}

	
	public Persona consulta (long id) {
		
		Persona existente = em.find(Persona.class, id);
		
		auditoria.log(existente);
		
		if (existente.getConsultas() > 3) {
			throw new RuntimeException("demasiadas consultas");
		}
		
		return existente;
	}


}
