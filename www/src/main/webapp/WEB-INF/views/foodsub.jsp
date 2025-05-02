<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>

<body>

	<table>
	<tr>
		<td>
		</td>
		<td>
			<form action="allMenu" method="get" >
				<input type="submit" name="allMenuBtn" value="모든 메뉴정보보기"  >
			</form>
		</td>
		<td>
			<form action="search" method="post">
				<input type="text" name="wordtext">
				<input type="submit" value="검색">
			</form>
		</td>
		<td>
			<form action="delete" method="get">
				삭제할 메뉴 이름 입력하세요<input type="text" name="deleteText">
			
				<input type="submit" name="deleteBtn" value="삭제">
			</form>
		</td>
		
	</tr>
	</table>
	
	<br>
	
	<br>
	<form action="create" method="get">
			메뉴이름<br><input type="text" name="createText"> <br>
			가격<br><input type="text" name="createText"><br>
			주요맛집위치<br><input type="text" name="createText"><br>
			원산지<br><input type="text" name="createText"><br>
			<input type="submit" value="메뉴등록">
	</form>
	<br>
	<form action="update" method="get">
			메뉴 이름 기준 수정가능합니다.<br>메뉴이름<br><input type="text" name="updateText"> <br>
			가격<br><input type="text" name="updateText"><br>
			주요맛집위치<br><input type="text" name="updateText"><br>
			원산지<br><input type="text" name="updateText"><br>
			<input type="submit" value="정보수정">
	</form>
	
	
	
	<br>
	<section>
		<hr>
		<h3>검색 결과</h3>
		<c:forEach var="food_dto" items="${food_list}">
		 	메뉴           : ${food_dto.name } <br>
		       가격           : ${food_dto.price } <br>
		       주요맛집위치 : ${food_dto.location } <br>
		       원산지         : ${food_dto.contry } <br>    	
		    <hr>	
		</c:forEach>         
	
	</section>
	

</body>
</html>

