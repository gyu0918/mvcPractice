<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<body>
<%@ include file="../common/top.jsp" %>
<h3>회원가입</h3>

<form action="memberjoind" method="post">
<table border=1>
	<tr>
		<td> 아이디 </td>
		<td><input type="text" name="id" id="userid"><span id="duplexid">중복체크</span></td>
	</tr>
	
	
	
	<tr>
		<td> 비밀번호 </td>
		<td><input type="password" name="pass"></td>
	</tr>
	<tr>
		<td> 이름 </td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td> 주소 </td>
		<td><input type="text" name="addr"></td>
	</tr>
	<tr>
		<td> 전화번호 </td>
		<td><input type="text" name="tel"></td>
	</tr>
	<tr>
		<td colspan=2> </td>
		<td><input type="submit" value="가입"></td>
	
	</tr>
</table>
</form>

</body>
</html>

<script>
	
	
	
	
	//axios 사용 버전
	document.getElementById("duplexid").addEventListener("click", function(){
		let uid = document.getElementById("userid").value;
		
		axios.get('duplexid', {
			params: {id: uid}     //get 요청일떄 post요청일떄는 data: 로 표시 
		})
		.then(function(response){
			let data = response.data;
			alert(data + " 서버로 부터 받음");
			
			if (data != ''){
				alert("사용 가능");
				document.getElementById("userid").textContent = data + '사용 가능 아이디';
			
			}else {
				alert("중복된 아이디 입니다.");
				document.getElementById("userid").value = '';
				document.getElementById("userid").focus();
			}
		})
		.catch(function(error){
			alert("통신 오류");
			console.error(error);
		});	
	});
	
	
	</script>
	