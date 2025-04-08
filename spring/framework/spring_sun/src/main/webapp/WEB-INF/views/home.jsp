<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<style>
		.box {
			border: 1px solid #ccc;
			padding: 10px;
			margin: 10px;
		}
	</style>
</head>
<body>
<h1>Hello World</h1>
<c:if test="${user != null}">
	<h1>${user.me_id}님 반갑습니다.</h1>
</c:if>  	
<div id="box" class="box"></div> 
<script type="text/javascript">
	let box = document.querySelector("#box");
	let str = '';
	fetch("http://ddragon.leagueoflegends.com/cdn/13.1.1/data/ko_KR/champion.json")
	.then(res=>res.json())
	.then(res=>{
		let champions = res.data;
		for(let name in champions){
			let champion = champions[name];
			str += `
				<dl>
					<dd>\${champion.name}</dd>
					<dt>\${champion.title}</dt>
				</dl>
			`
		}
		box.innerHTML = str;
	})
</script>
</body>
</html>
