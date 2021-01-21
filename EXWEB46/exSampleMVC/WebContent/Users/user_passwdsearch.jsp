<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
<HEAD>
<TITLE>사용자의 아이디를 검색</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<script>
	function pass_search(){
		if(passSearch.userid.value==""){
			alert("아이디 입력");
			passSearch.userid.focus();
			return false;
		}
		if(passSearch.email.value==""){
			alert("아이디 입력");
			passSearch.email.focus();
			return false;
		}
		passSearch.submit();
	}
	
	function win_close(){
		self.close();
	}
</script>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="Users/img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>아이디 찾기</FONT></td>
    <td align=right><img src="Users/img/u_b03.gif"></td>
  </tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
    <c:if test="${!empty passwd and row==1}">      
         새로 발급된 비밀번호는 <br><FONT FACE="굴림"><B> </B></FONT><br>
         <BR><FONT COLOR="#483cae"><b>${passwd}</b></FONT>입니다.
    </c:if>
    <c:if test="${empty passwd and empty row}">     
         <br><font face="굴림"><b>아이디와 이메일을 입력해주세요.</b></font><br>
    </c:if>	
    <c:if test="${row==0}">     
         <br><font face="굴림"><b>아이디 또는 이메일이 존재하지 않습니다.</b></font><br>
    </c:if>	
    <c:if test="${empty passwd}">   
    <form name="passSearch" method="post" action="User?cmd=user_passwdsearch_ok" onsubmit="return false;">
           아 이 디<INPUT NAME=userid type=text size=16 maxlength=16><br>
           이 메 일<INPUT NAME=email type=text size=16 maxlength=16><br>
      	   <input type=image src="Users/img/u_bt08.gif" border=0 vspace=0 onClick="pass_search()">
	</form>
	</c:if>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="Users/img/u_b04.gif"></td>
    <td align=right><img src="Users/img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=3 align=center>
      <a href="" onClick="win_close()">
      	<img src="Users/img/u_bt13.gif" border=0 vspace=5>
      </a>
    </td>
  </tr>
</table>
</BODY>
</HTML>