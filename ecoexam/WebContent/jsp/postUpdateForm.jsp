<%@page import="kr.co.eco.vo.PostVO"%>
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
	    <strong>글 수정</strong>
	  </div>
	</div>
	<div class="container">
		<script type="text/javascript">
		    function checkAll(){			
				if($("#boardName").val() == null) {
					alert("카테고리를 선택하세요");
					return false;
				}
				if($("#boardName").val() == "공지사항") {
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
	
		<%
			PostVO post = (PostVO)request.getAttribute("post");
		%>
		
		<form class="form-horizontal" role="form" onsubmit="javascript: return checkAll();" action="postUpdate.eco" method="post">
			<input type="hidden" name="postNo" value="<%=post.getPostNo()%>">
			<div class="form-group">
				<label for="category" class="col-lg-2 control-label">카테고리</label>
				<div class="col-lg-3">
		  			<select class="form-control" id="boardName" name="boardName">
						<option>게시판 선택</option>
						<option value="공지사항" selected>공지사항</option>
						<option value="자유게시판">자유게시판</option>
						<option value="Q&A">Q&A</option>
					</select>
		  		</div>
		  	</div>
	  		<div class="form-group">
	    		<label for="postTitle" class="col-lg-2 control-label">제목</label>
	    		<div class="col-lg-10">
	      			<input type="text" id="postTitle" name="postTitle" class="form-control" value="${post.getPostTitle()}">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="postContent" class="col-lg-2 control-label">내용</label>
	    		<div class="col-lg-10">
	    			<textarea id="postContent" name="postContent" class="form-control" rows="7">${post.getPostContent()}</textarea>
	    		</div>
	  		</div>
	  		<div class="form-group">
		    	<div class="col-lg-offset-2 col-lg-10">
		    		<button type="submit" class="btn btn-default">수정</button>
			    	<button type="reset" class="btn btn-default">취소</button>
		    	</div>
		  	</div>
		</form>
	</div>
  </body>
</html>