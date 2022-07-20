<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観戦フォトギャラリー</title>
</head>
<body>

	<h1>観戦した時の思い出の写真をのせよう！</h1>
	<c:if test="${!empty error }">
		<c:out value="{error}" />
	</c:if>
	<form action="" method="post" enctype="multipart/form-data" name="form">
		<p>
			⚽ファイル：<input type="file" name="file" />
		</p>
		
	</form>

	<c:if test="${!empty fileList}">
		<c:forEach var="file" items="${fileList}">
			<img class="img-thumbnail"
				src="uploads/<c:out value="${file.name}" />">
		</c:forEach>
	</c:if>
	<p><a href="login">戻る</a></p>

</body>
</html>