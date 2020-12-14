<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="aa" mathod="post" action="exam_04_pro.jsp">
	<table border=1>
		<tr>
			<td><center>입력</center></td>
		</tr>
		<tr>
			<td>값1<input type="text" id="a" name="i" size="10"><<td>
			
		</tr>
		<tr>
			<td><select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>>
			</select>
		</tr>
		<tr>
			<td>값2<input type="text" id="a2" name="y" size="10"></td>
		</tr>
		<tr>
		 	<td><center><input type="button" value="계산" onClick="aa.submit()"></center></td>
		</tr>
	</table>
	</form>
</body>
</html>