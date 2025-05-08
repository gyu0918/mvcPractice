<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>

<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>



<body>
	ID <input type="text" id="id"> <input type="button" value="중복체크" id="idCheck" onclick="idCheck()"> <br>
	pass<input type="text" id="pass"><br>
	<tr>
		<td>첨부파일</td>
		<td><input type="file" id="files" name="file"></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td><input type="file" id="files" name="file"></td>
	</tr>
	<input type="button" id="registration" value="등록" onclick="regi()">
</body>
</html>
<script>
	var check = false;
	
	function idCheck(){
		let uid = document.getElementById("id").value;
		
		axios.get('check', {
			params: {id: uid}     //get 요청일떄 post요청일떄는 data: 로 표시 
		})
		.then(function(response){
			let data = response.data;
			
			if (data != ''){
				alert("중복된 아이디 입니다.");
				document.getElementById("id").value = '';
				document.getElementById("id").focus();
				check = false; 
			}else {
				alert("사용 가능");
				check = true;
			}
		})
		.catch(function(error){
			alert("통신 오류");
			console.error(error);
		});	
			
		
		
	} 

	function regi(){
		//db로 보내고 chek 값이 ture 일떄만 넘어가도록 하기 
		
		
		
		
		if (check){
			let uid = document.getElementById("id").value;
			let pass = document.getElementById("pass").value;
			
			let files = document.getElementById("files").files;

			let formData = new FormData();
			formData.append("id", uid);
			formData.append("pass", pass);
			// 여러 파일을 같은 key("file")로 추가
			for (let i = 0; i < files.length; i++) {
				formData.append("file", files[i]);
			}
			
			axios.post('save', formData, {
				headers: {
					'Content-Type': 'multipart/form-data'
				}
			})
			.then(function(response) {
				console.log("dddddd");
				window.location.href = "${pageContext.request.contextPath}/";
			})
			.catch(function(error){
				console.error(error);
			});
			
		}else{
			alert("중복체크를 하세요!!");
		}
	}



</script>