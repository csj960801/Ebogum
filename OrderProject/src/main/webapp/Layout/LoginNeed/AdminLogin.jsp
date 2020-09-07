<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.login != 'logos'}">
	<script type="text/javascript">
		alert("관리자전용페이지입니다!");
		window.location.href = "/";
	</script>
</c:if>