package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(10)
public class MyDemoLoggingAspect3 {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account, *))")
	public void aopStuffVar() {}
	
	
	@Before("aopStuffVar()") // could use pointcut from other aspect but with full qualified name
	public void oneStuff(JoinPoint joinPoint) {
		System.out.println("\n=====> Executing @Before class3 order 10");
		
		MethodSignature methoSig = (MethodSignature) joinPoint.getSignature();
		System.out.println(methoSig);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArgs : args) {
			System.out.println(tempArgs);
			if(tempArgs instanceof Account) {
				System.out.println(((Account) tempArgs).getName());
			}
		}
	}
}







