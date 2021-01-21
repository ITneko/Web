<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${row==1 }">
<script>
	alert("수정성공!");
	location.href="User?cmd=index";
</script>
</c:if>
	
<c:if test="${row==0 }">
<script>
	alert("수정실패!");
	history.back();
</script>
</c:if>
