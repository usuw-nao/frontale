<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="domain.Watch,domain.Review,java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試合レビュー</title>
</head>
<body>
	<h1>観戦試合レビュー<c:out value="${watch.matchDay}" /></h1>

	<table border="1">
		<tr>
			<th>回数</th>
			<th>試合日</th>
			<th>対戦相手</th>
			<th>場所</th>
		</tr>
		<tr>
			<td><c:out value="${watch.id }" /></td>
			<td><c:out value="${watch.matchDay }" /></td>
			<td><c:out value="${watch.game }" /></td>
			<td><c:out value="${watch.place }" /></td>
		</tr>
	</table>

	<form action="" method="post">
		★感想★
		<p>
			☆彡名前<input type="text" name="name">
		</p>
		<p>
		☆彡点数<input type="number" min="0" max="100" name="evaluation">
		</p>
		<p>
			☆彡感想
			<textarea name="text" cols="50" rows="10"></textarea>
		</p>
		<p>
			<input type="submit" value="投稿">
		</p>
	</form>

	<c:forEach var="review" items="${reviews}">
		<table border="1">

			<tr>
				<th>名前</th>
				<td><c:out value="${review.name}" /></td>
			</tr>
			<tr>
				<th>点数</th>
				<td><c:out value="${review.evaluation}" /></td>
			</tr>
			
			
			<tr>
				<th>感想</th>
				<td><c:out value="${review.text}" /></td>
			</tr>
			<tr>
				<th>投稿日</th>
				<td><c:out value="${review.registered}" /></td>
			</tr>


		</table>

	</c:forEach>

</body>
</html>