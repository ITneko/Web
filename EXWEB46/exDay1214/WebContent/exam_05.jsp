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
		if (request.getParameter("i") == null) {
	%>
	<form name="aa" mathod="post" action="exam_05.jsp">
		<table border=1>
			<tr>
				<td><center>입력</center></td>
			</tr>
			<tr>
				<td>값1<input type="text" id="a" name="i" size="10"></td>
			</tr>
			<tr>
				<td><center><select name="op">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>>
						</center>
				</select>
			</tr>
			<tr>
				<td>값2<input type="text" id="a2" name="y" size="10"></td>
			</tr>
			<tr>
				<td><center>
						<input type="button" value="계산" onClick="aa.submit()">
					</center></td>
			</tr>
		</table>
	</form>
	<%
		} else {

			int x = Integer.parseInt(request.getParameter("i"));
			int y = Integer.parseInt(request.getParameter("y"));
			String op = request.getParameter("op");
			double result = 0;
			switch (op) {
			case "+":
				result = x + y;
				break;

			case "-":
				result = x - y;
				break;

			case "*":
				result = x * y;
				break;

			case "/":
				result = x / (double)y;
				break;
			}
	%>
	<table border=1>
		<tr>
			<td><center>계산결과</center></td>
		</tr>
		<tr>
			<td><%=x%> <%=op%> <%=y%></td>
		</tr>
		<tr>
			<td><%=result%></td>
		</tr>
	</table>
	<%
		}
	%>


</body>
</html>