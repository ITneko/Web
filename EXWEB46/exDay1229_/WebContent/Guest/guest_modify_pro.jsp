<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");

	if(row == 1){
%>
<script>
	alert("수정성공!");
	location.href="guest_list.do";
</script>
<%
	}else{
%>
<script>
	alert("수정실패!");
	history.back();
</script>
<%
}
%>
