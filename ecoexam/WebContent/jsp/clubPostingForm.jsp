<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기</h1>
	<form action="clubPosting.eco" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="postTitle" size="68"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="12" cols="70" name="postContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="boardName" value="${clubVO.clubNo}"/>
					<input type="submit" value="작성">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
