<%@page import="java.util.List"%>
<%@page import="kr.co.eco.vo.ExampleVO"%>
<%@page import="kr.co.eco.vo.TestVO"%>
<%@page import="kr.co.eco.vo.QuestionVO"%>
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
    <strong>[ ${testVO.testName} ] - ${questionVO.questionNo}번 미리보기</strong>
  </div>
</div>
    <div class="container">
		<%
			QuestionVO questionVO = (QuestionVO)request.getAttribute("questionVO"); 
			TestVO testVO = (TestVO)request.getAttribute("testVO");
			List<ExampleVO> examples = (List)request.getAttribute("examples");
		%>
		<form class="form-horizontal">
			<div class="form-group">
		   		<label for="testPoint" class="col-lg-2 control-label">배점</label>
		   		<div class="col-lg-10"> ${correctVO.questionPoint} </div>
			</div>
			<div class="form-group">
		   		<label for="testKind" class="col-lg-2 control-label">문제 유형</label>
		   		<div class="col-lg-10"> ${questionVO.questionKind} </div>
			</div>
			<% if(questionVO.getQuestionContent()!=null){ %>
				<div class="form-group">
			   		<label for="questionContent" class="col-lg-2 control-label">지문</label>
			   		<div class="col-lg-10"> ${questionVO.questionContent} </div>
				</div>
			<%} %>
			<div class="form-group">
		   		<label for="question" class="col-lg-2 control-label">Q</label>
		   		<div class="col-lg-10"> ${questionVO.question} </div>
			</div>
			<div class="form-group">
			   	<label for="memberAnswer" class="col-lg-2 control-label">A</label>
				<%if(questionVO.getQuestionKind().equals("객관식")){
					for(ExampleVO example : examples){
				%>
						<label class='checkbox-inline'>
					   		<input type="checkbox" class="form-control" name="memberAnswer" id="memberAnswer" value="<%=example.getExampleNo()%>" />
					   		<%=example.getExampleNo()%>번 &nbsp; <%=example.getExampleContent()%> 
					   	</label>
				<%}}
				else if(questionVO.getQuestionKind().equals("주관식")){%>
					<div class="col-lg-10">
						<input type="text" class="form-control" name="memberAnswer" />
					</div>
				<%} %>   	
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<a href="questionMakeForm.eco?testNo=${testVO.testNo}&qNo=${questionVO.questionNo}">돌아가기</a>&nbsp;
				</div>
			</div>
		</form>
		</div>

		</body>
		</html>