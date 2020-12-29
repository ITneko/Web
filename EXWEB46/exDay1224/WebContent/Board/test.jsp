<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="exDay1224.model.* , java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	GuestDAO dao = GuestDAO.getInstance();

	boolean bool = false;
	Cookie info = null;
	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i<cookies.length; i++){
		info = cookies[i];
		if(info.getName().equals("BoardList"+idx)){
	bool = true;
	break;
		}
	}
	
	String newValue = "" + System.currentTimeMillis();
	if(!bool){
		info = new Cookie("BoardList"+idx, newValue);
		info.setMaxAge(24*60*60);
		response.addCookie(info);
		dao.BoardReadCount(idx);
	}
%>