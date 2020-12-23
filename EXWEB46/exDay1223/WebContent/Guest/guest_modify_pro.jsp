<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="exDay1223.model.*" %>
<% 
	request.setCharacterEncoding("UTF-8");

	GuestVO guest = new GuestVO();
	
	guest.setIdx(Integer.parseInt(request.getParameter("idx")));
	guest.setName(request.getParameter("name"));
	guest.setPass(request.getParameter("pass"));
	guest.setSubject(request.getParameter("subject"));
	guest.setContents(request.getParameter("contents"));
	
	GuestDAO dao = new GuestDAO();
	int row = dao.guestEdit(guest);
	if(row == 1){
%>
<script>
	alert("작성성공!");
	location.href="guest_list.jsp";
</script>
<%
}else{
%>
<script>
	alert("작성실패!");
	history.back();
</script>
<%
}
%>