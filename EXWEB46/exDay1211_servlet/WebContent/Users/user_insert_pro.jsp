<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  
 이름 : ${name } <br>
 row : ${row } <br>
 
 <%
 	String name = (String)request.getAttribute("name");
 	int row = (int)request.getAttribute("row");
 %>
 이름 : <%=name %>
    
    
 <<%-- %
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
 %> --%>
 