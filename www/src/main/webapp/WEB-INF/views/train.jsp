<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>train</title>
</head>

<body>

	<table>
	<tr>
		<td>
		</td>
		<td>
			<form action="alltrain" method="post" >
				<input type="submit" name="trainallbutton" value="모든 열차보기"  >
			</form>
		</td>
		<td>
			<form action="word" method="post">
				<input type="text" name="wordtext">
				<input type="submit" value="검색">
			</form>
		</td>
		<td>
			<form action="search" method="post">
				<input type="submit" name="day" value="검색">
			
			</form>
		</td>
		<td>
			<form action="search" method="post">
				<input type="submit" name="day" value="탑다운 위치">
			
			</form>
		</td>
		<td>
			
		</td>
		
	</tr>
	</table>
	<table>
	<tr>
		<td>지역</td>
		<td>서울</td>
		<td>대전</td>
		<td>부산</td>
		<td>천안</td>
		<td>대구</td>
		
	</tr>
	<tr>
		<td>기차 종류</td>
		<td>${a1}</td>
		<td>${a2}</td>
		<td>${a3}</td>
		<td>${a4}</td>
		<td>${a5}</td>
		
	</tr>
	<tr>
		<td>출발 시간</td>
		<td>${b1}</td>
		<td>${b2}</td>
		<td>${b3}</td>
		<td>${b4}</td>
		<td>${b5}</td>	
	</tr>
	<tr>
		<td>도착 시간</td>
		<td>${c1}</td>
		<td>${c2}</td>
		<td>${c3}</td>
		<td>${c4}</td>
		<td>${c5}</td>	
	</tr>
	
	</table>
	
	

		
	<p>--------------------------------------------------------------------------------</p>
	<form action="search" method="post" >
		<input type="submit" name="lotto" value="로또번호 가져오기"  >
	</form>
	<p> ${Lo1}  ${Lo2}  ${Lo3}  ${Lo4}  ${Lo5}  ${Lo6} </p>
	
	<p>--------------------------------------------------------------------------------</p>
	<form action="word" method="post">
		<input type="text" name="wordtext">
		<input type="submit" value="검색">
	</form>
	<p>단어뜻 = ${result}</p>

</body>
</html>
