<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty user }">
	<script>
		alert("유저 전용 게시판입니다! 로그인을 해주세요!");
		location.href="User?cmd=index";
	</script>
</c:if>

<script>

	function b_search(){
		alert("dd");
		if(b_search.key.value == ""){
			alert("값을 입력해주세요!");
			b_search.key.focus();
			return
		}
		b_search.submit();
	}
	
	
</script>

<html>
   <head>
      <title> 자료실 리스트 보기 </title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css">
	<style type="text/css">
		a.list {text-decoration:none;color:black;font-size:10pt;}
	</style>
   </head> 

<!-- 제목 부분 출력 -->
<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
<%@ include file="/Include/topmenu.jsp" %>
  <table border="0" width="800">
    <tr>
      <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">

<!--  다음에 추가할 부분 -->
<%@ include file="/Include/login_form.jsp" %>
</td>

	  <td width="80%" valign="top">	
    <br>
    <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="Pds/img/bullet-01.gif"> <b>참 좋은 자료들</b></font></td></tr>
      <tr>
        <td colspan="7" align="right" valign="middle" height="20">
		  <font size="2" face="고딕">전체 : <b>${totcount }</b>건 </font>
		</td>
	  </tr>
	  <tr bgcolor="e3e9ff">
        <td width="7%" align="center" height="20"><font face="돋움" size="2">번호</font></td>
        <td width="32%" align="center" height="20"><font face="돋움" size="2">제목</font></td>
        <td width="35%" align="center" height="20"><font face="돋움" size="2">파일이름 및 크기</font></td>
        <td width="10%" align="center" height="20"><font face="돋움" size="2">올린이</font></td>
        <td width="11%" align="center" height="20"><font face="돋움" size="2">날짜</font></td>
        <td width="5%" align="center" height="20"><font face="돋움" size="2">조회</font></td></tr>
<c:if test="${totcount == 0 }">
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25" colspan="5">
        <font face="돋움" size="2" color="#000000">등록된 자료가 없습니다.</font></td>
        </tr>
        </c:if>
<c:if test="${totcount !=0 }">        
<c:forEach var="list" items="${list }">
      <tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25">
        <font face="돋움" size="2" color="#000000">${listcount }</font></td>
				<td align="left" height="20">&nbsp;<font face="돋움" size="2"><a href="Pds?cmd=pds_view&idx=${list.idx }&page=${page}">${list.subject }</a></font></td>
        <td align="center" height="20"><font face="돋움" size="2">${list.filename }</td>
				<td align="left" height="20"><font face="돋움" size="2">${list.name }</font></td>
				<td align="left" height="20"><font face="돋움" size="2">${list.regdate.substring(0,10) }</font></td>
				<td align="center" height="20"><font face="돋움" size="2">${list.readcnt }</font></td> 	      
			</tr>  	   
			<c:set var="listcount" value="${listcount-1 }"/>
 </c:forEach>     
 </c:if>
      <tr>
       <td colspan="7"><hr width="100%"></td></tr>
	   <tr>
         <td colspan="5" align="center">
         <font face="돋움" size="2" color="#000000">${pageSkip }</td>
		</tr>
   <tr>
      <td colspan="7" align="right">
				<a href="Pds?cmd=pds_write&page=${page }"><img src="Pds/img/write.gif" alt="자료등록" align="middle" border="0"></a>
      &nbsp;
	  </td>
   </tr>
	<form name=b_search action="pds_list.do" method="post">
     <table border="0" cellspacing="0" width="100%">
      <tr>
      <td><center>
      <font color="#004080" size="4" face="Courier New"><strong>Search&nbsp;</strong></font>
        <select name="search" size="1" style="font-family: 돋움체">
		   <option value="subject" <c:if test="${search=='subject' }"> selected </c:if> >  글제목</option>
		   <option value="name" <c:if test="${search=='name' }"> selected </c:if> >작성자</option>
		   <option value="contents" <c:if test="${search=='contents' }"> selected </c:if> >글내용</option>
		</select>
		&nbsp;&nbsp;<input type="text" name="key" value="${key }" size="20">
		&nbsp;&nbsp;<input type="image" src="Pds/img/search2.gif" align="middle" onClick="b_search()" >
	   </td>
	   </tr>
    </table>
   </table>
	</td></tr>
</body>

