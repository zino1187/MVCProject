/*
 * �۾��� ��û�� ó���ϴ� ���� ��Ʈ�ѷ�
 * ��Ʈ�ѷ��� �����ܰ� �� 3,4 �ܰ踦 ����
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
		// 3�ܰ�: �˸´� ����Ͻ� ���� ��ü�� �� ��Ų��!!
		boardDAO = new BoardDAOMybatis();

		Board board = new Board();
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);

		boardDAO.insert(board);
		
		//4�ܰ� : ���������� ������ ���� �ִٸ� ��� ����
	}

	public String getResultView() {
		return "/board/write/view";
	}

	public boolean isForward() {
		return true;
	}

}
