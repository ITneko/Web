<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Login</title>

 </head>

 <body>
 
   <table width="100%" height="120" border="0">
   <form name="login_form" action="User?cmd=user_login_ok" method="post" >
     <c:if test="${empty user }">
     <tr>
       <td colspan="2" bgcolor="#6FA0E" height="20" align="center">
       
         <font size="2" color="white"><b>Member Login</b></font>
       </td>
     </tr>
     <tr>
       <td ><font size="2">아 이 디</font></td>
       <td ><input type="text" size="10" name="userid"></td>
     </tr>
     <tr>
       <td><font size="2">비밀번호</font></td>
			 <td>
         <input type="password" size="10" name="passwd">
       </td>
     </tr>
     <tr>
       <td><input type="image" src="Include/img/login1.gif" border="0" onClick="return check_login()"></td>
			 <td>
           <a href="User?cmd=user_insert"><img src="Include/img/regist.gif" border="0"></a>
       </td>
     </tr>
 </form>
 </c:if>
 </table>
 <table width="100%" height="120" border="0">
   <tr>
      <c:if test="${!empty user }">
     <td bgcolor="#6FA0E" align="center" height="20">
  
       <font size="2" color="white">${user.name } 님!</font>
     </td>
   </tr>
   <tr>
     <td align="center">
       <font size="2">
       
       <a href="Admin?cmd=admin_index">관리자 페이지</a><br>
       <a href="User?cmd=user_logout">로그오프</a><br>
       <a href="User?cmd=user_modify">회원정보수정</a><br>
       </font>
     </td>
      </c:if>
   </tr>
 </table>

 <table width="100%" height="120" border="0">
   <tr>
   <c:if test="${!empty user }">
     <td bgcolor="#6FA0E" align="center" height="20">
     
       <font size="2" color="white">${user.name } 님!</font>
     </td>
   </tr>
   <tr>
     <td align="center">
       <font size="2">
       <a href="User?cmd=user_logout">로그오프</a><br>
       <a href="User?cmd=user_modify">회원정보수정</a>
       <a href="#">회원탈퇴</a>
       </font>
     </td>
     </c:if>
   </tr>
 </table>
 </body>
 </html>
