package com.kh.spring15.interceptor;

import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//public class Testinterceptor extends HandlerInterceptor {

public class Testinterceptor extends HandlerInterceptorAdapter {
		
	//인터셉터 간섭시점 1: 처리전(preHandle)
	//필터와 매우 유사하게 사용된다.
	//autowired 사용가능 ... 근데 킬때마다 걸리므로 많이쓰면 느려져잉~
	//404 상황에서는 인터셉터 처리가 불가능하다 -->이경우 fillter를 사용해야한다. 
	//-request : 사용자는 무엇을 요청했는가?
	//-response : 사용자에게 첨부할 정보가 있는가?
	//-handler : 이 요청은 누가 처리하기로 했는가? 핸들러에 있는 클래스 
	//핸들러 
	//-return true면 통과 return false 면 차단
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("테스트 인터셉터");
		System.out.println(handler);
		return true;
	}
//인터셉터 감시시점2 :처리후 (postHandle)
	//컨트롤러의 처리직후 시점을간섭하는 메소드 
	//-request : 사용자는 무엇을 요청했는가?
	//-response : 사용자에게 첨부할 정보가 있는가?
	//-handler : 이 요청은 누가 처리하기로 했는가?
	//modelAndview :model(전달데이터) , view (출력페이지) 정보

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		System.out.println(handler);
		System.out.println(modelAndView);
	}

	//인터셉터 감시시점3 
	
	//requset : 사용자에게출력되기 직전
	//response : 사용자에게 첨부할 정보가 있는가?
	//handler : 이요청은 누가 처리하기로 했는가?
	//-ex : 혹시 만들때 발생한 예외가 있나?
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("애프터컴플리션");
		System.out.println(ex);
	
	}
	

	
	
	
	
	
	
	
	
	
}
