package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemoDemo {

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

			Query<Instructor> query = session.createQuery(
					"SELECT i FROM Instructor i "
					+ "JOIN FETCH i.courses "
					+ "WHERE i.id=:theInstructorId", Instructor.class);
			
			query.setParameter("theInstructorId", 1);
			Instructor instructor = query.getSingleResult();
			System.out.println("--- " + instructor);
			
			session.getTransaction().commit(); // Commit transaction --------------
			
			for(Course c : instructor.getCourses()) {
				System.out.println("--- " + c);
			}
			
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
