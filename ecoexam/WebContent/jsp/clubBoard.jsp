<%@page import="kr.co.eco.vo.CommentsVO"%>
<%@page import="kr.co.eco.vo.PostNoVO"%>
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
	    <strong>글 읽기</strong>
	  </div>
	</div>
	<%
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		PostVO postVO = (PostVO)request.getAttribute("post");
		PostNoVO postNoList = (PostNoVO)request.getAttribute("postNoList");
		List<CommentsVO> comments = (List)request.getAttribute("comments");
		int count  = comments.size();
	%>
	<div class="container">
	
		<p align="right">
		<%    		
    		if(member != null) {
    			System.out.println(postVO.getMemberID());
    			if(member.getMemberID().equals(postVO.getMemberID())) { %>
    						<a href="clubPostUpdateForm.eco?postNo=<%=postVO.getPostNo()%>&clubNo=${clubVO.clubNo}" class="btn btn-primary">수정</a>
    						<button class="btn btn-primary" onclick="deleteConfirm();">삭제</button>
    				<%	} else if(member == null) {}
    		}
    	%>
		</p>
		
		<table class="table">
			<tr>
				<th colspan="2"><h3><b>${post.getPostTitle()}</b> <small>| ${clubVO.clubName} </small></h3></th>
				<th width="300"><h3>${post.getPostCreateDate()}</h3></th>
			</tr>
			<tr>
				<td colspan="3">작성자 : ${post.getMemberID()}</td>
			</tr>
			<tr height="200">
				<td colspan="3">${post.getPostContent()}</td>
			</tr>
			<tr>
				<td colspan="3">
					댓글 <%=count %>개 | 조회수 ${post.getPostCount()}
				</td>
			</tr>
			<tr>
				<td colspan="3">
				<%	for(CommentsVO comment : comments){ %>
						<b><%=comment.getMemberID() %></b> | <%=comment.getCommentsCreateDate() %><br>
						<%=comment.getCommentsContent() %><hr>
			<%		} %>
					<div id="commentForm"></div>
				</td>
			</tr>
			<%if(member != null) {%>
				<tr>
					<td colspan="3">
						<div class="row">
							<div class="col-lg-2"><input type="text" id="memberID" value="<%=member.getMemberID()%>" readonly></div>
							<div class="col-lg-8"><textarea id="commentsContent" name="commentsContent" class="form-control" rows="3"></textarea></div>
							<div class="col-lg-2">
								<input type="hidden" id="postNo" value="${post.postNo}" />
								<button id="send" class="btn btn-primary" onclick="comment();">댓글입력</button>
							</div>
						</div>
					</td>
				</tr>
			<%} %>
			<tr>
				<td colspan="2">
					<% if(postNoList.getPre_postNo() != 0) {%>
			    			<a href="clubBoard.eco?postNo=<%=postNoList.getPre_postNo()%>&clubNo=${clubVO.clubNo}" class="btn btn-primary">« 이전</a>
			    	<% } %>
			    	<a href="clubPage.eco?clubNo=${clubVO.clubNo}" class="btn btn-primary">${clubVO.clubName}</a>
			    	<% if(postNoList.getNext_postNo() != 0) {%>
			    		<a href="clubBoard.eco?postNo=<%=postNoList.getNext_postNo()%>&clubNo=${clubVO.clubNo}" class="btn btn-primary">다음 »</a>
			    	<% } %>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">	
		function deleteConfirm(){			
			var result = confirm("삭제하시겠습니까?");
			if(result) location.replace("clubPostDelete.eco?postNo=${post.getPostNo()}&clubNo=${clubVO.clubNo}");
		}

		function comment() {
			 $.ajax({
				url : "comment.eco",
				type : "post",
				contentType : "application/json",
				data : {
					"postNo" : '${post.postNo}',
					"memberID" : $("#memberID").val(),
					"commentsContent" : $("#commentsContent").val()
				},
				dataType : "json",
				success : function(data) {
					$("#commentsContent").val('');
					$("#commentForm").append("<b>"+decodeURIComponent(data.memberID)+"</b> | "+data.commentsCreateDate+"<br>"
							+decodeURIComponent(data.commentsContent)+"<hr>");
				},
				error : function(data) {
					alert("error : " + data);
				}
			})
		}
	</script>
	
  </body>
</html>