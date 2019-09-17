/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firstjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Course;

/**
 *
 * @author Kostis.Mikroulis
 */
public class MyMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //We create the Entity Manager as stated to : transaction-type="RESOURCE_LOCAL"(persistence.xml)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("_firstJpa");
        EntityManager em = emf.createEntityManager();
        //Use the entityManager to find class and print it.
        Course c = em.find(Course.class, 1);  
        System.out.println("-------------------------");
        System.out.println("ID: "+c.getId()+", Course Title: "+c.getTitle());  
        //persist() is like INSERT.
        c.setTitle("Python");
        em.getTransaction().begin();
        em.persist(c);
        // transaction begins and must always "close".
        em.getTransaction().commit();
        
        
    }

}
