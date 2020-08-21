<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${Answerboardreply > 0}">
	<script type="text/javascript">
		alert("해당 글에 답변완료!");
		window.location.href = "/";
	</script>
</c:if>
<c:if test="${Answerboardreply <= 0}">
	<script type="text/javascript">
		alert("해당 글에 답변실패!");
		history.back();
	</script>
</c:if>