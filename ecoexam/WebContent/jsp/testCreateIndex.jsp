<%@page import="kr.co.eco.vo.TestVO"%>
<%@page import="java.util.List"%>
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
    <strong>문제 검색</strong>
  </div>
</div>
    <div class="container">
	<script type="text/javascript">
		function searchSelect(choice) {
			alert(choice.value);

			if(choice.value === "testName") {
				$("#select").remove();
				$("#value").append("<input type='hidden' id='select' name='select' value='testName'>");
			} 
			if(choice.value === "testMakerID") {
				$("#select").remove();
				$("#value").append("<input type='hidden' id='select' name='select' value='testMakerID'>");
			}
		}
		function testChoice(kind) {
			alert(kind.value);

			if(kind.value === "allTest") {
				$("#testKind").remove();
				$("#value").append("<input type='hidden' id='testKind' name='testKind' value='allTest'>");
			}
			else if(kind.value === "baseTest") {
				$("#testKind").remove();
				$("#value").append("<input type='hidden' id='testKind' name='testKind' value='baseTest'>");
			} 
			else {
				$("#testKind").remove();
				$("#value").append("<input type='hidden' id='testKind' name='testKind' value='makeTest'>");
			} 
		}
		function checkAll(){			
			if($("#select").val() == null) {
				alert("검색유형을 선택하세요");
				return false;
			}
			if($("#testKind").val() == null) {
				alert("문제유형을 선택하세요");
				return false;
			}
			else {
				return true;
			}
		}
	</script>

	<h2>TEST SEARCH</h2>
	<form class="form-inline" role="form" action="testSearch.eco" onsubmit="javascript: return checkAll();">
		<div class="form-group">
	   	 	<input type="text" name="searchStr" class="form-control"  placeholder="test name">
	  	</div>
	  	<div class="form-group">
  			<select class="form-control" id="choice" onchange="searchSelect(this);">
				<option>검색유형</option>
				<option value="testName">시험이름</option>
				<option value="testMakerID">작성자</option>
			</select>
  		</div>
  		<div class="form-group">
  			<select class='form-control' id='kind' onchange='testChoice(this);'>
  				<option>문제유형</option>
				<option value='allTest'>전체</option>
				<option value='baseTest'>기본문제</option>
				<option value='makeTest'>제작문제</option>
			</select>
  		</div>
  		<div class = "form-group" id="value"></div>
 	 	<button type="submit" class="btn btn-default">Search</button>
	</form>
	
	<br><br>
	<h2>NEW MAKE TEST</h2>
	<div class="row">
		<% 
 			List<TestVO> mTestList = (List<TestVO>)request.getAttribute("makeTest");
			if(mTestList !=null) {
				int i=0;
				for(TestVO mTestVO : mTestList) {
					i++;
					if(i<= mTestList.size()-4)
						continue;
					else {
		%>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<h3><%= mTestVO.getTestName() %></h3>
				<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	      		<p class="solveBtn"><a href="#" class="btn btn-primary">문제 풀기</a></p>
	    	</div>
	  	</div>
	  	<% 		}	
			} }%>
	</div>
	
	<br><br>
	<h2>NEW BASE TEST</h2>
	<div class="row">
		<% 
 			List<TestVO> bTestList = (List<TestVO>)request.getAttribute("baseTest");
			if(bTestList !=null) {
				int i=0;
				for(TestVO bTestVO : bTestList) {
					i++;
					if(i<= bTestList.size()-4)
						continue;
					else {
		%>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<h3><%= bTestVO.getTestName() %></h3>
				<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	      		<p class="solveBtn"><a href="#" class="btn btn-primary">문제 풀기</a></p>
	    	</div>
	  	</div>
	  	<% 		}	
			} }%>
	</div>

</div>

</body>
</html>