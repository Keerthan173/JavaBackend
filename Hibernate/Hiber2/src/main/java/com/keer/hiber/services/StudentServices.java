package com.keer.hiber.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.keer.hiber.entities.Student;
import com.keer.hiber.util.HibernateUtil;

public class StudentServices {

	// ✅ Save a student (with certificates)
	public void saveStudent(Student student) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();
			
			session.persist(student);
			
			transaction.commit();
			System.out.println("Student saved with certificate.");
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	// ✅ Get a student by ID
	public Student getStudentById(Long id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Student.class, id);
		}
	}
	
	// ✅ Update an existing student
	public void updateStudent(Long id, Student updatedData){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();
			
			Student existingStudent = session.get(Student.class, id);
			if(existingStudent!=null) {
				existingStudent.setName(updatedData.getName());
	            existingStudent.setCollege(updatedData.getCollege());
	            existingStudent.setPhone(updatedData.getPhone());
	            existingStudent.setFatherName(updatedData.getFatherName());
	            existingStudent.setActive(updatedData.isActive());
	            existingStudent.setAbout(updatedData.getAbout());
	            
	            transaction.commit();
	            System.out.println("Student updated successfully.");
	            
			}else {
				System.out.println("Student with ID " + id + " not found.");
			}
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	// ✅ Delete student (cascade deletes certificates)
	public void deleteStudent(Long id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			
			Student std = session.get(Student.class, id);
			if(std!=null) {
				session.remove(std);
				transaction.commit();
				System.out.println("Student and related certificates deleted.");
			}else {
				System.out.println("Student not found.");
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
}
