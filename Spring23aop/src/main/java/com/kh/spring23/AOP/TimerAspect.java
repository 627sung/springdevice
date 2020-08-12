package com.kh.spring23.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;


//특정 대상의 소요시간을 측정하기 위한 간섭 객체 (Aspect bean)
@Aspect
@Slf4j
public class TimerAspect {

	/*
	 * 간섭메소드(Advice)
	 *  특수한 경우가 아니라면 메소드의 형태는 정해져 있다.
	 *  누구를 어떤 시점에 간섭할지 어노테이션으로 설정한다. 
	 *  -@before:
	 */
	
	@Around("target(com.kh.spring23.repository.CatregoryDaoImpl)") //누구를 간섭할건지 정해야합니당... 
	public void before() {
		log.debug("before실행");
	}
	

	@After("target(com.kh.spring23.repository.CatregoryDaoImpl)")
	public void complete() {
		log.debug("after실행");
	}
	
	//전반적인 간섭을 수행하는  간섭 메소드(Advice) 
	//메소드의 형태가 지정이 되어 있다. (ex가짜맛집 진짜맛집 대신 시행 .. ) 
	@Around("target(com.kh.spring23.repository.CatregoryDaoImpl)") 
	public Object arond(ProceedingJoinPoint joinpoint) throws Throwable{		//누구를 간섭할건지 정해야합니당... 
	long start = System.currentTimeMillis();//@Before 시점
		Object result=joinpoint.proceed();
	long finish = System.currentTimeMillis();//@AfterReturing 시점
	long time = finish - start;
	log.debug("대상 : {} ,소요시간:{}ms",joinpoint.getSignature().toShortString(),time);	
	return result;
	}

	
}
