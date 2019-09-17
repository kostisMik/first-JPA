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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("_firstJpa");
        EntityManager em = emf.createEntityManager();
        Course c = em.find(Course.class, 1);  
        System.out.println("************************");
        System.out.println("ID: "+c.getId()+", Course Title: "+c.getTitle());
    }

}
