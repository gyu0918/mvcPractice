<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>



<body>

	<%@ include file="./common/top.jsp" %>
	<h3>회원가입</h3>
	<h3> 메인화면 </h3>
	<br>
	<div>
		id <input type="text" id="userId" >
		pass <input type="text" id="userPass">
			<input type="button" id="login">
	</div>

</body>
</html>
<script>

	document.getElementById('login').addEventListener("click", function() {
		let uid = document.getElementById("userId").value;
		let password = document.getElementById("userPass").value;
		alert("dddd");
		axios.post('login' , {
		
				id : uid,
				pass : password
			
		})
		.then(function(response){
			let data = response.data;
			alert(data + " <= 서버로 부터 받음")
		})
		.catch(function(error){
			console.error(error);
		});
	});
	


</script>

