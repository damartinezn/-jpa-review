package org.formacion.jpa.main;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;

import org.formacion.jpa.domain.Persona;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class Main {

    public static void main(String[] args) {

    	/*
    	 * Forma "tradicional" de crear un entity manager factory
    	 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");

         A partir de este punto se simula el comportamiento de un contenedor
         */
    	
    	// La clase HibernatePersistenceProvider es la que especificamos 
    	// en el fichero persistente.xml en el elemento <provider>
        PersistenceProvider hpp = new HibernatePersistenceProvider();

        PersistenceUnitInfo persistenceInfo = new SimplePersistenceInfo("no-main");

        // Propiedades generales
        Map<String, String> properties = new HashMap<>();

        properties.put("javax.persistence.jdbc.url","jdbc:h2:mem:test");
        properties.put("javax.persistence.schema-generation.database.action", "create");
        properties.put("hibernate.show_sql","true");

        // Ya tenemos los dos ingredientes para crear el EntityManagerFactory
		EntityManagerFactory emf =  hpp.createContainerEntityManagerFactory(
                persistenceInfo,
                properties);

    	// A partir de este punto el código es idéntico a los anteriores proyectos
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona nueva = new Persona();
        nueva.setNombre("pepe");

        em.persist(nueva);

        em.getTransaction().commit();

        em.close();
        
        emf.close();

    }

}
