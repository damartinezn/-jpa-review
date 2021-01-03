package org.formacion.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formacion.jpa.domain.Coche;
import org.formacion.jpa.domain.Persona;

public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");

        Persona ana = new Persona();
        ana.setNombre("Ana");
        
        Coche coche = new Coche();
        coche.setModelo("suzuki");
        coche.setPropietario(ana);
        
        Coche coche2 = new Coche();
        coche.setModelo("suzuki2");
        coche.setPropietario(ana);
                
        Persona juan = new Persona();
        juan.setNombre("Juan");
        
        juan.getCoches().add(coche);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ana);
        em.persist(coche);
        em.merge(coche2);
        em.persist(juan);
  
        em.refresh(coche);
   
        em.refresh(juan);
        em.refresh(ana);
        System.out.println("propietario " + coche.getPropietario().getNombre());

        System.out.println("Cuantos cohces tiene juan " + juan.getCoches().size());
        System.out.println("Cuantos cohces tiene ana " + ana.getCoches().size());

        em.getTransaction().commit();
        em.close();

        emf.close();
   
    }

}
