package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.udemy.aopdemo.dao.*.*(..))") // create pointcut declaration
	private void forDaoPackage() 
	{
		
	}
	
	@Before("forDaoPackage()") // Apply pointcut declaration to advice
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n===> Performing beforeAddAccountAdvice ");
	}
	
	@Before("forDaoPackage()") // Apply pointcut declaration to advice
	public void performApiAnalytics() 
	{
		System.out.println("\n===> Performing API analytics ");
		
	}
	
	

}
