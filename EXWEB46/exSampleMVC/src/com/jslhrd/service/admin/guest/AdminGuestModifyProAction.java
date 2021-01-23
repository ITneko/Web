package com.jslhrd.service.admin.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.service.Action;

public class AdminGuestModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		String subject = request.getParameter("subject");
		String pass = request.getParameter("pass");
		String contents = request.getParameter("contents");
		
		
		GuestVO vo = new GuestVO();
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setPass(pass);
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestModify(vo, idx);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/guest_modify_pro.jsp");
		rd.forward(request, response);
	}

}
