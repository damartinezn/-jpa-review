package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//opcon 2 readOnly true
@Service
@Transactional(readOnly = true)
public class Servicio {
	
	@PersistenceContext
	private EntityManager em;

	private static final int MILES = 150;
	
	public void init () {
		
		System.out.println("---- inicializando BBDD ----");
		for (int i = 0; i < MILES * 1000; i++) {
		   Persona persona = new Persona();
	       persona.setNombre("persona " + i);
	       
		   em.persist(persona);
		}
		
		System.out.println("---- incialización completada -----");
	}

	public List<Persona> consulta () {
		
		List<Persona> resultado = new ArrayList<Persona>(MILES * 1000);
		
		TypedQuery<Persona> query = em.createQuery("select p from Persona p where p.id >= :inicio and  p.id <= :fin", Persona.class);
		
		for (int i = 0; i < MILES; i++) {
			query.setParameter("inicio",  (i * 1000L) + 1  );
			query.setParameter("fin", (i + 1) * 1000L);
			
			resultado.addAll(query.getResultList());
			//opcion 1
			em.clear();
		}
		
		return resultado;
	}


}
