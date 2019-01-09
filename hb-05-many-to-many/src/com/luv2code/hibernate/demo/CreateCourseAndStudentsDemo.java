package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); // Begin transaction --------------

			Course course1 = new Course("A Course");
			Course course2 = new Course("A Course 2");
			
			session.save(course1);
			session.save(course2);
			
			Student stud1 = new Student("erst", "zwei", "mail");
			Student stud2 = new Student("erst erst", "zwei zwei", "mail");
			
			course1.addStudent(stud1);
			course1.addStudent(stud2);
			course2.addStudent(stud1);
			
			session.save(stud1);
			session.save(stud2);
			
			session.getTransaction().commit(); // Commit transaction --------------
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
