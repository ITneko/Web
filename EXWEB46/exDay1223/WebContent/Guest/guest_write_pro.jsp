<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="exDay1223.model.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	
	GuestVO guest = new GuestVO();
	guest.setName(name);
	guest.setPass(pass);
	guest.setSubject(subject);
	guest.setContents(contents);
	
	GuestDAO dao = new GuestDAO();
	int row = dao.guestWrite(guest);
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