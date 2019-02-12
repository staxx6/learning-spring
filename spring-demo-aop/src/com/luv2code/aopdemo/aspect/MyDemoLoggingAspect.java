package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
//		System.out.println("\n=====> Executing @Before advice on addAccount()");
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account, *))")
	public void aopStuffVar() {}
	
	@Pointcut("execution(* *.fantasy(..))") // nothing match - for logic only 
	public void aopStuffVarTwo() {}
	
	//@Pointcut("aopStuffVar() ! (getter() || setter())")
	//public void aopStuffVarThree() {}
	
	@Before("aopStuffVar()")
	public void oneStuff() {
		System.out.println("\n=====> Executing @Before oneStuff");
	}
	
	@Before("aopStuffVar()")
	public void twoStuff() {
		System.out.println("\n=====> Executing @Before twoStuff");
	}
	
	//@Before("aopStuffVar() ! (getter() || setter())")
	@Before("aopStuffVar() ! aopStuffVarTwo()") // || or && possible too // ! DONT MATCH
	public void threeStuff() {
		System.out.println("\n=====> Executing @Before threeStuff");
	}
}
