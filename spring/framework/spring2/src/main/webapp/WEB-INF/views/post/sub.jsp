<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

</head>
<body>
	<c:forEach items="${postList}" var="post">
		<div class="form-control input-group mt-3 mb-3" style="min-height: auto; height: auto">
			<c:choose>
				<c:when test="${post.po_fi_name ne null}">
					<img width="100" height="120" src="<c:url value="/download${post.po_fi_name}"/>">
				</c:when>
				<c:otherwise>
					<img width="100" height="120" src="<c:url value="/resources/icon.png"/>">
				</c:otherwise>
			</c:choose>
			
			<div class="ml-3">
				<div>${post.po_title}</div>
				<div>작성자 : ${post.po_me_id}</div>
				<div><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${post.po_date}"/> </div>
				<div>조회수 : ${post.po_view}</div>
				<div>추천수 : ${post.po_up}/${post.po_down}</div>
			</div>
			<hr>	
		</div>
	</c:forEach>
	<c:if test="${postList.size() eq 0}">
		<div class="form-control text-center mt-3 mb-3">등록된 게시글이 없습니다.</div>
	</c:if>
	
	<!-- 더보기 버튼을 추가 -->
	<c:if test="${pm.next}">
		<button class="btn btn-danger btn-more col-12">더보기</button>
	</c:if>
</body>
</html>
