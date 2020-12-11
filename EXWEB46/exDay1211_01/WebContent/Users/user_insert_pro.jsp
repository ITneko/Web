<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	request.setCharacterEncoding("utf-8"); 
 
 	int kor=Integer.parseInt(request.getParameter("kor"));
 
 	String name = request.getParameter("name");
 	String userid = request.getParameter("userid");
 	String passwd = request.getParameter("passwd");
 	String gender = request.getParameter("gender");
 	String tel = request.getParameter("tel");
 	String email1 = request.getParameter("email1");
 	String email2 = request.getParameter("email2");
 	String email3 = request.getParameter("email3");
 	%>

 	
 	<% 
 	
 	// 처리
 	int row=1;
 	if(row==1){
 		
	
 %>
 <script>
 	alert("OK");
 	location.href="user_list.jsp";
 </script>
 <%
 	}else{
 
 %>
 <script>
 	alert("NO");
 	history.back;
 </script>
 <%
 	}
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>