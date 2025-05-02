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
		<select id="open">
			<option value="true">공개</option>
			<option value="false">비공개</option>
		</select><br>
		제목 <input type="text" id="title" > <br>
		작성자 <input type="text" id="writer"><br>
		내용 <input type="text" id="content"><br>
		작성일<div id="date"></div>
		조회수<a id="views">${joinCount}</a><br>
			<button onclick="save()" >저장</button>
	</div>
</body>
</html>

<script>
	let now = new Date();
	let formattedDate = now.toLocaleDateString();
	let formattedTime = now.toLocaleTimeString();

	let date = document.getElementById('date');
	date.innerHTML =formattedDate + " " + formattedTime;
	
	function save(){
		var title = document.getElementById('title');
		var writer = document.getElementById('writer');
		
		if (title.value == ''){
			alert("제목을 적어주세요.");
			return ;
		}else if (writer.value == ''){
			alert("작성자를 적어주세요.")
			return ;
		}
		
		//데이터 베이스에 저장하기 json + axios사용해서 	
			
		let num = document.getElementById('writeNum').innerText;
		let secret = document.getElementById('open').value;
		let titleName = title.value;
		let writerName = writer.value;
		let content = document.getElementById('content').value;
		let createDate = document.getElementById('date').innerText;
		let joinNum = document.getElementById('views').innerText;
		
		
		if (titleName.length > 20){
			alert("제목이 20글자 초과했습니다.");
			return ;
		}else if (writerName.length > 10){
			alert("작성자가  10글자 초과했습니다.");
			return ;
		}else if (content.length > 100){
			alert("내용이 100글자 초과했습니다.");
			return ;
		}
		
		
		
		axios.post('save',{
			num : num,
			secret : secret,
			title : titleName,
			writer : writerName,
			content : content,
			createDate : createDate,
			joinNum : joinNum
			
		})
		.catch(function(error){
			console.error(error);
		});
		
		
	}
	



</script>