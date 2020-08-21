<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${AnswerboardUpdate > 0}">
	<script type="text/javascript">
		alert("게시글 수정완료!");
		window.location.href = "/";
	</script>
</c:if>
<c:choose>
	<c:when test="${AnswerboardUpdate <= 0}">
		<script type="text/javascript">
			alert("입력된 암호가 존재하지않습니다.");
			history.back();
		</script>
	</c:when>
</c:choose>