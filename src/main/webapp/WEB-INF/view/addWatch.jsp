<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観戦追加</title>
</head>
<body>
	<h1>観戦追加</h1>
	<form action="" method="post">
		<table border="2">
			<tr>
				<th>対戦相手</th>
				<td><select name="game" id="game">
						<option>サンフレッチェ広島</option>
						<option>浦和レッズ</option>
						<option>鹿島アントラーズ</option>
						<option>セレッソ大阪</option>
						<option>ベガルタ仙台</option>
						<option>FC東京</option>
						<option>横浜マリノス</option>
						<option>ガンバ大阪</option>
						<option>北海道コンサドーレ札幌</option>

				</select></td>
			</tr>
			<tr>
				<th>試合場所</th>
				<td><select name="place" id="place">
						<option>エディオンスタジアム</option>
						<option>埼玉スタジアム</option>
						<option>茨城県立鹿島サッカースタジアム</option>
						<option>ヨドコウ桜スタジアム</option>
						<option>ユアテックスタジアム</option>
						<option>味の素スタジアム</option>
						<option>日産スタジアム</option>
						<option>パナソニックスタジアム吹田</option>
						<option>札幌ドーム</option>
						<option>等々力競技場</option>
				</select></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="追加">する
		</p>



	</form>



	<p></p>

</body>
</html>