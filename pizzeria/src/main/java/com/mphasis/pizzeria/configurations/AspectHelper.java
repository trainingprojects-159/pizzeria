package com.mphasis.pizzeria.configurations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHelper 
{
	@Before("execution(* com.mphasis.training.*.*.*(..))")
	public void beforeMethods(JoinPoint joinpoint)
	{
		
		
			System.out.println("before"+joinpoint.getSignature());
			System.out.println(joinpoint.getSignature().getName());
			
		
	}
	@After("execution(* com.mphasis.training.*.*.*(..))")
	public void afterMethods(JoinPoint joinpoint)
	{
		System.out.println("before"+joinpoint.getSignature());
		System.out.println(joinpoint.getSignature().getName());
	}
	
	

}
