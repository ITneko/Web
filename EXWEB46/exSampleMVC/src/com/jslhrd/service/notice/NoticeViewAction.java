package com.jslhrd.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.notice.NoticeDAO;
import com.jslhrd.domain.notice.NoticeVO;
import com.jslhrd.service.Action;

public class NoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = 0;
		if (request.getParameter("page") != null) {
			Integer.parseInt(request.getParameter("page"));
		}
		request.setCharacterEncoding("UTF-8");

		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO admin = null;
		admin = dao.noticeView(idx);
		

		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("NoticeList" + idx)) {
				bool = true;
				break;
			}
		}

		String newValue = "" + System.currentTimeMillis();
		if (!bool) {
			info = new Cookie("NoticeList" + idx, newValue);
			info.setMaxAge(24 * 60 * 60);
			response.addCookie(info);
			dao.noticeReadCount(idx);
		}
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("admin", admin);

		RequestDispatcher rd = request.getRequestDispatcher("Admin/notice_view.jsp");
		rd.forward(request, response);
	}

}
