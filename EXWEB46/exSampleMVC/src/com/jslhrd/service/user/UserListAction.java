package com.jslhrd.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.user.UsersDAO;
import com.jslhrd.domain.user.UsersVO;
import com.jslhrd.service.Action;

public class UserListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsersDAO dao = UsersDAO.getInstance();
		List<UsersVO> list = dao.userList();
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("Users/user_list.jsp");
		rd.forward(request, response);
	}

}
