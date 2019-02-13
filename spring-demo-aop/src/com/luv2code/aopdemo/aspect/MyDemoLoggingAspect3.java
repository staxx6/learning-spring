package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MyDemoLoggingAspect3 {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account, *))")
	public void aopStuffVar() {}
	
	
	@Before("aopStuffVar()")
	public void oneStuff() {
		System.out.println("\n=====> Executing @Before class3 order 10");
	}
}
