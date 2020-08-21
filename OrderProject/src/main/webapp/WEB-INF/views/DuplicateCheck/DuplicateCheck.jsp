<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
</head>
<body>
	<div class="idcheck_wrapper">
		<c:if test="${duplicateCheck}">
			<p class="notice_p">현재 사용중인 아이디입니다.</p>
			<a href="javascript:self.close();">[닫기]</a>
		</c:if>
		<c:if test="${!duplicateCheck}">
			<p class="notice_p">사용가능한 아이디입니다.</p>
			<a href="javascript:self.close();">[닫기]</a>
		</c:if>
	</div>
</body>
</html>