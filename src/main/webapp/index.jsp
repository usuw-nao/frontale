<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>フロンターレのファンクラブに入ろう！</h1>
	<c:if test="${not empty error }">
		<p>ろぐいんIDかパスワードが正しくありません</p>
	</c:if>

	<p>随時ファンクラブ会員募集中！</p>
	<p>一緒にフロンターレを応援しよう！</p>
	<p>▽会員の方はこちら▽</p>
	<form action="/frontale/login" method="post">
		<p>
			▶︎ID<input type="text" name="userId">
		</p>
		<p>
			▶︎PASSWORD<input type="password" name="pass">
		</p>
		<p>
			<input type="submit" value="ログイン">
		</p>
	</form>

</body>
</html>