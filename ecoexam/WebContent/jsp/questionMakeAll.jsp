<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Justified Nav Template for Bootstrap</title>
  </head>
  <body>
  
<div class="jumbotron">
  <div class="container">
    <strong><br>[ ${testVO.testName} ] 제작</strong>
  </div>
</div>
    <div class="container">
	<h3>문제 제작 완료 확인</h3>

	<a href="testPreview.eco?testNo=${testNo}">미리보기</a><br>
	</div>

</body>
</html>