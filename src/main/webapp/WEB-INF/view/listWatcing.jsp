<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観戦履歴</title>
</head>
<body>
	<h1>観戦履歴</h1>
	<table border="2">
		<tr>
			<th>回数</th>
			<th>試合日</th>
			<th>対戦相手</th>
			<th>場所</th>
			<th colspan="2">データの操作</th>
			<th>レビュー</th>
		</tr>
		<c:forEach items="${watchList }" var="watch">
			<tr>
				<td><c:out value="${watch.id }" /></td>
				<td><c:out value="${watch.matchDay }" /></td>
				<td><c:out value="${watch.game }" /></td>
				<td><c:out value="${watch.place }" /></td>
				<td><a href="updateWatch?id=<c:out value="${watch.id }" />">更新</a></td>
				<td><a href="deleteWatch?id=<c:out value="${watch.id }" />">削除</a></td>
				<td><a href="Review">レビュー</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="addWatch">観戦の追加</a>
	</p>
	<p>
		<a href="login">戻る</a>
	</p>


</body>
</html>