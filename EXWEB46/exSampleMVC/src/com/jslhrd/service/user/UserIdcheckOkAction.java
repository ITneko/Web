package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UsersDAO;
import com.jslhrd.service.Action;

public class UserIdcheckOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		UsersDAO dao = UsersDAO.getInstance();
		int row = dao.userCheck(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_idcheck.jsp");
		rd.forward(request, response);
	}

}
