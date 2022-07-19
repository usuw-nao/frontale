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
	<h1>観戦履歴削除</h1>
	<form action="" method="post">
		<table border="2">
			<tr>
				<th>観戦日</th>
				<td><c:out value="${watch.matchDay }" /></td>
			</tr>
			<tr>
				<th>対戦相手</th>
				<td><c:out value="${watch.game }" /></td>
			</tr>
			<tr>
				<th>試合会場</th>
				<td><c:out value="${watch.place }" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="削除する">
		</p>
	</form>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script>
${document}.ready(function(){
	${"form"}.submit(function(){
		return confirm("本当に削除しますか？");
	});
});
</script>

</body>
</html>