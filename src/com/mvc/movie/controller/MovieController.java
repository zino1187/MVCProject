/*
 * 전체 컨트롤러의 업무파트 중, 제 3단계를 수행하는 전문 컨트롤러!!
 * */
package com.mvc.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.controller.Controller;
import com.mvc.movie.model.MovieManager;

public class MovieController implements Controller{
	
	//3단계:비즈니스 로직 객체에 일 시킨다!!
	public void execute(HttpServletRequest request , HttpServletResponse response){
		MovieManager manager = new MovieManager();
		String movie=request.getParameter("movie");
		String msg=manager.getAdvice(movie);
		
		//4단계
		request.setAttribute("msg", msg); //요청 scope 수준으로 저장!!
	}
}









