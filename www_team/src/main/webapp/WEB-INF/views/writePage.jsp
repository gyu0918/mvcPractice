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

	<div>
		글번호 <a id="writeNum">${number}</a><br>
		
		제목 <input type="text" id="title" > <br>
		작성자 <div id="id"></div>
		내용 <input type="text" id="content"><br>
		작성일<div id="date"></div>
			<button onclick="savePost()" >저장</button>
	</div>
</body>
</html>

<script>
	let now = new Date();
	let formattedDate = now.toLocaleDateString();
	let formattedTime = now.toLocaleTimeString();

	let date = document.getElementById('date');
	date.innerHTML =formattedDate + " " + formattedTime;
	
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
		let postNum = document.getElementById('writeNum').innerText;
		let postName = title.value;
		let postContent = document.getElementById('content').value;
		let postCount = 0;
		let postLike = 0;
		let postDate = document.getElementById('date').innerText;
			
			
		if (postName.length > 20){
			alert("제목이 20글자 초과했습니다.");
			return ;
		}else if (postContent.length > 100){
			alert("내용이 100글자 초과했습니다.");
			return ;
		}
		
		
		
		axios.post('savePost',{
			id : postId,
			postNum : postNum,
			postName : postName,
			postContent : postContent,
			postCount : postCount,
			postLike : postLike,
			postDate : postDate
			
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