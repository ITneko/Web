<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="exDay1224.model.* , java.util.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	GuestDAO dao = GuestDAO.getInstance();
	// 쿠키가 있는지 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		// 쿠키 검사
		for(int i=0; i<cookies.length; i++){
	info = cookies[i];
	if(info.getName().equals("boardCookie"+idx)){
		bool = true;
		break;
	}
		}
		
		String newValue = "" + System.currentTimeMillis();
		if(!bool){ // 쿠키가 존재하지 않으면
	// 쿠키생성
	info = new Cookie("boardCookie"+idx, newValue);
	info.setMaxAge(24*60*60); // 일(초)
	response.addCookie(info);
	dao.BoardReadCount(idx);
		}
		BoardVO vo = dao.BoardView(idx);
%>
<script>
	function del_(){
		var url = "board_delete.jsp?idx=<%=idx%>";
		window.open(url, "del , resizalbe=no, x=150, y=200");
	}

</script>

 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>게시판 내용 보기</title>
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

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">자 유 게 시 판</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">
                  <%=vo.getSubject() %></font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              <a class="list" href="mailto:ein1027@nate.com"><%=vo.getName() %></a> / <font size="2" face="돋움"><%=vo.getRegdate() %> / <%=vo.getReadcnt() %>번 읽음</font>
             <p>
             <%=vo.getContents() %><p><!--contents의 내용을 <BR>태그로 처리-->
           </td>
         </tr>
       </table>
  
      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 새글쓰기 -->
       <a href="board_write.jsp">
       <img src="./img/write.jpg" border="0"></a>&nbsp;&nbsp;
	   <!-- 수정하기 -->
       <a href="board_modify.jsp?idx=<%=vo.getIdx()%>">
       <img src="./img/edit.gif" border="0"></a>&nbsp;&nbsp;
         <!-- 삭제하기 -->
       <a href="javascript:del_()"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;
       <!-- 목록보기 -->
       <a href="board_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>
