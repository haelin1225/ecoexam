<%@page import="java.util.List"%>
<%@page import="kr.co.eco.vo.TestVO"%>
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

	<br><br><h2>검색 결과</h2>
	<table class="table table-striped">
		<tr>
			<th>시험지번호</th>
    		<th>제작자ID</th>
    		<th>시험지 이름</th>
    		<th>시험시간</th>
    		<th>시험 총점</th>
    		<th>배점</th>
    		<th>문제유형</th>
    		<th>보기수</th>
    		<th>총 문제수</th>     
    		<th>첨부파일</th> 
		</tr>
		<%
			List<TestVO> list = null;
			list = (List<TestVO>)request.getAttribute("testSearchList");
				
			if(list !=null) {
				for(TestVO testVO : list) {
				/* System.out.println("testSearchList.jsp");
				System.out.println(list); */
		%>	
		<tr>
			<td><%= testVO.getTestNo() %></td>
			<td><%= testVO.getTestMakerID() %></td>
			<td><%= testVO.getTestName() %></td>
			<td><%= testVO.getTestTime() %></td>
			<td><%= testVO.getTestTotalScore() %></td>
			<td><%= testVO.getTestPoint() %></td>
			<td><%= testVO.getTestKind() %></td>
			<td><%= testVO.getTestExampleCount() %></td>
			<td><%= testVO.getTestTotalQuestion() %></td>
			<td><%= testVO.getTestFileName() %></td>
		</tr>  
	<% 		}
		} else { %>
	<% } %>
	</table>
	</form>
</div>

</body>
</html>
