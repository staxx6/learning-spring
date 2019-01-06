package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 2;
			session.beginTransaction(); // BEGIN TRANSACTION -------------------------------
			
			Student myStudent = session.get(Student.class, studentId);
			session.delete(myStudent);
			
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			session.getTransaction().commit(); // COMMIT -------------------------------
			
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
