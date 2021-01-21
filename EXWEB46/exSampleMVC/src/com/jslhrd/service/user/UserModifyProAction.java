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

public class UserModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String passwd = SHA256Util.getEncSHA256(request.getParameter("passwd"));
		String newpasswd = SHA256Util.getEncSHA256(request.getParameter("newpasswd"));
		String tel = request.getParameter("tel");
		
		UsersVO vo = new UsersVO();
		UsersDAO dao = UsersDAO.getInstance();
		
		vo.setUserid(userid);
		vo.setPasswd(passwd);
		vo.setNewpasswd(newpasswd);
		vo.setTel(tel);
		int row = dao.userModify(vo);
	
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_modify_pro.jsp");
		rd.forward(request, response);
	}

}
