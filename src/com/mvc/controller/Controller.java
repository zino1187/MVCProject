package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//3,4단계 수행하는 메서드 
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	//어떤 뷰를 보여줘야할지를 결정하는 메서드!!
	public String getResultView();
	
	//리다이렉트 여부, 혹은 포워딩 여부 
	public boolean isForward();
	
}
