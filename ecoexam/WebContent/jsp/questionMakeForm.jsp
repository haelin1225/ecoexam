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
    <title>Justified Nav Template for Bootstrap</title>
  </head>
  <body>

<div class="jumbotron">
  <div class="container">
    <strong>[ ${testVO.testName} ] 제작</strong>
  </div>
</div>
    <div class="container">
    	<%
	    	CorrectAnswerVO correctVO = (CorrectAnswerVO)request.getAttribute("correctVO");
	    	TestVO testVO = (TestVO)request.getAttribute("testVO"); 
	    	QuestionVO questionVO = (QuestionVO)request.getAttribute("questionVO");
	    	List<ExampleVO> examples = (List)request.getAttribute("examples");
	    	int questionNo = (Integer)request.getAttribute("questionNo");
	    	String isupdate = "false";
	    	if(questionVO!=null){
	    		isupdate="true";
	    	}
		%>
    
    	<h2>${questionNo}번</h2>
    	<form class="form-horizontal" name="myform" role="form" onsubmit="javascript: return checkAll();" action="questionMakeSave.eco" method="post">
    		<input type="hidden" id="isupdate" name="isupdate" value="<%=isupdate%>"/>
			<input type="hidden" name="testNo" value="${testVO.testNo}" />
			<input type="hidden" name="questionNo" value="${questionNo}" />
			<input type="hidden" name="testExampleCount" value="${testVO.testExampleCount}" />
    	
			<div class="form-group">
	    		<label for="testPoint" class="col-lg-2 control-label">배점</label>
	    		<div class="col-lg-10">
	      			<input type="text" id="questionPoint" name="questionPoint" class="form-control"
	      			
	      			<%
						if(testVO.getTestPoint().equals("같음")){
							if(correctVO!=null){%>
								value="${correctVO.questionPoint}"
						<%	} else {
								int score = testVO.getTestTotalScore() / testVO.getTestTotalQuestion();%>
								value="<%=score%>"
						<%	} %>
							readonly
					<%	}
						else if(testVO.getTestPoint().equals("다름")){
							if(correctVO!=null){%>
								value="${correctVO.questionPoint}"
							<%} 
						}
					%>
	      			
	      			/>
	      		
	      			남은 배점 : ${testVO.testTotalScore-sum}
					
	    		</div>
	  		</div>
	  		<div class="form-group">
	  			<label for="testKind" class="col-lg-2 control-label">문제 유형</label>
	    		<div class="col-lg-10">
	  				<%
	  					System.out.println("문제유형"+testVO.getTestKind());
						if(testVO.getTestKind().equals("혼합형")){
							if(questionVO!=null&&questionVO.getQuestionKind().equals("객관식")){ %>
								<select class="form-control" name="questionKind" id="questionKind" onchange="if(this.value!='') answerChange(this);" >
									<option value="객관식" selected>객관식</option>
									<option value="주관식">주관식</option>
								</select>
						<%	}
							else if(questionVO!=null&&questionVO.getQuestionKind().equals("주관식")){ %>
								<select class="form-control" name="questionKind" id="questionKind" onchange="if(this.value!='') answerChange(this);" >
									<option value="객관식">객관식</option>
									<option value="주관식" selected>주관식</option>
								</select>
							<%}
							else{%>
								<select class="form-control" name="questionKind" id="questionKind" onchange="if(this.value!='') answerChange(this);" >
									<option value="">선택하세요</option>
									<option value="객관식">객관식</option>
									<option value="주관식">주관식</option>
								</select>
							<%}
						}
					%>
	  			</div>
	  		</div>
	  		<% if(questionVO!=null&&questionVO.getQuestionContent()!=null){%>
				<div class="form-group">
					<label for="questionContent" class="col-lg-2 control-label">지문</label>
					<div class="col-lg-10">
						<textarea name="questionContent" class="form-control" rows="3">${questionVO.questionContent}</textarea>
					</div>
				</div>
			<% } else{%>
		  		<div class="form-group">
		  			<label for="questionContent" class="col-lg-2 control-label">지문</label>
		  			<div class="col-lg-1">
		  				<input type="checkbox" id="is" onclick="showContent(this)">
		  			</div>
		  			<div class="col-lg-9">
		  				<div id="area"></div>
		  			</div>
		  		</div>
			<%}%>
	  		<div class="form-group">
	    		<label for="testTotalScore" class="col-lg-2 control-label">Q</label>
	    		<div class="col-lg-10">
	    			<input type="text" name="question" class="form-control" <%if(questionVO!=null){%>value="${questionVO.question}"<%} %>/>
	    		</div>
	  		</div>
	  		<div class="form-group">
	  			<div id="ans"></div>
	  		</div>
	  		
	  		<div class="form-group">
			    <div class="col-lg-offset-2 col-lg-10">
			    	<% if(questionNo>1){ %>
			  			<a href="questionMakeForm.eco?testNo=${testVO.testNo}&qNo=${questionNo-1}">이전</a>&nbsp;
			  		<%}if(questionVO!=null){ %>
			  			<a href="questionPreview.eco?testNo=${testVO.testNo}&qNo=${questionNo}">미리보기</a>&nbsp;
			  		<%}if(questionVO!=null){%>	
			  			<button type="submit" class="btn btn-default">수정</button>&nbsp;
			  		<%}else{%>
			  			<button type="submit" class="btn btn-default">저장</button>&nbsp;
			  		<%}if(questionNo==testVO.getTestTotalQuestion()) { %>
			  			<a href="questionMakeAll.eco?testNo=${testVO.testNo}">문제제작완료</a>&nbsp;
					<%}if(questionNo<testVO.getTestTotalQuestion()) {%>
						<a href="questionMakeForm.eco?testNo=${testVO.testNo}&qNo=${questionNo+1}">다음</a>
					<%} %>
	  			</div>
			</div>
		</form>
    
		<script type="text/javascript">
		$(document).ready(function(){
			var ans = document.getElementById("ans");
			var test = document.getElementById("test");
			
			if("${testVO.testKind}"==="객관식"||"${questionVO.questionKind}"==="객관식"){
				ans.innerHTML="";
				if($("#questionKind").val()==null){
					$("#ans").append("<input type='hidden' name='questionKind' value='객관식' />");
				}
				if('${examples[0].exampleContent}'===''){
					for(var i=0; i<"${testVO.testExampleCount}";i++ ){
						$("#ans").append("<label for='exampleCount' class='col-lg-2 control-label'>"+(i+1)+"번</label>"+
								"<div class='col-lg-10'><input type='text' name='exampleContent' class='form-control'/></div><br>");
					}
				}
				else{
					<c:forEach var = "example" items="${examples}" varStatus="loop">
					$("#ans").append("<label for='exampleCount' class='col-lg-2 control-label'>${example.exampleNo}번</label>"+
							"<div class='col-lg-10'><input type='text' class='form-control' name='exampleContent' value='${example.exampleContent}'/></div><br>");
					</c:forEach>
				}
				if("${correctVO.correctAnswer}"!=""){
			
					$("#ans").append("<label for='correctAnswer' class='col-lg-2 control-label'>A</label><div class='col-lg-10'>");

					for(var i=1; i<=Number('${testVO.testExampleCount}');i++){
						var is = 0;
						<c:forEach var="correct" items="${correctArr}" varStatus="loop">
							if(Number('${correct}') === i){							
								$("#ans").append("<label class='checkbox-inline'>"+
										"<input type='checkbox' class='form-control' name='correctAnswer' id='ca' value='"+i+"' checked/>"+i+"번 </label>"); 
								is = 1;
							}
						</c:forEach>
						if(is===0){
							$("#ans").append("<label class='checkbox-inline'>"+
									"<input type='checkbox' class='form-control' name='correctAnswer' id='ca' value='"+i+"'/>"+i+"번</label>"); 
						}
					}
					
					$("#ans").append("</div>");
				}
				else{
					$("#ans").append("<label for='correctAnswer' class='col-lg-2 control-label'>A</label><div class='col-lg-10'>");
					for(var i=1; i<='${testVO.testExampleCount}';i++){
						$("#ans").append("<label class='checkbox-inline'>"+
								"<input type='checkbox' class='form-control' name='correctAnswer' value='"+i+"' />"+i+"번</label>"); 
						
					}
					$("#ans").append("</div>");
				}
			}
			else if("${testVO.testKind}"==="주관식"||"${questionVO.questionKind}"==="주관식"){
				ans.innerHTML="";
				if($("#questionKind").val()==null){
					$("#ans").append("<input type='hidden' name='questionKind' value='주관식' />");
				}
				if("${correctVO}"!=""){
					$("#ans").append("<label for='correctAnswer' class='col-lg-2 control-label'>A</label>"+
							"<div class='col-lg-10'><input type='text' name='correctAnswer' value='${correctVO.correctAnswer}' class='form-control'/></div><br>");
				}
				else{
					$("#ans").append("<label for='correctAnswer' class='col-lg-2 control-label'>A</label>"+
							"<div class='col-lg-10'><input type='text' name='correctAnswer' class='form-control'/></div><br>");
				}
			}
		});
		
		function answerChange(kind){
			var ans = document.getElementById("ans");	
			if(kind.value==="주관식"){
				ans.innerHTML="";
				if("${correctVO.correctAnswer}"!=null){
					ans.innerHTML="<label for='correctAnswer' class='col-lg-2 control-label'>A</label>"+
							"<div class='col-lg-10'><input type='text' name='correctAnswer' value='${correctVO.correctAnswer}' class='form-control'/></div><br>"; 
				}
				else{
					ans.innerHTML="<label for='correctAnswer' class='col-lg-2 control-label'>A</label>"+
							"<div class='col-lg-10'><input type='text' name='correctAnswer' class='form-control'/></div><br>"; 
				}
				$("#ans").append("<input type='hidden' name='isdel' value='true' />");
			}
			else if(kind.value==="객관식"){
				ans.innerHTML="";
				if('${examples[0].exampleContent}'===''){
					for(var i=0; i<'${testVO.testExampleCount}';i++ ){
						$("#ans").append("<label for='exampleCount' class='col-lg-2 control-label'>"+(i+1)+"번</label>"+
								"<div class='col-lg-10'><input type='text' name='exampleContent' class='form-control'/></div><br>");	
					}				 
				}
				else{
					<c:forEach var = "example" items="${examples}" varStatus="loop">
					$("#ans").append("<label for='exampleCount' class='col-lg-2 control-label'>${example.exampleNo}번</label>"+
							"<div class='col-lg-10'><input type='text' class='form-control' name='exampleContent' value='${example.exampleContent}'/></div><br>");
					</c:forEach>
				}
				if("${correctVO.correctAnswer}"!=null){
					$("#ans").append("<label for='correctAnswer' class='col-lg-2 control-label'>A</label><div class='col-lg-10'>");

					for(var i=1; i<=Number('${testVO.testExampleCount}');i++){
						var is = 0;
						<c:forEach var="correct" items="${correctArr}" varStatus="loop">
							if(Number('${correct}') === i){							
								$("#ans").append("<label class='checkbox-inline'>"+
										"<input type='checkbox' class='form-control' name='correctAnswer' id='ca' value='"+i+"' checked/>"+i+"번 </label>"); 
								is = 1;
							}
						</c:forEach>
						if(is===0){
							$("#ans").append("<label class='checkbox-inline'>"+
									"<input type='checkbox' class='form-control' name='correctAnswer' id='ca' value='"+i+"'/>"+i+"번</label>"); 
						}
					}
					
					$("#ans").append("</div>");
				}
				else{
					/*$("#ans").append("<label for='correctAnswer' class='col-lg-2 control-label'>A</label><div class='col-lg-10'>");
					for(var i=1; i<='${testVO.testExampleCount}';i++){
						$("#ans").append("<label class='checkbox-inline'>"+
								"<input type='checkbox' class='form-control' name='correctAnswer' value='"+i+"' />"+i+"번</label>"); 
						
					}
					$("#ans").append("</div>");*/
					$("#ans").append("A<input type=\"text\" name=\"correctAnswer\" />");
				}
			}	
			
		}
		
		function showContent(obj){
			var area = document.getElementById("area");
			if(obj.checked==true){
				area.innerHTML="<textarea name=\"questionContent\" class=\"form-control\" rows=\"3\"/>";
			}
			else if(obj.checked==false){
				area.innerHTML="";
			}
		}
		function checkAll(){
			var data = document.myform.elements[0];
			var point = document.getElementsByName("questionPoint").value;	
			var total =	 Number('${testVO.testTotalScore}');
			var sum = Number('${sum}') + Number($("#questionPoint").val());
			if($("#isupdate").val()==="true"){
				sum = sum - Number('${correctVO.questionPoint}');
				if(total<sum){
					data.style.borderColor="red";
					data.focus();
					alert("배점 초과 : "+(sum-total));
					return false;
				}
			} 
			else if($("#isupdate").val()==="false"&&total<sum){
				data.style.borderColor="red";
				data.focus();
				alert("배점 초과 : "+(sum-total));
				return false;
			}
			else{
				return true;
			}
		}
	
	</script>
	</div>

</body>
</html>