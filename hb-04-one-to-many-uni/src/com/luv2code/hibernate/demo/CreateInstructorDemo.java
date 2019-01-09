package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); // Begin transaction --------------

			Instructor instructor = session.get(Instructor.class, 1);
			Course tmpCourse1 = new Course("Bla1");
			Course tmpCourse2 = new Course("Bla2");
			Course tmpCourse3 = new Course("Bla3");
			
			instructor.add(tmpCourse1);
			instructor.add(tmpCourse2);
			instructor.add(tmpCourse3);
			
			session.save(tmpCourse1);
			session.save(tmpCourse2);
			session.save(tmpCourse3);
			
			session.getTransaction().commit(); // Commit transaction --------------
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
