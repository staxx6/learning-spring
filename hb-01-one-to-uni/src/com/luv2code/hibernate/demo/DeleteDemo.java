package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); // Begin transaction --------------
			
			//Instructor instructor = session.get(Instructor.class, 1);
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);
			
			if(instructorDetail != null) {
				session.delete(instructorDetail);
			} else {
				System.out.println("No instructor detail found with index 1");
			}
			
//			if(instructor != null) {
//				session.delete(instructor);
//			} else {
//				System.out.println("No instructor found with index 1");
//			}
			
			session.getTransaction().commit(); // Commit transaction --------------
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
