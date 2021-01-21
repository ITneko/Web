package com.jslhrd.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.notice.NoticeDAO;
import com.jslhrd.domain.notice.NoticeVO;
import com.jslhrd.service.Action;

public class NoticeModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));

		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO admin = new NoticeVO();

		admin.setSubject(request.getParameter("subject"));
		admin.setContents(request.getParameter("contents"));
		admin.setIdx(idx);
		int row = dao.noticeModify(admin);

		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_modify_pro.jsp");
		rd.forward(request, response);
	}

}
