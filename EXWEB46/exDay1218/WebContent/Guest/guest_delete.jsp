<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;	

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jslhrd46", "1234");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String query = "delete from tbl_guest where idx=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idx);
		int row = pstmt.executeUpdate();
		if(row == 1){
	%>
	<script>
			alert("삭제성공!");
			location.href = "guest_list.jsp";
		</script>
		<%
		}else{
		%>
		<script>
			alert("실패!");
			location.href = history.back;s
		</script>
		<%
		}
		%>
%>