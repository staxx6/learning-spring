package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDempApp {

	public static void main(String[] args) {

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
		theAccountDAO.addAccount(new Account(), 2);
		
		context.close();
	}

}
