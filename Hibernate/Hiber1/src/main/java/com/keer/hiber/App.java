package com.keer.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.keer.hiber.entities.Student;
import com.keer.hiber.util.HibernateUtil;


public class App 
{
    public static void main( String[] args )
    {
    	// Creates a new Student object and sets values for fields.
    	// studentId is not set manually because it is auto-generated (@GeneratedValue).
    	Student student = new Student();
    	student.setName("Abcdef");
    	student.setCollege("SCEM");
    	student.setActive(true);
    	student.setFatherName("Xyz");
    	student.setPhone("123456789");
    	student.setAbout("This is a dummy student");
    	
    	
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	//Gets the singleton SessionFactory from your utility class.
//        System.out.println(sessionFactory);
        
        
        Session session = sessionFactory.openSession();
        // Opens a new Hibernate Session to interact with the DB.


        Transaction transaction = null;
        try {
        	transaction = session.beginTransaction();
        	// Begins a transaction — required for DB write operations.

        	
        	session.persist(student);	// persist() tells Hibernate to save the student object.
        	
        	
        	System.out.println("Student saved successfully.");
        	
        	
        	transaction.commit();		// commit the transaction to write to the DB.
        	
        }
        catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}else {
				e.printStackTrace();
			}
		}
        finally {
			sessionFactory.close();	// SessionFactory should ideally be closed only once when app shuts down
		}
    }
}
