package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CrudEmployeeDemo {

    public static void main(String[] args) {
       
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        
        //create session
        Session session = factory.getCurrentSession();
        
 try {  
            
            // use the session object to save Java object 
            
            // create a student object 
            System.out.println("Creating new Employee object...");
            Employee tempEmployee1 = new Employee("Paul", "Wall", "PaulBauCompany");
            Employee tempEmployee2 = new Employee("Paul", "Wall", "PaulBauCompany");
            Employee tempEmployee3 = new Employee("Paul", "Wall", "PaulBauCompany");
            Employee tempEmployee4 = new Employee("Paul", "Wall", "PaulBauCompany");
            Employee tempEmployee5 = new Employee("Paul", "Wall", "PaulBauCompany");
                
            // start a transaction
            session.beginTransaction();
                
            // save the student object
            System.out.println("Saving the employee...");
            session.save(tempEmployee1);
            session.save(tempEmployee2);
            session.save(tempEmployee3);
            session.save(tempEmployee4);
            session.save(tempEmployee5);
            
            // commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done ! ...");      
        
        }
        finally {
            factory.close();
        }


    }

}
