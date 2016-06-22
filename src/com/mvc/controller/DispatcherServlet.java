/*
 * 이 클래스는 우리 어플리케이션의 모든 요청을 받을 , 메인 서블릿이다!!
 * 
 *  web, or application 이건 모든 프로그램에서의 컨트롤러의 5대 역할!!!
 *  1.요청을 받는다 
 *  2.요청을 분석한다 
 *  3.알맞는 로직을 모델에게 수행시킨다
 *  4.결과가 있다면 결과를 메모리에 저장한다!! (생략 가능)
 *  5.결과를 보여준다
 * */
package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.context.ApplicationContext;
public class DispatcherServlet extends HttpServlet{
	ApplicationContext applicationContext;
	
	//서블릿의 인스턴스가 메모리에 생성될때 최초 1번 호출되는 초기화 메서드!! 
	public void init(ServletConfig config){
		ServletContext context=config.getServletContext();
		String param=config.getInitParameter("contextConfigLocation");
		String path=context.getRealPath(param);
		applicationContext = new ApplicationContext(path);
	}
	
	//클라이언트가 post 방식으로 요청을 시도하면 이 메서드가 작동한다.1!!
	//주의, 이 메서드 호출은?  쓰레드 ---> service ---> doPost
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 호출함!");
		req.setCharacterEncoding("utf-8");//파라미터인 비영어권 문자가 깨지지 않도록...
		resp.setCharacterEncoding("utf-8");//혹시 브라우저에 출력할 일이 있다면..깨지지
		//않게 하기 위해...(원칙상 컨트롤러는 화면에 무언가를 뿌리면 안된다..view아니므로)
		resp.setContentType("text/html");
		
		//2단계 : 클라이언트가 무얼 원하는지 알아야 모델에게 일을 시키므로, 요청분석을
					// 하자!!
		String uri=req.getRequestURI();
		System.out.println("클라이언트의 uri는 "+uri);
		
		Controller controller=applicationContext.getController(uri);
		RequestDispatcher dispatcher=null;
		
		//조건문을 사용하지 말고, 외부의 설정파일을 읽어들여, 해당 요청을 처리할 
		//동생 컨트롤러 클래스를 실제 메모리에 올려서 동작시키자!!

		controller.execute(req, resp);
		
		String key=controller.getResultView();	
		String viewPage = applicationContext.getViewPage(key);
		
		if(controller.isForward()){
			dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}else{
			resp.sendRedirect(viewPage);
		}
	}
}






