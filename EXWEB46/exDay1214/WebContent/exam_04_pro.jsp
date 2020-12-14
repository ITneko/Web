<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int x = Integer.parseInt(request.getParameter("i"));
	int y = Integer.parseInt(request.getParameter("y"));
	String op = request.getParameter("op");
	int result = 0;
	switch(op){
		case "+":
			result = x+y;
		break;
		
		case "-":
			result = x-y;
			break;
			
		case "*":
			result = x*y;
			break;
			
		case "/":
			result = x/y;
			break;
	}
%>

	<table border=1>
		<tr>
			<td><center>결과</center></td>
			<td><%=x %> <%=op %> <%=y %> = <%=result %></td>
		</tr>
	</table>
</body>
</html>