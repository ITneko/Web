package com.jslhrd.service.admin.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.service.Action;

public class AdminGuestDeleteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		System.out.println(idx);
		System.out.println(page);
		
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.adminGuestDelete(idx);
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/guest_delete_pro.jsp");
		rd.forward(request, response);
	}

}
