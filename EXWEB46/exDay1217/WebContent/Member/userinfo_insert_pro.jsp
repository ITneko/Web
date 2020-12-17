<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String[] fa = request.getParameterValues("fa");
	String str = fa[0];
	for(int i=1; i<fa.length; i++){
		str = str + "," + fa[i];
	}
	
%>

<jsp:useBean id="member" class="model.MemberBean">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>

이름 : <%=member.getName() %><br>
아이디 : <%=member.getUserid() %><br>
비번 : <%=member.getPasswd() %><br>
우편번호 : <%=member.getZip() %><br>
주소1 : <%=member.getAddr1() %><br>
주소2 : <%=member.getAddr2() %><br>
전화번호 : <%=member.getTel() %><br>
이메일 : <%=member.getEmail() %><br>
관심분야 : <%=str %><br>
직업 : <%=member.getJob() %><br>
자기소개 : <%=member.getIntro() %><br>