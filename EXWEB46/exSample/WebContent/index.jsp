<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Include/topmenu.jsp" %>
 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title> 메인 페이지</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>

 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">
			 	<%@ include file="Include/login_form.jsp" %>
		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
      
      <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="Board/img/bullet-01.gif"> <b>방명록</b></font></td></tr>
	   <tr bgcolor="e3e9ff">
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
	   <c:forEach var="glist" items="${glist }">
	   <tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
			<td align="left" height="20">&nbsp;
				<font face="돋움" size="2" color="#000000">
				<a class="list" href="guest_view?idx=${glist.idx }">${glist.subject }</a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" >${glist.name }</font></td>
				<td align="center" height="20"><font face="돋움" size="2">${glist.regdate.substring(0,10) }</font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				${glist.readcnt }</font></td>
			</tr>
		</tr>
		</c:forEach>
  		</table>
  	<hr>
      <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="Board/img/bullet-01.gif"> <b>게시판</b></font></td></tr>
	   <tr bgcolor="e3e9ff">
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
	    <c:forEach var="blist" items="${blist }">
	   <tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
			<td align="left" height="20">&nbsp;
				<font face="돋움" size="2" color="#000000">
				<a class="list" href="board_view?idx=${blist.idx }">${blist.subject }</a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" >${blist.name }</font></td>
				<td align="center" height="20"><font face="돋움" size="2">${blist.regdate.substring(0,10) }</font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				${blist.readcnt }</font></td>
		</tr>
		</c:forEach>
  		</table>
  

    </td>
  </tr>
  </table>
  </body>
  </html>

 <%@ include file="Include/copyright.jsp" %>

