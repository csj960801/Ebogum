<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${loginFlag}">
	<script>
		alert("로그인 성공");
	</script>
	<jsp:forward page="/" />
</c:if>
<c:choose>
	<c:when test="${!loginFlag}">
		<script>
			alert("로그인에 실패했습니다.");
			history.back();
		</script>
	</c:when>
</c:choose>