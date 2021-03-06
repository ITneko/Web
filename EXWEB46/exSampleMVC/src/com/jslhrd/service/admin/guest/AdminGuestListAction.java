package com.jslhrd.service.admin.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.guest.GuestDAO;
import com.jslhrd.domain.guest.GuestVO;
import com.jslhrd.service.Action;
import com.jslhrd.util.PageIndex;

public class AdminGuestListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GuestVO vo = new GuestVO();
		GuestDAO dao = GuestDAO.getInstance();
		int totcount = dao.guestCount();
		
		int nowpage= 1;
		int maxlist = 10;
		int totpage =1;
		
		if(totcount % maxlist ==0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount /maxlist + 1;
		}
		
		if(totcount == 0 ) totpage = 1;
		
		if(request.getParameter("page")!=null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if(nowpage>totpage) nowpage = totpage;
		
		int startpage = (nowpage-1)*maxlist +1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1)*maxlist);
		
		List<GuestVO> list = null;
	
		list = dao.guestList(startpage, endpage);
		
		
		String pageSkip = "";
	
		pageSkip = PageIndex.pageList(nowpage, totpage, "guest_list", "");

		
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("page", nowpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/guest_list.jsp");
		rd.forward(request, response);
	}

}
