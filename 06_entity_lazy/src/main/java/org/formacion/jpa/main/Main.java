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
        		"insert into PERSONA (nombre,aficion) values ('nombre','ajedrez')");
        con.commit();
       
        System.out.println("----- consulta -----");
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Persona persona = em.getReference(Persona.class, "nombre");
        persona.getNombre();
        
        // en este punto es cuando se necesita ejecutar la select para 
        // inicializar el proxy
        persona.getAficion();
        
        // será el objeto persona devuelto del tipo Persona o algun
        // subtipo ?? 
        System.out.println(persona.getClass().getName());
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }

}
