<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");

	if(row == 1){
%>
<script>
	alert("작성성공!");
	location.href="board_list.do?page="+${page};
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
