package com.jslhrd.service.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.domain.pds.PdsDAO;
import com.jslhrd.domain.pds.PdsVO;
import com.jslhrd.service.Action;

public class PdsViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		PdsDAO dao = PdsDAO.getInstance();
		
		boolean bool=false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
			info = cookies[i];
			if(info.getName().equals("pdsList"+idx)) {
				bool = true;
				break;
			}
		}
		
		String newValue = ""+System.currentTimeMillis();
		if(!bool) {
			Cookie cookie = new Cookie("pdsList"+idx, newValue);
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			dao.pdsReadCount(idx);
		}
		
		PdsVO vo = dao.pdsView(idx);
		
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_view.jsp");
		rd.forward(request, response);
	}

}
