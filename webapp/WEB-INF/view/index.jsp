<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20230214 myWeb home</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<h1>서버프로그램 구현</h1>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	
	<script>
// 		$(".btn.login").on("click", function(){  // btn의 후손인 login/ find보다 셀렉터가 속도가 더 빠르니 이렇게
// 			console.log("btnLogin 클릭");
// 		});
// 		$(".btn.logout").on("click", function(){
			
// 		});
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		function handlerClickBtnLogin(){
			console.log("btnLogin 클릭");
			//location.href="login";// index위치에서 상대경로
			location.href="<%=request.getContextPath()%>/login";
		}
		function handlerClickBtnLogout(){
			console.log("btnLogout 클릭");
		}
	</script>
</body>
</html>