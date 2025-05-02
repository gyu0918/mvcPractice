<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>

<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


<body>
	<h2>글번호</h2><div id="postNum">${postNum}</div>
	<h2>작성자</h2><div id="goId">${id}</div><br>
	<h2>글제목</h2>${postName}<br>
	<h2>글내용</h2>${postContent}<br>
	<h2>작성일</h2>${postDate}<br>
	<h2 >좋아요</h2><div id="like">${postLike}</div><br>
	<input type="button" id="pushLikeButton"  onclick="pushButton()" value="좋아요 버튼"><br>
	
	<h2>댓글</h2>
	<div id="ss"></div><br>
	
	<input type="text" id="commentContent">
	<input type="button" id="comment" onclick="saveComment()" value="댓글쓰기"><br>
	<input type="button" id="rePost" onclick="reButton()" value="게시글돌아가기">
	
</body>
</html>
<script>
	var check = false;
	var postNum = ${postNum};
	var commentId = document.getElementById('goId').innerText;
	
	upJoinCount();
	joinComment();
	
	//페이지 시작시 이전댓글 불러오기
	function joinComment(){
		//postNum 보내야지  post방식으로
		axios.get('joinComment',{
			params: {postNum : postNum}
		})
		.then(function(response) {
			const comments = response.data;
			const container = document.getElementById('ss');
			  container.innerHTML = ''; // 기존 댓글 내용 초기화

		        comments.forEach(function(comment) {
		            // 각 댓글을 div 형태로 구성
		            const commentDiv = document.createElement('div');
		            commentDiv.classList.add('comment');  // 댓글마다 클래스를 추가해 스타일링 가능

		            // 댓글 내용 작성 (백틱 없이 문자열 연결)
		            commentDiv.innerHTML = 
		                '<div class="comment-author"><strong>' + comment.id + '</strong></div>' +
		                '<div class="comment-content">' + comment.content + '</div>' +
		                '<div class="comment-date">' + comment.commentDate + '</div>' +
		                '<hr>';

		            // 댓글을 container에 추가
		            container.appendChild(commentDiv);
		        });
		
		})
		.catch(function(error){
			console.error(error);
		});
	}
	
	//댓글쓰기
	function saveComment(){
		const content = document.getElementById('commentContent').value;

		let now = new Date();
		let formattedDate = now.toLocaleDateString();
		let formattedTime = now.toLocaleTimeString();
		let date = formattedDate + " " + formattedTime;
		
		axios.post('saveComment',{
			postNum : postNum,
			id : commentId,
			content : content,
			commentDate : date		
		})
		.then(function(response){

			joinComment();
			document.getElementById('commentContent').value = '';
			
		})
		.catch(function(error){
			
		});
		
	}
	
	//조회수 자동으로 오르기
	function upJoinCount(){
		axios.get('upJoinCount',{
			params: {postNum : postNum}
		})
		.catch(function(error){
			
		});
		
	}
	
	function pushButton(){
		if (check){
			alert("좋아요는 한번만 누를수 있습니다. ");
			return ;
		}
		axios.get('upLike', {
			params: {postNum: postNum}     //get 요청일떄 post요청일떄는 data: 로 표시 
		})
		.then(function(response) {
			alert(response.data);
			let like = document.getElementById('like');
			like.innerText = response.data;
		})
		.catch(function(error) {
			console.error("에러 발생:", error);
		});
		check = true;	
	}

	function reButton(){
		window.location.href = "${pageContext.request.contextPath}/gallery";
	}



</script>