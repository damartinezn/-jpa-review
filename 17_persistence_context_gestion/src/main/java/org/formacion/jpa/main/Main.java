package org.formacion.jpa.main;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.formacion.jpa.domain.Persona;

public class Main {

	private static EntityManagerFactory emf;
	
    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("jpa_main");

        Connection con = DriverManager.getConnection("jdbc:h2:mem:test");
        con.createStatement().executeUpdate("insert into PERSONA (nombre,dni) values ('juana','12345678Z')");
        con.createStatement().executeUpdate("insert into PERSONA (nombre,dni) values ('pedro','87654321X')");
        con.commit();
       
        try {
        	caso1(); // invoca el metodo que quieras probar en cada caso
        } finally {
            emf.close();
        }

    }
    
    /*
     * ¿Se va a generar un update para la modificación hecha en juana?
     */
    public static void caso1 () {
    
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Persona juana = em.find(Persona.class, "juana");
        juana.setMunicipio("Pueblo alto");
        //no es necesario hacer un merge
        em.getTransaction().commit();
        
        em.close();
  }

    /*
     * Hemos quitado la transaccion:
     * Se va a generar un update para la modificación hecha en juana?
     */
    public static void caso2 () {
        
        EntityManager em = emf.createEntityManager();
        
        Persona juana = em.find(Persona.class, "juana");
        juana.setMunicipio("Pueblo alto");
        //no se genera un update cuando se hace commit se genera el update
        em.close();
   }
    
 
    
    /*
     * La modificacion del entity se produce fuera de la transaccion
     */
    public static void caso3 () {
        
        EntityManager em = emf.createEntityManager();
        
        Persona juana = em.find(Persona.class, "juana");
        juana.setMunicipio("Pueblo alto");
        //el persistence context se encarga de ever el estado de nuestros datos sus cambios
        //
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
  }
 

    /*
     * "Provocar" un flush sin transaccion
     */
    public static void caso4 () {
    
        EntityManager em = emf.createEntityManager();
        
        Persona juana = em.find(Persona.class, "juana");
        juana.setMunicipio("Pueblo alto");
        //el persistence context debe estar inicializado hace un flash sobre 
        //una transaccion 
        //inactiva
        em.flush(); // flush explicito
        em.close();
  }
    
 
    /*
     * En que orden se ejecutaran las operaciones?
     */
    public static void caso5 () {
    
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        //no se respeta el orden con el que escribimos nosotros
        em.remove(em.find(Persona.class, "pedro")); // delete
        //de esta manera sigue el orden deseada 
        em.flush();
        em.persist(new Persona("toni")); // insert

        Persona juana = em.find(Persona.class, "juana");
        juana.setMunicipio("Pueblo alto"); // update

        em.getTransaction().commit();
        
        em.close();
  }
    
    /*
     * Cuando se ejecuta el insert?
     */
    public static void caso6 () {
    
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(new Persona("toni"));
        //se hace el flush justo cuando se hace la consulta
        //lo crresto flush aqui
        em.createQuery("select p from Persona p").getResultList();

        em.getTransaction().commit();
        
        em.close();
  }
    
    /*
     * Funcionara (teniendo en cuenta el unique de dni) el siguiente codigo ?
     */
    public static void caso7 () {
    
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Persona juana = em.find(Persona.class, "juana");
        em.remove(juana);
        
        em.flush();
        
        Persona toni = new Persona("toni");
        toni.setDni(juana.getDni());
        
		em.persist(toni);
		
		//el flush no es un commit 		
        em.getTransaction().commit();
        em.close();
  }
 
}
