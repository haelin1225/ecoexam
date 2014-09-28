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
	    <strong>공지사항</strong>
	  </div>
	</div>
	<div class="container">
		<% MemberVO member = (MemberVO)session.getAttribute("loginInfo"); %>
		<script type="text/javascript">
		    function loginConfirm(){			
				var result = confirm("로그인이 되어있지 않습니다.\n로그인 페이지로 이동하시겠습니까?");
				if(result) location.replace("loginForm.eco");

			}
	    </script>
		<p align="right"><a href="postWriteForm.eco" class="btn btn-primary" onclick="if(<%=member%> == null) loginConfirm(); return false">글쓰기</a></p>
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<th width="500">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			
			<% 
				List<PostVO> noticeList = (List<PostVO>)request.getAttribute("noticeList");
				
				for(PostVO post : noticeList) { 
					int postNo = post.getPostCount();	
			%>
					<tr>
						<td><%=post.getPostNo()%></td>
						<td><a href="postRead.eco?postNo=<%=post.getPostNo()%>"><%=post.getPostTitle()%></a></td>
						<td><%=post.getMemberID()%></td>
						<td><%=post.getPostCreateDate()%></td>
						<td><%=post.getPostCount()%></td>
					</tr>
			<%	}%>
		</table>
		
		<ul class="pagination">
			<li class="disabled"><a href="#">«</a></li>
		 	<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		 	<li><a href="#">2</a></li>
		 	<li><a href="#">3</a></li>
		 	<li><a href="#">4</a></li>
		 	<li class="disabled"><a href="#">»</a></li>
		</ul>

	</div>

</body>
</html>