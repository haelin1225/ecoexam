<%@page import="kr.co.eco.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>기본문제 제작 폼</title>
  </head>
  <body>

<div class="jumbotron">
  <div class="container">
    <strong><br>기본문제 제작</strong>
  </div>
</div>
  	<div class="container">      
      	<div class="well well-lg">
 		<form action="testBaseCreate.eco" method="post" enctype="multipart/form-data">				
 			<label for="testName">시험 제목</label>
 			<div class="form-group">
		    	<input type="text" name="testName" class="form-control" placeholder="시험 제목">
			</div>
			
			<label for="testTime">제한 시간</label>
			<div class="input-group">
			    <input type="text" name="testTime" class="form-control" placeholder="제한 시간">
			    <span class="input-group-addon">분</span>
			</div>
			
			<br><label for="testTotalScore">총 점</label>
			<div class="input-group">
			    <input type="text" name="testTotalScore" class="form-control" placeholder="총점">
			    <span class="input-group-addon">점</span>
			</div>
			<br><label for="testTotalQuestion">총 문제 수</label>
			<div class="input-group">
			    <input type="text" name="testTotalQuestion" class="form-control" placeholder="시험 제목">
				<span class="input-group-addon">문제</span>
			</div> <br>
 			
 			<div class="form-group">
 				<label for="testPoint">배점</label>
 				<select class="form-control" name="testPoint">
					<option value="같음" >같음</option>
					<option value="다름">다름</option>
				</select>
 			</div>
 			
 			<label for="updloadFile">파일 첨부</label>
			<div class="input-group">
			    <input type="file" name="updloadFile" class="form-control" placeholder="파일 첨부">
			    <span class="input-group-addon">파일</span>
			</div> <br>
 			
 			<div class="form-group">
 				<input type="submit" class="form-control" value="문제제작">
 			</div><br>
		</form>
		</div>

</div>

</body>
</html>