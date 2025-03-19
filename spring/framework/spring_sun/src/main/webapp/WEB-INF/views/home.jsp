<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Hello World</h1>
<c:if test="${user != null}">
	<h1>${user.me_id}님 반갑습니다.</h1>
</c:if>  	

</body>
</html>
