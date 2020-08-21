<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.login == null}">
	<script type="text/javascript">
		alert("회원전용페이지입니다! 로그인을 해주세요");
		window.location.href = "/";
	</script>
</c:if>