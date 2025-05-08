<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>

<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>



<body>

	<div>
		
		제목 <input type="text" id="title" > <br>
		작성자 <div id="id"></div>
		내용 <input type="text" id="content"><br>

		<label>첨부파일:
  			<input type="file" id="files" name="file" multiple>
		</label>
		<button onclick="savePost()" >저장</button>
	</div>
</body>
</html>

<script>
	
	
	//아이디 넣기
	let id = sessionStorage.getItem('loginId');
	let tempId = document.getElementById('id');
	tempId.innerHTML = id;
	
	function savePost(){
		var title = document.getElementById('title');
		
		if (title.value == ''){
			alert("제목을 적어주세요.");
			return ;
		}
		
		//데이터 베이스에 저장하기 json + axios사용해서 	
			
		let postId = sessionStorage.getItem('loginId');
		let postName = title.value;
		let postContent = document.getElementById('content').value;
		let postCount = 0;
		let postLike = 0;
		let postDate = 0;
		let files = document.getElementById("files").files;
			
			
		if (postName.length > 20){
			alert("제목이 20글자 초과했습니다.");
			return ;
		}else if (postContent.length > 100){
			alert("내용이 100글자 초과했습니다.");
			return ;
		}
		
		
		let formData = new FormData();
		formData.append("id", postId);
		formData.append("postName", postName);
		formData.append("postContent", postContent);
		formData.append("postCount", postCount);
		formData.append("postLike", postLike);
		formData.append("postDate", postDate);
	
		// 여러 파일을 같은 key("file")로 추가
		for (let i = 0; i < files.length; i++) {
			formData.append("file", files[i]);
		}
		alert(files.length);
		axios.post('savePost', formData, {
			headers: {
				'Content-Type': 'multipart/form-data'
			}
		})
		.then(function(response){
			if (response.data === 'success'){
				window.location.href = "${pageContext.request.contextPath}/gallery";
			}
		})
		.catch(function(error){
			console.error(error);
		});
		
		
	}
	



</script>