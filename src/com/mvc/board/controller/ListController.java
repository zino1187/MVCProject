package com.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.model.BoardDAO;
import com.mvc.controller.Controller;

public class ListController implements Controller{
	BoardDAO board;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//3단계: 알맞는 비즈니스 로직 객체에 일 시킨다!!
		board = new BoardDAO();
		List list=board.selectAll();
		
		//4단계: 뷰로 가져갈 것이 잇다면 메모리 상에 결과 저장 
		request.setAttribute("list",list);		
	}

	public String getResultView() {
		return "/board/list/view";
	}

	@Override
	public boolean isForward() {
		return true;
	}
	
}
