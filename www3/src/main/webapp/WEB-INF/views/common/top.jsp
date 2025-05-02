<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	ul li {
		display: inlne-block;
		width: 100px;
	}
</style>


<body>

	<header><h3> 휴먼 홈페이지 </h3></header>

	<nav>
		<ul>
			<li>공부방</li>
			<li>자유게시판</li>
			<li>Q&A</li>
			<li><a href="${pageContext.request.contextPath}/memberjoin"> 회원가입</a></li>
			<li><a href="${pageContext.request.contextPath}/writePage">글쓰기</a></li>
		</ul>
	</nav>
	<hr>

</body>
</html>