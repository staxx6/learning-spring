package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new student object...");
			Student student = new Student("staxx", "6", "staxx6@hotmail.de");
			
			session.beginTransaction();
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id:" + student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nGetting student with id: " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete: " + myStudent);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
