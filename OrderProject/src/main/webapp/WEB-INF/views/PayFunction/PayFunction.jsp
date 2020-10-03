<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${payinsert}">
	<script type="text/javascript">
		alert("접수되었습니다.\n ${saveUnpay} 계좌로 입금해주시기바랍니다. \n 다시 로그인 해주세요.");
		window.location.href="/logout.app";
	</script>
</c:if>