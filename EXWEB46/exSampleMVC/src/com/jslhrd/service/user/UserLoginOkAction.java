package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.domain.user.UsersDAO;
import com.jslhrd.domain.user.UsersVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.SHA256Util;

public class UserLoginOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		
		UsersDAO dao = UsersDAO.getInstance();
		int row = dao.userLogin(userid, passwd);
		if(row == 1) {
			HttpSession session = request.getSession();
			UsersVO user = dao.userSelect(userid);
			session.setMaxInactiveInterval(1800);
			session.setAttribute("user", user);
		}
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/userlogin_ok.jsp");
		rd.forward(request, response);
	}

}
