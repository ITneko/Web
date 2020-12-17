<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents").replace("\n", "<br>");
	
	out.print("작성자 : " + name + "<br>");
	out.print("제목 : " + subject + "<br>");
	out.print("내용 : " + contents + "<br>");
%>

   