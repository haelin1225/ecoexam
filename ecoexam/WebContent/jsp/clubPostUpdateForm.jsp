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
			PostVO postVO = (PostVO)request.getAttribute("postVO");
		%>
		
		<form class="form-horizontal" role="form" onsubmit="javascript: return checkAll();" action="clubPostUpdate.eco" method="post">
			<input type="hidden" name="postNo" value="<%=postVO.getPostNo()%>">
			<input type="hidden" name="clubNo" value="${clubNo}">
	  		<div class="form-group">
	    		<label for="postTitle" class="col-lg-2 control-label">제목</label>
	    		<div class="col-lg-10">
	      			<input type="text" id="postTitle" name="postTitle" class="form-control" value="${postVO.getPostTitle()}">
	    		</div>
	  		</div>
	  		<div class="form-group">
	    		<label for="postContent" class="col-lg-2 control-label">내용</label>
	    		<div class="col-lg-10">
	    			<textarea id="postContent" name="postContent" class="form-control" rows="7">${postVO.getPostContent()}</textarea>
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