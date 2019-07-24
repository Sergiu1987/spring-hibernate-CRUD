package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        
        //create session
        Session session = factory.getCurrentSession();
        
              
        try {  
            
            // use the session object to save Java object 
            
            // create a employee object 
            System.out.println("Creating new Employee object...");
            Employee tempEmployee = new Employee("Daffy", "Duck", "DaffyDuckCompany");
                
            // start a transaction
            session.beginTransaction();
                
            // save the employee object
            System.out.println("Saving the employee...");
            System.out.println(tempEmployee);
            session.save(tempEmployee);
            
            // commit transaction
            session.getTransaction().commit();
            
            //my NEW code
            
            //find out the student's id: primary key
            System.out.println("Saved employee. Generated id: "+tempEmployee.getId());
            
            // new session and start transaction 
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            // retrieve employee based on the id: primary key
            System.out.println("\nGetting employee with id: "+tempEmployee.getId());
            
            Employee myEmployee = session.get(Employee.class, tempEmployee.getId());
            
            System.out.println("Get complete: "+myEmployee);
            
            // commit the transaction
            session.getTransaction().commit();
            
            System.out.println("Done ! ...");      
        
        }
        finally {
            factory.close();
        }

    }

}
