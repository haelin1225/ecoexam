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
			<strong>커뮤니티</strong>
		</div>
	</div>
	
		<%
			List<PostVO> postList = (List<PostVO>)request.getAttribute("postList");
		%>
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-6">
					<div class="thumbnail">
						<h2>공지사항</h2>
						<p align='right'><a href="boardNotice.eco">more</a>
						<table class="table table-striped">
							<tr>
								<th>번호</th>
								<th>글제목</th>
								<th>작성자</th>
							</tr>
							<%
								int i=0;
								for(PostVO post : postList) {
									if(post.getBoardNo() == 1) { 
										i++;
										if(i>3) break;
							%>
										<tr>
											<td><%= post.getPostNo() %></td>
											<td><a href="postRead.eco?postNo=<%=post.getPostNo()%>"><%=post.getPostTitle()%></a></td>
											<td><%= post.getMemberID() %></td>
										</tr>
							<%		}
								}
							%>
						</table>
			    	</div>
			  	</div>
			  	
			  	<div class="col-sm-6 col-md-6">
					<div class="thumbnail">
						<h2>자유게시판</h2>
						<p align='right'><a href="#">more</a>
						<table class="table table-striped">
							<tr>
								<th>번호</th>
								<th>글제목</th>
								<th>작성자</th>
							</tr>
							<%
								i=0;
								for(PostVO post : postList) {
									if(post.getBoardNo() == 2) { 
										i++;
										if(i>3) break;
							%>
										<tr>
											<td><%= post.getPostNo() %></td>
											<td><a href="postRead.eco?postNo=<%=post.getPostNo()%>"><%=post.getPostTitle()%></a></td>
											<td><%= post.getMemberID() %></td>
										</tr>
							<%		}
								}
							%>
						</table>
			    	</div>
			  	</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6 col-md-6">
					<div class="thumbnail">
						<h2>FAQ</h2>
						<p align='right'><a href="#">more</a>
						<table class="table table-striped">
							<tr>
								<th>번호</th>
								<th>글제목</th>
							</tr>
							<tr>
								<td>1</td>
								<td>abcccccc</td>
							</tr>
							<tr>
								<td>2</td>
								<td>aaaaaaaa</td>
							</tr>
						</table>
			    	</div>
			  	</div>
			  	
			  	<div class="col-sm-6 col-md-6">
					<div class="thumbnail">
						<h2>Q&A</h2>
						<p align='right'><a href="#">more</a>
						<table class="table table-striped">
							<tr>
								<th>번호</th>
								<th>글제목</th>
								<th>작성자</th>
							</tr>
							<%
								i=0;
								for(PostVO post : postList) {
									if(post.getBoardNo() == 4) { 
										i++;
										if(i>3) break;
							%>
										<tr>
											<td><%= post.getPostNo() %></td>
											<td><a href="postRead.eco?postNo=<%=post.getPostNo()%>"><%=post.getPostTitle()%></a></td>
											<td><%= post.getMemberID() %></td>
										</tr>
							<%		}
								}
							%>
						</table>
			    	</div>
			  	</div>
			</div>
		
		</div>	
</body>
</html>