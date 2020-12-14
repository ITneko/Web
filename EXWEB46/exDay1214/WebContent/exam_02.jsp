<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>번호</td><td>이름</td><td>전화</td>
		</tr>
<%
	String[][] hak={{"1","홍길동","111"},{"2","김길동","222"},{"3","고길동","333"},{"4","하길동","444"},{"5", "임길동", "555"}};
	for(int i=0; i<hak.length; i++){
	
%>
		<tr>
			<td><%=hak[i][0] %></td><td><%=hak[i][1] %></td><td><%=hak[i][2] %></td>
		</tr>
<%
	}
%>
		
		
	</table>
</body>
</html>