<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% 
   request.setCharacterEncoding("utf-8");
   String name = request.getParameter("name");
   String userid = request.getParameter("userid");
   String passwd = request.getParameter("passwd");
   String gender = request.getParameter("gender");
   String tel = request.getParameter("tel");
   String email1 = request.getParameter("email1");
   String email2[] = request.getParameterValues("email2");
   String email3= "";
   
   for(int i=0; i<email2.length; i++){
	   email3 += email2[i];
   }
   %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
<%=name %> 님 회원가입을 환영합니다</h3>
이름 : <%=name %><br>
아이디 : <%=userid %><br>
비번 : <%=passwd %><br>
성별 : <%=gender %><br>
전화 : <%=tel %><br>
이메일 : <%=email1 %>@<%=email3 %>
<h3><a href="user_login.jsp">로그인</a></h3>
</body>
</html>
