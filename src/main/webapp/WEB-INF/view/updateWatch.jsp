<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観戦履歴管理</title>
</head>
<body>
	<h1>観戦履歴編集</h1>
	<form action="" method="post">
		<table border="2">
			<tr>
				<th>試合相手</th>
				<td><c:if test="${not empty gameError }">
						<p>
							<c:out value="${gameError}" />
						</p>
					</c:if> <input type="text" name="game" value="<c:out value="${game }" />">
				</td>
			</tr>
			<tr>
				<th>試合場所</th>
				<td><c:if test="${not empty placeError }">
						<p>
							<c:out value="${placeError }" />
						</p>
					</c:if> <input type="text" name="place" value="<c:out value="${place }"/>">
				</td>
			</tr>


		</table>
		<p>
			<input type="submit" value="更新">
		</p>
	</form>

</body>
</html>