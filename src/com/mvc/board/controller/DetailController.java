package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.model.Board;
import com.mvc.board.model.BoardDAOMybatis;
import com.mvc.controller.Controller;

public class DetailController implements Controller{
	BoardDAOMybatis boardDAO;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDAO = new BoardDAOMybatis();
		
		//list.jsp에서 날아온 파라미터값 받기!!
		String board_id=request.getParameter("board_id");
		
		Board board=boardDAO.select(Integer.parseInt(board_id));
		
		//4단계
		request.setAttribute("board", board);
	}

	@Override
	public String getResultView() {
		return "/board/detail/view";
	}

	@Override
	public boolean isForward() {
		return true;
	}

	
}
