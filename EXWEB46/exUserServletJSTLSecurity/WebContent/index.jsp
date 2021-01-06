<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>exUserSerlvetJSTLSecurity 회원관리 프로그램 비밀번호 암호화</h1>
	
	<c:if test="${empty userid }">
	<h3><a href="user_insert">회원가입</a></h3>
	<h3><a href="user_login">로그인</a></h3>
	</c:if>
	<c:if test="${!empty userid }">
	<h3><a href="user_logout">로그아웃</a></h3>
	</c:if>
	<h3><a href="user_list">리스트</a></h3>
</body>
</html>