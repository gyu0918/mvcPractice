<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form action="register" method="post" >
				<input type="submit" name="day" value="월요일"  >
			
			</form>
		</td>
		<td>
			<form action="register" method="post">
				<input type="submit" name="day" value="화요일">
			
			</form>
		</td>
		<td>
			<form action="register" method="post">
				<input type="submit" name="day" value="수요일">
			
			</form>
		</td>
		<td>
			<form action="register" method="post">
				<input type="submit" name="day" value="목요일">
			
			</form>
		</td>
		<td>
			<form action="register" method="post">
				<input type="submit"  name="day" value="금요일">
			
			</form>
		</td>
		
	</tr>
	<tr>
		<td>밥</td>
		<td> ${temp.getStr()}</td>
		<td>${b1}</td>
		<td>${c1}</td>
		<td>${d1}</td>
		<td>${f1}</td>
	</tr>
	<tr>
		<td>극</td>
		<td>${a2}</td>
		<td>${b2}</td>
		<td>${c2}</td>
		<td>${d2}</td>
		<td>${f2}</td>
	</tr>
	<tr>
		<td>요리</td>
		<td>${a3}</td>
		<td>${b3}</td>
		<td>${c3}</td>
		<td>${d3}</td>
		<td>${f3}</td>
	</tr>
	
	

	
	
	</table>
	
	

		
	<p>--------------------------------------------------------------------------------</p>
	<form action="Lotto" method="post" >
		<input type="submit" name="lotto" value="로또번호 가져오기"  >
	</form>
	<p> ${Lo1}  ${Lo2}  ${Lo3}  ${Lo4}  ${Lo5}  ${Lo6} </p>
	
	<p>--------------------------------------------------------------------------------</p>
	<form action="word" method="post">
		<input type="text" name="wordtext">
		<input type="submit" value="검색">
	</form>
	<p>단어뜻 = ${result}</p>
	<p>--------------------------------------------------------------------------------</p>
	
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
<script>
	function goSearch(){
		let sword = document.getElementById('searchWord').value
		let url = "/hom/find?word="+sword;
		location.href="/hom/find?word="+sword
	}
</script>
