package com.jslhrd.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.domain.admin.AdminDAO;
import com.jslhrd.service.Action;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminid = request.getParameter("adminid");
		String adminpass = request.getParameter("adminpass");
		System.out.println(adminid);
		System.out.println(adminpass);
		
		AdminDAO dao = AdminDAO.getInstance();
		int row = dao.adminLogin(adminid,adminpass);
		if(row==1) {
			HttpSession session = request.getSession();
			session.setAttribute("adminid", adminid);
			session.setMaxInactiveInterval(60*60);
		}
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/userlogin_ok.jsp");
		rd.forward(request, response);
	}

}
