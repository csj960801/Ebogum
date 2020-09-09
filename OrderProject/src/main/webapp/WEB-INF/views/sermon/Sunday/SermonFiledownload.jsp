<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${pointEffect > 0}">
	<script type="text/javascript">
		alert("다운로드 완료되었습니다.");
		window.location.href = "/sermon/Sunday/SundaySermon.sermon";
	</script>
</c:if>
<c:if test="${pointEffect <= 0}">
	<script type="text/javascript">
		alert("다운로드 실패했습니다.");
		window.location.href = "/sermon/Sunday/SundaySermon.sermon";
	</script>
</c:if>