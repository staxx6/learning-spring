package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class MyDemoLoggingAspect2 {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account, *))")
	public void aopStuffVar() {}
	
	
	@Before("aopStuffVar()") // could use pointcut from other aspect but with full qualified name
	public void oneStuff() {
		System.out.println("\n=====> Executing @Before class2 order 5");
	}
}
