<%@page import="kr.co.eco.vo.ExampleVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.eco.vo.QuestionVO"%>
<%@page import="kr.co.eco.vo.CorrectAnswerVO"%>
<%@page import="kr.co.eco.vo.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>기본문제 파일 올리기</title>
  </head>
<body>

<div class="jumbotron">
  <div class="container">
    <strong>[ ${testVO.testName} ] 제작</strong>
  </div>
</div>

	<!-- 일단 TEST만 JAVASCRIPT로 바꿔서 AJAX 이용 -->
	<form action="createBaseQuestion.eco">
	    <div>
	    	<input type="hidden" value="${testVO.testNo}" name="testNo"/>
	    	<input type="hidden" value="${testVO.testName}" name="testName" />
			<input type="submit" value="문제풀기제작"/>
		</div>
	</form>

</body>
</html>