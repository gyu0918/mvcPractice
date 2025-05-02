<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<style>
  table.post-table {
    width: 100%;
    border-collapse: collapse;
    text-align: center;
    margin-top: 20px;
  }

  table.post-table th, table.post-table td {
    padding: 12px;
    border: 1px solid #aaa;
  }

  table.post-table th {
    background-color: #f8f8f8;
  }

  section {
    padding: 10px;
  }
</style>
</head>

<body>
	<h2><a href="${pageContext.request.contextPath}/writePost">글쓰기</a></h2>
	<hr>
	<section></section>
	
	

	<script>
		loadPost();

		function loadPost() {
			axios.get('loadPost')
			.then(function(response) {
				const posts = response.data;
				console.log(posts); // 확인용

				let resultHtml = "<h3>게시글</h3><table class='post-table'>";
				resultHtml += "<tr><th>글 번호</th><th>글 제목</th><th>작성일</th><th>작성자</th><th>조회수</th><th>좋아요</th></tr>";

				posts.forEach(data => {
					resultHtml += "<tr><td>" + data.postNum + "</td><td>" +
					"<a href='" + "${pageContext.request.contextPath}/goPost?postNum=" + data.postNum + "'>" +
					data.postName + "</a></td><td>" +
					data.postDate  + "</td><td>" +
					data.id + "</td><td>" +
					data.postCount + "</td><td>" +
					data.postLike + "</td></tr>";
				});

				resultHtml += "</table>";
				document.querySelector("section").innerHTML = resultHtml;
			})
			.catch(function(error) {
				console.error("에러 발생:", error);
			});
		}
	</script>
</body>
</html>
