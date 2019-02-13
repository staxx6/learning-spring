package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;


/*
 * 
 *  LOOK AT FILE 3 for more
 * 
 * 
 */

@Aspect
@Component
@Order(0)
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
	
	@AfterReturning(pointcut="aopStuffVar()", returning="result") // not by exceptions!
	public void retStuff(JoinPoint joinPoint, Account result) {
		System.out.println("\n=====> Executing @AfterReturn retStuff " + result);
		result.setName("lool");
	}
	
	@AfterReturning("aopStuffVar()") // not by exceptions!
	public void retStuff() {
		System.out.println("\n=====> Executing @AfterReturn retStuff");
	}
	
	@After("execution(* *(..))") // triggers before throw!
	public void afterStuff() {
		System.out.println("\n=====> Executing @After afterStuff ");
	}
	
	@AfterThrowing(pointcut="execution(* *(..))", throwing="exec") // not by exceptions!
	public void exeStuff(JoinPoint joinPoint, Throwable exec) {
		System.out.println("\n=====> Executing @AfterThrowing exeStuff " + exec.getMessage());
	}
	
	@Around("execution(* *(..))")
	public Object aroundStuff(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("---StartMethode:---");
		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		System.out.println("---EndMethode after " + (System.currentTimeMillis() - begin) + "ms---");
		return result;
	}
	
	//@Before("aopStuffVar() ! (getter() || setter())")
	@Before("aopStuffVar() ! aopStuffVarTwo()") // || or && possible too // ! DONT MATCH
	public void threeStuff() {
		System.out.println("\n=====> Executing @Before threeStuff");
	}
}
