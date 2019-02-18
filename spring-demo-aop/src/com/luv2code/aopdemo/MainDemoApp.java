package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());

	public static void main(String[] args) {
		
		myLogger.info("My Logger stuff");

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		theAccountDAO.addAccount();
		theAccountDAO.addAccount();
		theAccountDAO.addStuff();
		
		theMembershipDAO.addAccount();
		theMembershipDAO.addAccount();
		
		theAccountDAO.addAccount(new Account());
		Account acc = new Account();
		acc.setName("AFFE");
		theAccountDAO.addAccount(acc, 2);
		System.out.println(acc.getName());
		
		try {
			theAccountDAO.crash();
			System.out.println("try");
		} catch(Exception e) {
			System.out.println("catched");
		}
		
		context.close();
	}

}
