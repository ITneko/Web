<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty user }">
	<script>
		alert("유저 전용 게시판입니다! 로그인을 해주세요!");
		location.href="User?cmd=index";
	</script>
</c:if>

<script>
	function send(){
		if(pds.name.value == ""){
			alert("이름을 입력해주세요");
			pds.name.focus();
			return;
		}
		if(pds.email.value == ""){
			alert("이메일을 입력해주세요");
			pds.email.focus();
			return;
		}
		if(pds.subject.value == ""){
			alert("제목을 입력해주세요");
			pds.subject.focus();
			return;
		}
		if(pds.contents.value == ""){
			alert("내용을 입력해주세요");
			pds.contents.focus();
			return;
		}
		if(pds.pass.value == ""){
			alert("비밀번호를 입력해주세요");
			pds.pass.focus();
			return;
		}
		pds.submit();		
	}
	
</script>
<html>
   <head><title> 자료 올리기 </title>
   </head> 
<body>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<%@ include file="/Include/topmenu.jsp" %>
<table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">
<!--  <%@ include file="/Include/login_form.jsp" %>-->
<!--     다음에 추가할 로그인  -->

   </td>
   
   <td width="80%" valign="top">&nbsp;<br>
     <img src="Pds/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>참 좋은 자료실</b></font>
     <font size="2"> - 자료올리기</font><p>
     <img src="Pds/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="Pds/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
	<form name="pds" method="post" enctype="multipart/form-data" action="Pds?cmd=pds_write_pro">
	  <table border="0" >
		<tr>
         <td width="5%" align="right"><img src="Pds/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%">
			<input type="text" size="20" name="name"></td>
		</tr>
		<tr> 
		  <td align="right">&nbsp;</td>
          <td><font size="2" face="돋움">메일주소</font></td>
		  <td><input type="text" size="20" name="email"></td>
		</tr>	
       <tr>
         <td align="right"><img src="Pds/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject"></td>
       </tr>
       <tr>
         <td align="right"><img src="Pds/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
		<tr>
		  <td align="right"><img src="Pds/img/bullet-02.gif"></td>
		  <td><font size="2" face="돋움">파일첨부</font></td>
		  <td><input type="file" name="filename" size="30"></td></tr>
		<tr>
       <tr>
         <td align="right"><img src="Pds/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" > 
          <font size="2" face="돋움">*.게시글의 수정 및 삭제시 필요.</font>
         </td>
        </tr>

		<tr></tr>			<tr></tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td align=center>
			<img src="Pds/img/purple_save.gif" width="56" height="18" border="0" onClick="send()">
			<img src="Pds/img/purple_cancle.gif" width="56" height="18" border="0" onClick="history.back()">

		  </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
 </table>
</body>		
</html>
