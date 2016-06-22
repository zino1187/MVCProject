/*
 * 전체 컨트롤러의 업무파트 중, 제 3단계를 수행하는 전문 컨트롤러!!
 * */
package com.mvc.blood.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.blood.model.BloodManager;
import com.mvc.controller.Controller;

public class BloodController implements Controller{
						/* is a 관계가 성립되면서, 곧 자료형이 Controller형이 되어버림*/
	
	//3단계:비즈니스 로직 객체에 일 시킨다!!
	public void execute(HttpServletRequest request , HttpServletResponse response){
		BloodManager manager = new BloodManager();
		String blood=request.getParameter("blood");
		String msg=manager.getAdvice(blood);
		
		//4단계
		request.setAttribute("msg", msg); //요청 scope 수준으로 저장!!
	}
	@Override
	public String getResultView() {
		return "/blood/view";
	}
	
	@Override
	public boolean isForward() {
		return true; //요청 유지!!
	}
}









