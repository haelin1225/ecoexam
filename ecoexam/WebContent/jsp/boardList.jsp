<%@page import="kr.co.eco.vo.MemberVO"%>
<%@page import="kr.co.eco.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Justified Nav Template for Bootstrap</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>
		$(window).load(function(){ 
		    	var totalPageCount = "${totalPageCount}";
		    	var currentPage = "${currentPage}";
		    	var startPage = "${startPage}";
		    	var endPage = "${endPage}";
		    	var boardNo = "${boardNo}"
		    	
		    	if(currentPage > 1) {
		    		$("#paging").append("<li><a href='boardList.eco?boardNo="+boardNo+"&currentPage="+(currentPage-1)+"'>«</a></li>");
		    	}
		    	if(totalPageCount >= 1) {
		    		for(var i=startPage; i<=endPage; i++) {
		    			if(i==currentPage) {
		    				$("#paging").append("<li class='active'><a href='boardNotice.eco?boardNo="+boardNo+"&currentPage="+i+"'>"+i+"</a></li>");
		    			}
		    			else {
		    				$("#paging").append("<li><a href='boardList.eco?boardNo="+boardNo+"&currentPage="+i+"'>"+i+"</a></li>");
		    			}
		    		}
		    	}
		    	if(endPage > currentPage) {
		    		$("#paging").append("<li><a href='boardList.eco?boardNo="+boardNo+"&currentPage="+(Number(currentPage)+1)+"'>»</a></li>");
		    	}
		 });
	    function loginConfirm(){			
			var result = confirm("로그인이 되어있지 않습니다.\n로그인 페이지로 이동하시겠습니까?");
			if(result) location.replace("loginForm.eco");
	    };
	</script>
  </head>
  <body>
	<div class="jumbotron">
	  <div class="container">
	    <strong>공지사항</strong>
	  </div>
	</div>
	<div class="container">
		<% 
			MemberVO member = (MemberVO)session.getAttribute("loginInfo"); 
			int totalPageCount = (Integer)request.getAttribute("totalPageCount");
			int boardNo = (Integer)request.getAttribute("boardNo");
			System.out.println(boardNo);
		%>		
		<p align="right"><a href="postWriteForm.eco?boardNo=${boardNo }" class="btn btn-primary" onclick="if(<%=member%> == null) loginConfirm(); return false">글쓰기</a></p>
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
		
		<ul id="paging" class="pagination"></ul>

	</div>

</body>
</html>