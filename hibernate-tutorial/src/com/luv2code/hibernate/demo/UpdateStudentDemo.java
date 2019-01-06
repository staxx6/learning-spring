package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			session.beginTransaction(); // BEGIN TRANSACTION -------------------------------
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println(myStudent);
			
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit(); // COMMIT -------------------------------
			
			session = factory.getCurrentSession();
			session.beginTransaction(); // BEGIN TRANSACTION -------------------------------
			
			session.createQuery("update Student set email='foo@bla.bla'")
				.executeUpdate();
			
			session.getTransaction().commit(); // COMMIT -------------------------------
			
			
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
