<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd46";
	String myPass = "1234";
%>

<%
	// DB 연동 테스트
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL,myID,myPass);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	int idx = Integer.parseInt(request.getParameter("idx"));
			
    String pass = request.getParameter("pass");
    
    String query="delete from tbl_board where idx=? and pass =?";
	pstmt = conn.prepareStatement(query);
	pstmt.setInt(1, idx);
	pstmt.setString(2, pass);
	int row = pstmt.executeUpdate();
	if(row == 1){
%>
	<script>
		alert("삭제 성공!");
		location.href="board_list.jsp";
	</script>
<%
}else{
%>
	<script>
		alert("삭제 실패!");
		history.back();
	</script>
<%
}
%>