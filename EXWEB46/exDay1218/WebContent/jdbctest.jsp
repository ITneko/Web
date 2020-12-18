<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%
	// 1. 드라이버 로딩
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		out.print("드라이버 로딩 성공");
	}catch(Exception e){
		e.printStackTrace();
	}

	// 2. DB 연결 설정
	try{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jslhrd46", "1234");
		out.print("커넥션 연결 성공");
	}catch(Exception e){
		e.printStackTrace();
	}
%>
