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
  		int eCount = (Integer)request.getAttribute("eCount");
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
		    		<label for="testKind" class="col-lg-2 control-label">문제유형</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestKind()}">
		    		</div>
		  		</div>
		  		<% if(eCount !=  0) { %>
		  		<div class="form-group">
		    		<label for="testExampleCount" class="col-lg-2 control-label">보기개수</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="<%= eCount %>">
		    		</div>
		  		</div>
		  		<% } %>
		  		<div class="form-group">
		    		<label for="testPoint" class="col-lg-2 control-label">배점</label>
		    		<div class="col-lg-10">
		      			<input type="text" class="form-control" value="${test.getTestPoint()}">
		    		</div>
		  		</div>
		  </fieldset>
		  		<div class="form-group">
			    	<div class="col-lg-offset-2 col-lg-10">
			      		<button type="submit" class="btn btn-default">Question 생성하기</button>
			    	</div>
			  	</div>
		</form>
  		</div>

</body>
</html>