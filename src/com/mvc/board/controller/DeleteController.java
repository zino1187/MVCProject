package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.model.BoardDAOMybatis;
import com.mvc.controller.Controller;

public class DeleteController implements Controller{
	BoardDAOMybatis boardDAO;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDAO = new BoardDAOMybatis();
		boardDAO.delete(Integer.parseInt(request.getParameter("board_id")));		
	}

	@Override
	public String getResultView() {
		return "/board/delete/view";
	}

	@Override
	public boolean isForward() {
		return false;
	}
	
}
