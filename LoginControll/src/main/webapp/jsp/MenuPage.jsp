<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvc.LoginBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニューページ</title>
</head>
<body>
	<hr>
	<center>
	<h1>メニューページ</h1>
	</center>
	<hr>
	<%
		LoginBeans userInfo = (LoginBeans) request.getAttribute("user_info");
		if(userInfo != null) {
	%>
		<center>
		<p>ようこそ、<strong><%= userInfo.getUsername() %></strong>さん</p>
		<p>ログインに成功しました！</p>
		<br>
		<a href="<%= request.getContextPath() %>/Login">ログアウト</a>
		</center>
	<%
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	%>
</body>
</html>

