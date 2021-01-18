<%@ page contentType="text/html; charset=UTF-8" %>

<script>
	function in_check(){
		if(guest.pass.vlaue == ""){
			alert("비밀번호을 입력해주세요");
			guest.pass.focus();
			return;
		}
		if(guest.subject.vlaue == ""){
			alert("제목을 입력해주세요");
			guest.subject.focus();
			return;
		}
		if(guest.contents.vlaue == ""){
			alert("내용을 입력해주세요");
			guest.contents.focus();
			return;
		}
		guest.submit();
	}

</script>
 <html>
   <head><title>방명록 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">

</head>
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

   <!-- 다음에 추가할 부분 "-->
   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="Guest/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>방 명 록</b></font>
     <font size="2"> - 수정하기</font><p>
     <img src="Guest/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="Guest/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     
		 <form method="post" action="Guest?cmd=guest_modify_pro&idx=${idx }&page=${page}" name="guest">
			<input type="hidden" name="idx" value="${idx }">
      <input type="hidden" name="page" value="${page }">

      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="Guest/img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" name="name" value="${vo.name }" readonly></td>
       </tr>
       <tr>
         <td width="5%" align="right"><img src="Guest/img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">비밀번호</font></td>
         <td width="80%">
         <input type="password" size="20" name="pass" value="" ></td>
       </tr>
       <tr>
         <td align="right"><img src="Guest/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject" value="${vo.subject }"></td>
       </tr>
       <tr>
         <td align="right"><img src="Guest/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60" >${vo.contents }</textarea></td>
       </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td><input type="button" value="수정하기" onClick="in_check();">&nbsp;
          <input type="button" value="돌아가기" onClick="history.back();"></td></tr>
      </table>
      </form>
    </td></tr>
  </table>
  </body>
  </html>
   