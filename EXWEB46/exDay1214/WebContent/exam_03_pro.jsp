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
%>

	<table border=1>
		<tr>
			<td><center>결과</center></td>
			<td><%=x %> + <%=y %> = <%=x+y %></td>
		</tr>
	</table>
</body>
</html>