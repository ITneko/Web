<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty user }">
	<script>
		alert("유저 전용 게시판입니다! 로그인을 해주세요!");
		location.href="User?cmd=index";
	</script>
</c:if>

<html>
<head><title>자료 삭제</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
</head>
<body>
  <table border="0" cellpadding="0" cellspacing="0" width="300" align="center">
  <tr>
    <td height="50">
    <img src="./img/bullet-05.gif"> <b><font size="3" color="red">잠깐 !!</font></b></td></tr>
  <tr>
    <td valign="middle" height="30">
    <font size="2" face="돋움">게시물은 작성하신 분만 삭제할 수 있습니다.<br>
    글의 비밀번호를 입력해 주세요...</font></td></tr>
  <tr>
  <form name="delete" method="post" action="Pds?cmd=pds_delete_pro&idx=${idx }&page=${page}">
    <td valign="middle" height="40">
    <font size="2" face="돋움">비밀번호 <input type="password" name="pass" size="8"></font>
    <input type="button" value="삭제" onClick="submit()">
    <input type="button" value="닫기" onClick="self.close()"> </td></tr>
    </form>
  </table>
</body>
</html>