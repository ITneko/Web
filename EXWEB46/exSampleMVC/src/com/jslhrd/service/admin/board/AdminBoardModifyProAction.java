package com.jslhrd.service.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.service.Action;

public class AdminBoardModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		board.setName(request.getParameter("name"));
		board.setEmail(request.getParameter("email"));
		board.setSubject(request.getParameter("subject"));
		board.setContents(request.getParameter("contents"));
		int row = dao.adminBoardModify(idx, board);
		
		System.out.println(board.getName());
		System.out.println(board.getEmail());
		System.out.println(board.getSubject());
		System.out.println(board.getContents());
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/board_modify_pro.jsp");
		rd.forward(request, response);

	}

}
