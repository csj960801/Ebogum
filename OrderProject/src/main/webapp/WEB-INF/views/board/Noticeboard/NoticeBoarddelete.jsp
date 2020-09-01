<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${boarddel > 0}">
	<script type="text/javascript">
		alert("게시글 삭제완료!");
		window.location.href = "/board//Noticeboard/NoticeBoard.board";
	</script>
</c:if>