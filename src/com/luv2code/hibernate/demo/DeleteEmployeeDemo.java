package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        
        //create session
        Session session = factory.getCurrentSession();
        
              
        try { 
          
            // new session and start transaction 
            session = factory.getCurrentSession();
            session.beginTransaction();
            
                       
            //delete the student id=2
            System.out.println("Delete the Employee id=4");
            session.createQuery("delete from Employee where id = '4'").executeUpdate();
            
            
            // commit the transaction
            session.getTransaction().commit();
           
            
            System.out.println("Done ! ...");      
        
        }
        finally {
            factory.close();
        }

    }

}
