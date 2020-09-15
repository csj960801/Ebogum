<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${hunshindel > 0}">
	<script>
		alert("설교데이터 삭제 되었습니다.");
		window.location.href = "/sermon/Hunshin/HunshinSermon.sermon";
	</script>
</c:if>