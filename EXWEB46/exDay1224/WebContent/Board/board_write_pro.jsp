<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="exDay1224.model.* , java.util.*" %>

<%
	GuestDAO dao = GuestDAO.getInstance();
	BoardVO vo = new BoardVO();
	
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	vo.setPass(request.getParameter("pass"));

	int row = dao.BoardWrite(vo);
	if(row == 1){
%>
<script>
	alert("작성성공");
	location.href="board_list.jsp";
</script>
<%
}else{
%>
<script>
	alert("작성실패")
	history.back();
</script>
<%
}
%>