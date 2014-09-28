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
    <strong><br>문제 제작 확인</strong>
  </div>
</div>
  	<% 
  		String testNo = (String)request.getAttribute("testNo");
  	%>
  	<div class="container">
  	
  		<form class="form-horizontal" role="form" action="questionMakeForm.eco" method="post">
  			<input type="hidden" name="testNo" value="<%=testNo%>">
			<fieldset disabled>
				<div class="form-group">
		    		<label for="testName" class="col-lg-2 control-label">시험 제목</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestName()}">
		    		</div>
		  		</div>
		  		<div class="form-group">
		    		<label for="testTime" class="col-lg-2 control-label">제한 시간</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestTime()}분">
		    		</div>
		  		</div>
		  		<div class="form-group">
		    		<label for="testTotalScore" class="col-lg-2 control-label">총 점</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestTotalScore()}점">
		    		</div>
		  		</div>
		  		<div class="form-group">
		    		<label for="testTotalQuestion" class="col-lg-2 control-label">총 문제 수</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestTotalQuestion()}문제">
		    		</div>
		  		</div>
		  		
		  		<div class="form-group">
		    		<label for="testPoint" class="col-lg-2 control-label">배점</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestPoint()}">
		    		</div>
		  		</div>
		  </fieldset>
		  		
		</form>
		
		<form class="form-horizontal" action="baseCorrectAnswer.eco">
		<table class="table table-striped" id="answer" >
			<tr class="item1">
				<th width="100px" align="center">문제번호</th>
				<th width="500px" align="center">정답</th>
				<th width="100px" align="center">배점</th>
			</tr>
			<% 
				String str = request.getParameter("testTotalQuestion");
				int questionCount = Integer.parseInt(str);
				for(int i=0; i<questionCount; i++) {
			%>
			<tr>
				<td><input type="hidden" name="questionNo" value="<%= i+1 %>"/><%= i+1 %></td>
				<td><input type="text" class="form-control" placeholder=".col-lg-10" name="correctAnswer"/></td>
				<td><input type="text" class="form-control" placeholder=".col-lg-5" name="questionPoint"/></td>
			</tr>
			<% } %>
			<!-- <tr>
				<td><input type="submit" value="완료" ></td>
			</tr> -->
		</table>
		<input type="hidden" name="testNo" value="<%=testNo %>"/>
		<div class="form-group">
 				<input type="submit" class="form-control" value="완료">
 		</div><br>
	</form>
  		</div>
  		
  		

</body>
</html>