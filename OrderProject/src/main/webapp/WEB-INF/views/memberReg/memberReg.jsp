<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${regFlag > 0}">
	<script>
		alert("회원가입완료.");
		window.location.href = "/";
	</script>
</c:if>