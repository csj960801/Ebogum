<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${jujebyolinsert > 0}">
	<script>
		alert("설교데이터 저장 되었습니다.");
		window.location.href = "/sermon/Dawn/Jujebyol/JujebyolSermon.sermon";
	</script>
</c:if>