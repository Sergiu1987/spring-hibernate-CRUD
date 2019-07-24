package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class FindEmployeeDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        
        //create session
        Session session = factory.getCurrentSession();
        
              
        try {  
            
            // use the session object to save Java object 
            
                            
            // start a transaction
            session.beginTransaction();
            
            // query employee
            List<Employee> theEmployee = session.createQuery("from Employee").getResultList();
            
            for (Employee tempEmployee : theEmployee) {
                System.out.println(tempEmployee);
            }
            
          
         // query employee: company='DaffyDuckCompany'
            System.out.println("\n\nquery employee: company='DaffyDuckCompany'");
            theEmployee = session.createQuery("from Employee e where e.company='DaffyDuckCompany'").getResultList();
            
         // display the employee
            for (Employee tempEmployee : theEmployee) {
                System.out.println(tempEmployee);
            }
                  
            // commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done ! ...");      
        
        }
        finally {
            factory.close();
        }

    }

    
    }


