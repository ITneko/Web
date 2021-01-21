package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UsersDAO;
import com.jslhrd.service.Action;

public class UserIdsearcOkhAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tel = request.getParameter("tel");
		UsersDAO dao = UsersDAO.getInstance();
		String userid = dao.userSearch(tel);
		System.out.println(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("tel", tel);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_idsearch.jsp");
		rd.forward(request, response);
	}

}
