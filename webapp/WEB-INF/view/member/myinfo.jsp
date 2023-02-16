<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내정보보기</h1>
<h1>EL request attribute</h1>
	<c:if test="${empty myinfo}">
	<div>
		<h4>로그인 되지 않았다</h4>
		<a href="<%=request.getContextPath()%>/login">로그인페이지로이동</a>
	</div>
	</c:if>
	<c:if test="${not empty myinfo}">
			id: ${myinfo.id}
			<br>
			name:${myinfo.name}
			<br>
			email:${myinfo.email}
	</c:if>

<hr>

<%-- 			id: ${lgnss.id} --%>
<!-- 			<br> -->
<%-- 			name:${lgnss.name} --%>
<!-- 			<br> -->
<%-- 			email:${lgnss.email} --%>


<%-- <%	 --%>
<!--  	 MemberVo ss=(MemberVo)session.getAttribute("lgnss"); -->
<%-- %> --%>
<%-- <%=ss.getId()%> --%>

<%
	Object obj=request.getAttribute("myinfo"); //el 태그 쓰면 membervo로 형변환 해줄 필요 없이 그냥 바로 가능id: ${myinfo.id}이렇게
	MemberVo vo=null;
	if(obj==null){
		//로그아웃상태
%>		
	<h4>로그인 되지 않았다. 정보 없다</h4>
	<a href="<%=request.getContextPath()%>/login">로그인페이지로이동</a>
<%
	}else{
		if(obj instanceof MemberVo){
				vo=(MemberVo)obj;
		}
		if(vo==null){
		//로그아웃
%>
		<h4>로그인 되지 않았다. 정보 없다</h4>
		<a href="<%=request.getContextPath()%>/login">로그인페이지로이동</a>
<%
		}else{//로그인 하지 않은 상태에서 아래에서 getid 하면 nullpointer예외 뜸
%>
			
			id: <%=vo.getId()%>
			<br>
			name:<%=vo.getName()%>
			<br>
			
<%		
		}
	}
%>
</body>
</html>