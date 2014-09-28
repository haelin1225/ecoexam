<%@page import="kr.co.eco.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Justified Nav Template for Bootstrap</title>
  </head>
  <body>
<%
	MemberVO member = (MemberVO)session.getAttribute("loginInfo");
%>
<div class="jumbotron">
  <div class="container">
    <strong>문제 제작</strong>
  </div>
</div>
  	<div class="container">      
      	<div class="well well-lg">
 		<form action="testCreate.eco" method="post">				
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
			</div>
 				
 			<div class="row">
 				<div class="col-lg-6">
 					<br><label for="testKind">문제 유형</label>
			      	<div class="form-group">
			  			<select class="form-control" name="testKind" onchange="if(this.value!='') answerChange(this);">
							<option value="주관식" selected>주관식</option>
							<option value="객관식">객관식</option>
							<option value="혼합형">혼합형</option>			
						</select>
			  		</div>
			  	</div><!-- /.col-lg-6 -->
			    <div class="col-lg-6" id="testForm">
			  		<br>
			  	</div><!-- /.col-lg-6 -->
			</div><br><!-- /.row -->
		
 			<div class="form-group">
 				<label for="testPoint">배점</label>
 				<select class="form-control" name="testPoint">
					<option value="같음" >같음</option>
					<option value="다름">다름</option>
				</select>
 			</div><br>
 			<div class="form-group">
 				<input type="submit" class="form-control" value="문제제작">
 			</div><br>
		</form>
		</div>


		<script type="text/javascript">
		function answerChange(kind){
		
			alert(kind.value);
			var testForm = document.getElementById("testForm");
			if(kind.value==="혼합형"){
				$("#label").remove();
				$("#div").remove();
				$("#testForm").append("<label for=\"testExampleCount\" id=\"label\">객관식 보기개수</label>"
						+"<div class=\"input-group\" id=\"div\">"
						+"<input type=\"text\"  name=\"testExampleCount\" class=\"form-control\" placeholder=\"총 문제수\">"
						+"<span class=\"input-group-addon\">개</span>");
			}
			else if(kind.value==="객관식"){
				$("#label").remove();
				$("#div").remove();
				$("#testForm").append("<label for=\"testExampleCount\" id=\"label\">보기개수</label>"
						+"<div class=\"input-group\" id=\"div\">"
						+"<input type=\"text\"  name=\"testExampleCount\" class=\"form-control\" placeholder=\"총 문제수\">"
						+"<span class=\"input-group-addon\">개</span>");
			}
			else if(kind.value==="주관식"){
				$("#label").remove();
				$("#div").remove();
			}
		}
		</script>
</div>

</body>
</html>