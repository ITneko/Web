<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");
	String[] str = ((String)request.getAttribute("str")).split(",");
	for(int i=0; i<str.length; i++){
%>

취미:[<%=i+1 %>] : <%=str[i] %>
<br>
<%
	}
%>