<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${specialupdate > 0}">
	<script>
		alert("설교데이터 수정 되었습니다.");
		window.location.href = "/sermon/Special/SpecialSermon.sermon";
	</script>
</c:if>