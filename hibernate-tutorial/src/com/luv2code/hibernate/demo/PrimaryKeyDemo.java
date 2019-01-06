package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new student object...");
			Student student1 = new Student("ich", "6asd", "ich@hotmail.de");
			Student student2 = new Student("du", "6qwe", "du@hotmail.de");
			Student student3 = new Student("es", "6rwer", "es@hotmail.de");
			
			session.beginTransaction();
			System.out.println("Saving the student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
