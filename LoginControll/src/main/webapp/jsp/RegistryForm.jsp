<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<hr>
<center>ユーザー登録</center>
<hr>
<form method="post" action="<%= request.getContextPath() %>/Login">
	<table border="1" align="center">
		<tr>
		<th align="right" bgcolor="DeepSkyBlue">ユーザー名:</th>
		<td>
		<input type="text" name="newuser" size="20" maxlength="20" />
		</td>
		</tr>
		<tr>
		<th align="right" bgcolor="DeepSkyBlue">パスワード：</th>
		<td>
			<input type="password" name="newpass" size="15" maxlength="20" />
		</td>
		</tr>
	<tr>
	<td colspan="2" align="center">
		<input type="submit" name="submit" value="登録" />
	</td>
	</tr>
	</table>
	<br>
	<center>
	<a href="<%= request.getContextPath() %>/Login">ログイン画面に戻る</a>
	</center>
</form>
</body>
</html>