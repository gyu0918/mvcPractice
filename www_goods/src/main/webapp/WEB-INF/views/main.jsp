<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴먼 기업 입사시험 테스트</title>
</head>

<!-- axios 추가 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<body>
	<h2>상품 등록 기능</h2>
	<form action="insert" method="post">
	이름 <input type="text" name="goodsname"> 가격 <input type="text" name="goodsprice"> 수량 <input type="text" name="goodscnt"> 설명 <input type="text" name="goodscomment">
	 <input type="submit" id="saveGoods"  value="상품등록하기">
	 </form>
	<h2>상품 조회 기능</h2>
	상품 이름<input type="text" id="name"> <input type="button" onclick="join()" value="조회하기">
	<div id="showGoods"></div>
	
	<section></section>
</body>
</html>
<script>
	function join(){
		
		let name = document.getElementById('name').value;

		axios.get('searchname',{
			params: {goodsname : name}
		})
		.then(function(response){
			let showGoods = document.getElementById('showGoods')
			let data = response.data;
			
			showGoods.innerHTML='';
			
			if (data == ""){
				showGoods.innerHTML = "상품이 없습니다.<br><hr>";
			}else{
				showGoods.innerHTML = "상품이름 : "  + data.goodsname  + "<br>"+ " 가격 : " + data.goodsprice + "<br>" + " 수량 : " 
				+ data.goodscnt + "<br>" + " 설명 : "  + data.goodscomment + "<hr>";         
			}
			
			
		})
		.catch(function(error){
			
		});
		
		
		//리스트에 넣고 조회한 리스트 뽑아 오기 
		axios.get('joinList', {
			params: {joinContent : name}
		
		})
		.then(function(response){
			
			let joinLists = response.data;
			let resultHtml = "<h3>조회한리스트</h3><br>"
			
			joinLists.forEach(data => {
					resultHtml += data + "<br>";
			
			});
			
			document.querySelector("section").innerHTML = resultHtml;
			
		})
		.catch(function(error){
			
		});
	}



</script>