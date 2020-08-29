<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${memberDel}">
	<script type="text/javascript">
		alert("해당 회원 삭제완료되었습니다.");
		history.go(-2);
	</script>
</c:if>
