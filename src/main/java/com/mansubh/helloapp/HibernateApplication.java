/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mansubh.helloapp;

import com.mansubh.helloapp.entity.Student;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mansubh Bhandari
 */
public class HibernateApplication {
    
    public static void main(String[] args) {
        HibernateApplication app = new HibernateApplication();
   //  int s = app.saveStudent(new Student(1, "Rajeev", "rajeev@gmail.com", "putalisadak"));
   // int s1 = app.saveStudent(new Student(2, "anish", "anish@gmail.com", "lazimpat"));
   //   int s2 = app.saveStudent(new Student(1, "neil", "neil@gmail.com", "new jersey"));
        
   //     System.out.println("Insertion opertaion " + s + " " + s1);
             System.out.println("------------ fetching all the data --------- ");
      for(Student s : app.getAll()){
     
        if(s.getSid() == 2){
            app.updateStudent(new Student(2, "johny", "johny@gmail.com", "california"));
            
        }
      }
        
    }
    
    public int saveStudent(Student s ){
        
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction tran  = session.beginTransaction();
        int result = (Integer)session.save(s);
        tran.commit();
        session.close();
        return result;
    }
    
    public List<Student> getAll(){
        Session session = HibernateUtil.getSessionfactory().openSession();
        List<Student> slist = session.createQuery("select s from Student s").list();
        session.close();
        return slist;   
    }
    
    public void updateStudent(Student s){
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction tran = session.beginTransaction();
        try{
        session.saveOrUpdate(s);
        tran.commit();
        }catch(Exception e){
            System.out.println("error "+ e.getMessage());
            tran.rollback();
        }
        
    }
}
