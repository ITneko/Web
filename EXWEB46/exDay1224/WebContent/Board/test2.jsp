<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="exDay1224.model.* , java.util.*,exDay1224.util.*"%>
<%
	String url = "Board_list.jsp";
	String search = "";
	String key = "";
	GuestDAO dao = GuestDAO.getInstance();
	int count;
	List<BoardVO> vo;
	if(key.equals("")){
		count = dao.BoardCount();
		vo = dao.BoardList();
	}else{
		count = dao.BoardCount2(search, key);
		vo = dao.BoardSList(search, key);
	}

	int nowpage = 1;
	int maxlist = 10;
	int totpage = 1;
	
	if(count / maxlist == 0 ){
		totpage = count/maxlist;
	}else{
		totpage = count/maxlist+1;
	}
	if(totpage==0) totpage = 1;
	if(request.getParameter("page") != null){
		nowpage = Integer.parseInt(request.getParameter("page"));
	}
	
	if(nowpage>totpage) nowpage = totpage;
	
	int startpage = (nowpage-1)*maxlist+1;
	int endpage = nowpage*maxlist;
	int listcount = count - ((nowpage-1)*maxlist);
%>