<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="domain.Login"%>
<%
Login loginUser = (Login) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>後援会MYページ</title>
</head>
<body>
	<h1>フロンター〜れMyページ</h1>
	<p>お帰りなさい${userId }様</p>
	<p>
	<a href="gallery">観戦フォトギャラリー</a>
	</p>
	<p>
		<a href="juge">サッカー応援判定で遊ぶ</a>
	</p>
	<p>
		<a href="listWatch">観戦履歴</a>を見る
	</p>
	<p>
		<a href="logout">ログアウト</a>
	</p>


</body>
</html>