<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="exDay1224.model.* , java.util.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));

	GuestDAO dao = GuestDAO.getInstance();
	BoardVO vo = dao.BoardView(idx);
%>

<script>
function send(){
	if(board.name.value == ""){
		alert("이름을 입력해주세요");
		board.name.focus();
		return;
	}
	if(board.email.value == ""){
		alert("이메일을 입력해주세요");
		board.email.focus();
		return;
	}
	if(board.subject.value == ""){
		alert("제목을 입력해주세요");
		board.subject.focus();
		return;
	}
	if(board.contents.value == ""){
		alert("내용을 입력해주세요");
		board.contents.focus();
		return;
	}
	if(board.pass.value == ""){
		alert("비밀번호를 입력해주세요");
		board.pass.focus();
		return;
	}
	
	board.action="board_modify_pro.jsp?idx=<%=idx%>";
	board.submit();
}


</script>
   <head><title>게시판 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">

</head>

 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

   <!-- 다음에 추가할 부분 "-->

   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="./img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>자 유 게 시 판</b></font>
     <font size="2"> - 수정하기</font><p>
     <img src="./img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="./img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form method="post" name="board" >

      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="./img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" name="name" value="<%=vo.getName() %>" readonly></td>
       </tr>
       <tr>
         <td align="right">&nbsp;</td>
         <td ><font size="2 face="돋움"">메일주소</font></td>
         <td>
          <input type="text" size="20" name="email" value="<%=vo.getEmail()%>"></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제 목</font></td>
         <td><input type="text" size="60" name="subject" value="<%=vo.getSubject()%>"></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">글내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"><%=vo.getContents() %></textarea></td>
       </tr>
       <tr>
         <td align="right"><img src="./img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" >
		  <font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
        </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td><a href="javascript:send()"><img src="./img/edit2.gif" border=0></a>&nbsp;
          <a href="board_list.jsp"><img src="./img/cancle.gif" border=0></a></td></tr>
      </table>
      </form>
    </td></tr>
  </table>
  </body>
  </html>
