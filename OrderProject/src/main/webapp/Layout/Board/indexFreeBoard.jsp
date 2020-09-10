<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!-- 메인에 출력되는 자유게시판  -->
<%
	String url = "";
	String user = "";
	String password = "";

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		psmt = conn.prepareStatement("select * from freeboard where FreeBoardCnt is not null");
		rs = psmt.executeQuery();
%>
<dl class="freeboard_dl">
	<dt class="freeboard_dt">자유게시판</dt>
	<dd class="freeboard_dd">
		<div class="freeboard_wrapper">
			<%
				while (rs.next()) {
			%>
			<a href="#" onclick="javascript:freeboard_Read('<%=rs.getString("FreeboardCnt")%>', '<%=rs.getString("writer")%>' , '<%=rs.getString("title")%>' , 2020-08-03 ,'<%=rs.getString("content")%>','<%=rs.getString("hit")%>','<%=rs.getString("boardParam")%>','<%=rs.getString("boarddate")%>')"
				id="freeboard_a"><%=rs.getString("title")%></a><br>
			<%
				}
				} catch (Exception err) {

				} finally {
					try {
						if (conn != null) {
							conn.isClosed();
						}
						if (psmt != null) {
							psmt.isClosed();
						}
						if (rs != null) {
							rs.isClosed();
						}
					} catch (Exception err2) {

					}
				}
			%>
		</div>
	</dd>

</dl>