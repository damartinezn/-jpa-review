package org.formacion.jpa.main;

import org.formacion.jpa.domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona nueva = new Persona();
        nueva.setNombre("pepe");

        em.persist(nueva);

        em.getTransaction().commit();

        em.close();
        
        // Cerramos el entity manager factory para provocar que se cierre el pool
        // de conexiones que crea Hibernate y no deje la apliacion sin finalizar.
        emf.close();

    }

}
