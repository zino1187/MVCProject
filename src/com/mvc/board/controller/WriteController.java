/*
 * 글쓰기 요청을 처리하는 보조 컨트롤러
 * 컨트롤러의 업무단계 중 3,4 단계를 수행
 * 
 * */
package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.model.Board;
import com.mvc.board.model.BoardDAOMybatis;
import com.mvc.controller.Controller;

public class WriteController implements Controller {
	BoardDAOMybatis boardDAO;

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 3단계: 알맞는 비즈니스 로직 객체에 일 시킨다!!
		boardDAO = new BoardDAOMybatis();

		Board board = new Board();
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);

		boardDAO.insert(board);
		
		//4단계 : 뷰페이지에 가져갈 것이 있다면 결과 저장
	}

	public String getResultView() {
		return "/board/write/view";
	}

	public boolean isForward() {
		return true;
	}

}
