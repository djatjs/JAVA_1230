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
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<h1>Hello World</h1>
<c:if test="${user != null}">
    <h1>${user.me_id}님 반갑습니다.</h1>
</c:if>  

<!-- 유닛 리스트 출력 -->
<div class="box">
    <h2>유닛 정보</h2>
    <c:forEach var="unit" items="${unitList}">
        <dl>
            <dt><strong>이름:</strong> ${unit.name}</dt>
            <img src="${unit.icon}" alt="${unit.name} 이미지">
            <dd><strong>특성:</strong> <c:forEach var="trait" items="${unit.traits}">${trait} </c:forEach></dd>
            <dd><strong>코스트: ${unit.cost}</strong></dd>
        </dl>
    </c:forEach>
</div>

</body>
</html>
