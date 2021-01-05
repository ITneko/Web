<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>exUserSerlvetJSTL 회원관리 프로그램</h1>
	<h3><a href="user_insert">회원가입</a></h3>
	<c:if test="${empty userid }">
	<h3><a href="user_login">로그인</a></h3>
	</c:if>
	<c:if test="${!empty userid }">
	<h3><a href="user_logout">로그아웃</a></h3>
	</c:if>
	<h3><a href="user_list">리스트</a></h3>
</body>
</html>