package com.jslhrd.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.service.Action;

public class BoardWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardVO board = new BoardVO();
		board.setName(request.getParameter("name"));
		board.setPass(request.getParameter("pass")); 
		board.setEmail(request.getParameter("email"));
		board.setSubject(request.getParameter("subject"));
		board.setContents(request.getParameter("contents"));

		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardWrite(board);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_write_pro.jsp");
		rd.forward(request, response);
		
	}

}
