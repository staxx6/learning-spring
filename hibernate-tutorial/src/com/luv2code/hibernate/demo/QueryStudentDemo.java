package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='6'", Student.class).getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='6' or s.lastName='6asd'", Student.class).getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email like '%hotmail.de'", Student.class).getResultList();
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student s : theStudents) {
			System.out.println(s);
		}
	}
}
