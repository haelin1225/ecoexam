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
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
		<script type="text/javascript">
			$(window).load(function(){
				var boardNo = "${boardNo}";
				$("#boardName").append("<option>게시판 선택</option>");
				if(boardNo == 1) {
					$("#boardName").append("<option value='공지사항' selected>공지사항</option>"
							+"<option value='자유게시판'>자유게시판</option>"
							+"<option value='Q&A'>Q&A</option>");
				} else if(boardNo == 2) {
					$("#boardName").append("<option value='공지사항'>공지사항</option>"
							+"<option value='자유게시판' selected>자유게시판</option>"
							+"<option value='Q&A'>Q&A</option>");
				} else if(boardNo == 4) {
					$("#boardName").append("<option value='공지사항'>공지사항</option>"
							+"<option value='자유게시판'>자유게시판</option>"
							+"<option value='Q&A' selected>Q&A</option>");
				}
			});
		    function checkAll(){			
				if($("#boardName").val() == null) {
					alert("카테고리를 선택하세요");
					return false;
				}
				if($("#boardName").val() == "1") {
					$("#myform").append("<input type='hidden' name='boardName' value='공지사항'/>");
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
		<form class="form-horizontal" id="myform" role="form" onsubmit="javascript: return checkAll();" action="postWrite.eco" method="post">
			<input type="hidden" name="memberID" value="<%=member.getMemberID()%>"/>
			<div class="form-group">
				<label for="category" class="col-lg-2 control-label">카테고리</label>
				<div class="col-lg-3">
		  			<select class="form-control" id="boardName" name="boardName">
	
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
			    	<button type="reset" class="btn btn-default">취소</button>
			    </div>
			</div>
	  	</form>
	
	</div>
  </body>
</html>