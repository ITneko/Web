<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty user }">
	<script>
		alert("관리자 전용 게시판입니다! 로그인을 해주세요!");
		location.href="index";
	</script>
</c:if>
<html>
<head>

<title>회원목록 보여주기</title>

<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
</head>
<body>

<table width="550" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#173E7C" bordercolordark="white">
  <tr>
    <td width=50 align=center>번호</td>
    <td width=50 align=center>ID</td>
    <td width=80 align=center>이름</td>
    <td width=100 align=center>전화번호</td>
    <td width=100 align=center>등록일자</td>
    <td width=100 align=center>최근접속일</td>
    
  </tr>
  <c:set var="num" value="${1 }"/>
  <c:forEach var="list" items="${list }">
   <tr>
      <td align=center>${num }</td>
      <td align=center>${list.userid }</td>
      <td align=center>${list.name }</td>
      <td align=center>${list.tel }</td>
      <td align=center>${list.first_time }</td>
      <td align=center>${list.last_time }</td>
   </tr>
   <c:set var="num" value="${num+1 }"/>
  </c:forEach>

</table>
<table width=550>
  <tr>
    <td>
      <select name="search_gubun">
        <option >이름 </option>
        <option >주소 </option>
        
    </td>
    <td>  찾는이름:
          <input type="text" name="search_name" size=10> &nbsp;
          <input type=hidden name="user_id" >[조회]</a>
     </td>
   </tr>
  <tr>
    <td>
    </td>
    <td></td>
   </tr>
  <tr>
    <td>로그인 페이지 이동
    </td>
    <td>회원가입페이지 이동</td>
   </tr>
</table>    
</body>
</html>
