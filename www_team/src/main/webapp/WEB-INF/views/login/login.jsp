<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
	
<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<body>
	ID <input type="text" id="id"> <br>
	pass<input type="text" id="pass"><br>
	<input type="button" id="saveId" onclick="saveId()" value="회원가입">	
	<input type="button" id="login" onclick="login()" value="로그인">	
</body>
</html>
<script>
	function saveId(){
		window.location.href = "${pageContext.request.contextPath}/saveId";
	}
	
	function login(){
		
		let memId = document.getElementById('id').value;
		let pass = document.getElementById('pass').value;		
		
		axios.post('loginCheck', {
			id: memId,
			pass : pass     //get 요청일떄 post요청일떄는 data: 로 표시 
		})
		.then(function(response){
			let data = response.data;
			
			if (data != ''){
				sessionStorage.setItem('loginId', memId);
				window.location.href = "${pageContext.request.contextPath}/gallery";
			
			}else {
				alert("아이디나 비밀번호가 틀렸습니다. 다시 적어주세요");
				document.getElementById('id').value='';
				document.getElementById('pass').value='';
			}
		})
		.catch(function(error){
			alert("통신 오류");
			console.error(error);
		});	
	
	}





</script>