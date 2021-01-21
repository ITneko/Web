package com.jslhrd.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.notice.NoticeDAO;
import com.jslhrd.domain.notice.NoticeVO;
import com.jslhrd.service.Action;

public class NoticeModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));

		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO admin = dao.noticeView(idx);

		request.setAttribute("admin", admin);
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify.jsp");
		rd.forward(request, response);
	}

}
