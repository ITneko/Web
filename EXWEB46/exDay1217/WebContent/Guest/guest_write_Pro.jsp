<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  	request.setCharacterEncoding("UTF-8");  
%>

<jsp:useBean id="guest" class="model.GuestBean">
	<jsp:setProperty name="guest" property="*" />
</jsp:useBean>
<%
	guest.setContents(guest.getContents().replace("\n", "<br>"));
%>
이름 : <%=guest.getName() %><br>
제목 : <%=guest.getSubject() %><br>
내용 : <%=guest.getContents() %><br>