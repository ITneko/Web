<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="exDay1224.model.* , java.util.*"%>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	
	BoardDAO dao = BoardDAO.getInstance();
	
	int row = dao.BoardDelete(idx,pass);
	if (row == 1) {
%>
<script>
	alert("삭제성공");
	opener.location.replace("board_list.jsp");
	self.close();
</script>
<%
	} else {
%>
<script>
	alert("작성실패")
	history.back();
</script>
<%
	}
%>