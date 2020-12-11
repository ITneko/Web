<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	
	String[] fa = request.getParameterValues("fa");
	
	String str = fa[0];
	for(int x=1; x<fa.length; x++){
		str = str+ "," + fa[x];
	}

	out.print(str);
%>