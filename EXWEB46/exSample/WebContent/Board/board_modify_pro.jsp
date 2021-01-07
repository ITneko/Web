<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:choose>
	<c:when test="row==1">
		<script>
		alert("수정성공!");
		location.href="board_list?page="+${page};
		</script>
	</c:when>
	<c:when test="row==0">
		<script>
		alert("수정실패!");
		history.back();
		</script>
	</c:when>

	<c:otherwise>
	</c:otherwise>
</c:choose>
