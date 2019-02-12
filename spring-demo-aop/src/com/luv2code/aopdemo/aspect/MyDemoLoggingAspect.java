package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void add*())")
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void addAccount())")
	//@Before("execution(* addAccount())")
	
	// Params
	//@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // any package method with 0-oo params
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account, *))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Executing @Before advice on addAccount()");
	}
}
