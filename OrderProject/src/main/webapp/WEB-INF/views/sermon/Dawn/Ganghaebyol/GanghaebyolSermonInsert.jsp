<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${ganghaebyolinsert > 0}">
	<script>
		alert("설교데이터 저장 되었습니다.");
		window.location.href = "/sermon/Dawn/Ganghaebyol/GanghaebyolSermon.sermon";
	</script>
</c:if>