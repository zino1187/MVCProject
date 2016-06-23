package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.model.Board;
import com.mvc.board.model.BoardDAOMybatis;
import com.mvc.controller.Controller;

public class EditController implements Controller{
	BoardDAOMybatis boardDAO;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDAO = new BoardDAOMybatis();
		
		Board board = new Board();
		
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		board.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		
		boardDAO.update(board);
		
		request.setAttribute("board",board);
	}

	public String getResultView() {
		return "/board/edit/view";
	}

	public boolean isForward() {
		return true;
	}
	
}
