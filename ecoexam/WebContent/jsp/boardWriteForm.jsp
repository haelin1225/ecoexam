<%@page import="kr.co.eco.vo.MemberVO"%>
<%@page import="kr.co.eco.vo.PostVO"%>
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
	    <strong>글 작성</strong>
	  </div>
	</div>
	<%
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
    	System.out.println("board : "+member);
	%>
	<div class="container">
		<script type="text/javascript">
		    function checkAll(){			
				if($("#boardNo").val() == null) {
					alert("카테고리를 선택하세요");
					return false;
				}
				if($("#boardNo").val() == "1") {
					$("#myform").append("<input type='hidden' name='boardNo' value='1'/>");
					return true;
				}
				if($("#postTitle").val() == "") {
					alert("제목을 입력하세요");
					return false;
				}
				if($("#postContent").val() == "") {
					alert("내용을 입력하세요");
					return false;
				}
				else {
					return true;
				}
			}
	    </script>
		<form class="form-horizontal" id="myform" role="form" onsubmit="javascript: return checkAll();" action="boardWrite.eco" method="post">
			<input type="hidden" name="memberID" value="<%=member.getMemberID()%>"/>
			<div class="form-group">
				<label for="category" class="col-lg-2 control-label">카테고리</label>
				<div class="col-lg-3">
		  			<select class="form-control" id="boardNo">
						<option>게시판 선택</option>
						<option value="1" selected>공지사항</option>
						<option value="2">자유게시판</option>
						<option value="4">Q&A</option>
					</select>
		  		</div>
		  	</div>
		  	<div class="form-group">
				<label for="postTitle" class="col-lg-2 control-label">제목</label>
				<div class="col-lg-10">
		  			<input type="text" id="postTitle" name="postTitle" class="form-control" placeholder="제목을 입력하세요"/>
		  		</div>
		  	</div>
		  	<div class="form-group">
				<label for="postContent" class="col-lg-2 control-label">내용</label>
				<div class="col-lg-10">
		  			<textarea id="postContent" name="postContent" class="form-control" rows="7"></textarea>
		  		</div>
		  	</div>
		  	<div class="form-group">
				<label for="postFile" class="col-lg-2 control-label">파일첨부</label>
				<div class="col-lg-10">
		  			<input type="file" id="postFile" name="postFile" class="form-control"/>
		  		</div>
		  	</div>
		  	<div class="form-group">
			    <div class="col-lg-offset-2 col-lg-10">
			    	<button type="submit" class="btn btn-default">저장</button>
			    	<button type="submit" class="btn btn-default">취소</button>
			    </div>
			</div>
	  	</form>
	
	</div>
  </body>
</html>