package org.formacion.jpa.main;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formacion.jpa.domain.Persona;

public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
        
        Collection<Persona> nuevas = new HashSet<>();
        /**
         * HashSet es como si tenemos los tres son lo mismo aunque cambien las propiedades
         */
        nuevas.add(new Persona("primera"));
        nuevas.add(new Persona("segunda"));
        nuevas.add(new Persona("tercera"));
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        for(Persona persona: nuevas) {
        	em.persist(persona);
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }

}
