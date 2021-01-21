package com.jslhrd.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UsersDAO;
import com.jslhrd.domain.user.UsersVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.SHA256Util;

public class UserInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		String tel = request.getParameter("tel");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		
		UsersVO vo = new UsersVO();
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPasswd(passwd);
		vo.setTel(tel);
		vo.setEmail(email);
		
		UsersDAO dao = UsersDAO.getInstance();
		int row = dao.userInsert(vo);
		request.setAttribute("row", row);
				
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_insert_pro.jsp");
		rd.forward(request, response);
	}

}
