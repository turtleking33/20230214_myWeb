<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section>
	<h1>게시글 목록</h1>
	${boardlist}
	<c:forEach items="${boardlist }" var="vo">
		${vo.boardNum }<br>
		
	</c:forEach>
	<hr>
</section>

