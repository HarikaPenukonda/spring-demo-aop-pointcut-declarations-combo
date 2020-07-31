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
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.udemy.aopdemo.dao.*.get*(..))") // match getter methods
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.udemy.aopdemo.dao.*.set*(..))") // match setter methods
	private void setter() {}
	
	// create pointcut: include the package.. exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	@Before("forDaoPackageNoGetterSetter()") // Apply pointcut declaration to advice
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n===> Performing beforeAddAccountAdvice ");
	}
	
	@Before("forDaoPackageNoGetterSetter()") // Apply pointcut declaration to advice
	public void performApiAnalytics() 
	{
		System.out.println("\n===> Performing API analytics ");
		
	}
	
	

}
