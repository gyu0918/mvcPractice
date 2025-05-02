<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>create</title>
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
			<form action="trainword" method="post">
				<input type="text" name="wordtext">
				<input type="submit" value="검색">
			</form>
		</td>
		<td>
			<form action="search" method="post">
				<input type="checkbox" name="1" value="서울">서울
			
				<input type="checkbox" name="1" value="대전">대전
				
				<input type="checkbox" name="1" value="부산">부산
			
				<input type="checkbox" name="1" value="천안">처안
				
				<input type="checkbox" name="1" value="대구">대구
			
				<input type="submit" name="day" value="선택검색">
			</form>
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
	

</body>
</html>

