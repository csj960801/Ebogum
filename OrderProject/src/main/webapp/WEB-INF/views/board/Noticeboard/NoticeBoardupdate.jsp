<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${boardupdate > 0}">
	<script type="text/javascript">
		alert("공지게시글 수정완료!");
		window.location.href = "/board/Noticeboard/NoticeBoard.board";
	</script>
</c:if>
