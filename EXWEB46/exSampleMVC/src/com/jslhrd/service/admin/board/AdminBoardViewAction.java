package com.jslhrd.service.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.service.Action;

public class AdminBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = 1;
		if(request.getParameter("page") != null) {
			Integer.parseInt(request.getParameter("page"));
		}
		request.setCharacterEncoding("UTF-8");

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = null;
		board = dao.boardView(idx);
		board.getContents().replace("\n", "<br>");

		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("BoardList" + idx)) {
				bool = true;
				break;
			}
		}

		String newValue = "" + System.currentTimeMillis();
		if (!bool) {
			info = new Cookie("BoardList" + idx, newValue);
			info.setMaxAge(24 * 60 * 60);
			response.addCookie(info);
			dao.boardReadCount(idx);
		}
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("board", board);

		RequestDispatcher rd = request.getRequestDispatcher("Admin/board_view.jsp");
		rd.forward(request, response);
	}

}
