package com.jslhrd.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.notice.NoticeDAO;
import com.jslhrd.domain.notice.NoticeVO;
import com.jslhrd.service.Action;

public class NoticeWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//int page = Integer.parseInt(request.getParameter("page"));
		
		NoticeVO notice = new NoticeVO();
		notice.setSubject(request.getParameter("subject"));
		notice.setContents(request.getParameter("contents"));

		System.out.println(notice.getSubject());
		System.out.println(notice.getContents());
		NoticeDAO dao = NoticeDAO.getInstance();
		int row = dao.noticeWrite(notice);
		
		//request.setAttribute("page", page);
		request.setAttribute("row", row);
		System.out.println(row);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_write_pro.jsp");
		rd.forward(request, response);
	}

}
