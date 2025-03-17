<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>전송 확인</h1>
    <p> 객체 : ${person}</p>
    <p> 이름 : ${person.name}</p>
    <p> 나이 : ${person.age}</p>
    <!-- getter 메서드 호출 대신 필드에 직접 접근 -->
    <p>${person.name}의 나이 : ${person.age}</p>
    <p>${person.getName()}의 나이 : ${person.getAge()}</p>
</body>
</html>
