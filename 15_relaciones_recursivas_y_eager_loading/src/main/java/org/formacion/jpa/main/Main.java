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
        Connection con = DriverManager.getConnection("jdbc:h2:mem:test");
        
        con.createStatement().executeUpdate("insert into PERSONA (nombre, padre_id) values ('abuelo',null)");
        con.createStatement().executeUpdate("insert into PERSONA (nombre, padre_id) values ('padre',1)");
        con.createStatement().executeUpdate("insert into PERSONA (nombre, padre_id) values ('yo',2)");
        con.createStatement().executeUpdate("insert into PERSONA (nombre, padre_id) values ('hijo',3)");
        con.createStatement().executeUpdate("insert into PERSONA (nombre, padre_id) values ('nieto',4)");
        con.createStatement().executeUpdate("insert into PERSONA (nombre, padre_id) values ('bisnieto',5)");
        con.commit();

        EntityManager em = emf.createEntityManager();
        Persona persona = em.find(Persona.class, 1L);

        em.close();
        emf.close();

        while (persona != null) {
        	System.out.println(persona.getNombre());
        	persona = persona.getPadre();
        }
        
    }

}
