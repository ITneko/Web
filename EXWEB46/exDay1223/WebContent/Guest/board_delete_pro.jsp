<%@page import="exDay1223.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	out.print(idx);
	out.print(pass);
	GuestDAO dao = new GuestDAO();
	int row = dao.guestDelete(idx, pass);
	
	if(row == 1){
%>
	<script>
		alert("삭제 성공!");
		location.href="guest_list.jsp";
	</script>
<%
}else{
%>
	<script>
		alert("삭제 실패!");
		history.back();
	</script>
<%
}
%>