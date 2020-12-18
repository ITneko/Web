<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
    
<%

	// 값 받기
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	Connection conn = null;
	PreparedStatement pstmt = null;	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jslhrd46", "1234");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String query = "insert into tbl_guest(idx,name,subject,contents) values(tbl_guest_seq_idx.nextval,?,?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, subject);
		pstmt.setString(3, contents);
		int row = pstmt.executeUpdate();
		if(row == 1){

	%>
	<script>
		alert("성공!");
		location.href = "guest_list.jsp";
	</script>
	<%
	}else{
	%>
	<script>
		alert("실패!");
	</script>
	<%
	}
	%>

%>