<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン認証</title>
</head>
<body>
	<hr>
	<center>
	<h1>ログイン認証</h1>
	</center>
	<hr>
	<form method="post" action="<%= request.getContextPath() %>/Login">
		<table border="1" align="center">
			<tr>
			<th align="right" bgcolor="LightCyan">ユーザー名：</th>
			<td>
			<input type="text" name="username" size="20" />
			</td>
		</tr>
		<tr>
			<th align="right" bgcolor="LightCyan">パスワード</th>
			<td>
			<input type="password" name="password" size="15" />
			</td>
		</tr>
		<tr>
		<td colspan="2" align="center"> 
		<input type="submit" name="submit" value="ログイン">
		</td>
		</tr> 
		</table>
		<br>
		<center>
		<a href="<%= request.getContextPath() %>/jsp/RegistryForm.jsp">新規ユーザー登録</a>
		</center>
	</form>
</body>
</html>