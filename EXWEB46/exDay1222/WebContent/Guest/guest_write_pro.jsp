<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd46";
	String myPass = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String password = request.getParameter("password");
	String ip = request.getRemoteAddr();
	
	int totcount = 0; // 전체 건 수
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	String query = "insert into tbl_guest2(idx, name, subject, contents, ip, password) values(tbl_guest2_seq_idx.nextval,?,?,?,?,?)";
	pstmt = conn.prepareStatement(query);
	pstmt.setString(1, name);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
	pstmt.setString(4, ip);
	pstmt.setString(5, password);
	int row = pstmt.executeUpdate();
	if(row == 1){
		
%>
<script>
	alert("작성성공");
	location.href="guest_list.jsp";
</script>
<%
	}else{
%>
<script>
	alert("작성실패");
	history.back();
</script>
<%
	}
%>