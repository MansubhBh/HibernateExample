/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mansubh.helloapp;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Mansubh Bhandari
 */
public class HibernateUtil {

   private static final SessionFactory sessionFactory;
   
   
   static{
      AnnotationConfiguration config = new AnnotationConfiguration();
      config.addAnnotatedClass(com.mansubh.helloapp.entity.Student.class);
      config.configure();
      sessionFactory = config.buildSessionFactory();
   }
   
   public static SessionFactory getSessionfactory(){
       return sessionFactory;
   }
}
