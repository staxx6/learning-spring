package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("staxxx", "6", "staxx6@hotmail.de");
			InstructorDetail instructorDetail = new InstructorDetail("whatYT", "sports");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction(); // Begin transaction --------------
			
			session.save(instructor);
			
			session.getTransaction().commit(); // Commit transaction --------------
			System.out.println("Done!");
		} finally {
			session.close();
		}
	}
}
