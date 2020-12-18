<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%

	// db  연결 설정 department 테이블
	
	
	String query="select * from department";
	pstmt = conn
			rs = pstmt.executeQuery();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>부서번호</td><td>부서명</td><td>지역명</td>
		</tr>
<%
	while(rs.next()){
		int dno = rs.getInt("dno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
%>
		<tr>
			<td><%=dno %></td><td><%=dname %></td><td><%=loc %></td>
		</tr>
<%
} 
%>
	</table>
</body>
</html>