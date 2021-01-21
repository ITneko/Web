package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UsersDAO;
import com.jslhrd.service.Action;
import com.jslhrd.util.SHA256Util;

public class UserPasswdSearchOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String email = request.getParameter("email");
		String passwd = getRandomPassword.getRamdomPassword(10);
		String pass = SHA256Util.getEncSHA256(passwd);
		UsersDAO dao = UsersDAO.getInstance();
		int row = dao.userPasswdReset(pass, userid, email);
	 	
		if(row==1) {
			request.setAttribute("passwd", passwd);
			}
		request.setAttribute("userid", userid);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_passwdsearch.jsp");
		rd.forward(request, response);
	}

}
