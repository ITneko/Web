package com.jslhrd.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.board.BoardDAO;
import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.service.Action;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		GuestDAO gdao = GuestDAO.getInstance();
		BoardDAO bdao = BoardDAO.getInstance();
		List<GuestVO> glist = gdao.guestList(1, 3);
		List<BoardVO> blist = bdao.boardList(1, 3);
		
		request.setAttribute("glist", glist);
		request.setAttribute("blist", blist);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
