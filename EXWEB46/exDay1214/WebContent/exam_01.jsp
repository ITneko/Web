<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%!
 	int add(int x, int y){
	 int result = 0;
	 for(int i=x; i<y; i++){
		 result += i;
	 }
	 return result;
 }
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
	int s = 0;
 	for(int x=0; x<=100; x++){
 		s+=x;
 		if(x%2==0){
 			
 %>
	<h3 style="color:red">  <%=x %></h3>
<%
}else{
	
%>
<h3 style="color:blue">  <%=x %></h3>
<%
}
 	}
%>
	<h2>합계 : <%=s %> </h2>
	
</body>
</html>