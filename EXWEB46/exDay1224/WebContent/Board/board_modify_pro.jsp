<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="exDay1224.model.* , java.util.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	BoardVO vo = new BoardVO();
	vo.setIdx(Integer.parseInt(request.getParameter("idx")));
	vo.setPass(request.getParameter("pass"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	vo.setEmail(request.getParameter("email"));
	
	
	GuestDAO dao = GuestDAO.getInstance();
	int row = dao.BoardModify(vo);
	if(row == 1){
%>
<script>
	alert("수정성공");
	location.href = "board_list.jsp";
</script>
<%
	}else{
%>
<script>
	alert("수정실패")
	history.back();
</script>
<%
	}
%>