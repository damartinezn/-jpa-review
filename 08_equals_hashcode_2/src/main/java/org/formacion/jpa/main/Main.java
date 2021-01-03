package org.formacion.jpa.main;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formacion.jpa.domain.Persona;

public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
        
        // inicialización via JDBC
        Connection con = DriverManager.getConnection("jdbc:h2:mem:test");
        con.createStatement().executeUpdate(
        		"insert into PERSONA (nombre) values ('nombre')");
        con.commit();
       
        Persona primera = new Persona();
        primera.setNombre("nombre");
        
        System.out.println("----- consulta -----");
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        // El test funciona si cargamos la entidad con el metodo find, pero no
        // si lo hacemos con getReference
        Persona segunda = em.getReference(Persona.class, "nombre");
        
        System.out.println("primera.equals(segunda)? " + primera.equals(segunda));
        System.out.println("segunda.equals(primera)? " + segunda.equals(primera));
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }

}
