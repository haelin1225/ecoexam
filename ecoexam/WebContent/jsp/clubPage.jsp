<%@page import="kr.co.eco.vo.ClubJoinVO"%>
<%@page import="kr.co.eco.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${clubVO.clubName}</title>
</head>
<body>
<%
	List<PostVO> posts = (List)request.getAttribute("posts");
	ClubJoinVO clubJoinVO = (ClubJoinVO)request.getAttribute("clubJoinVO");
%>
${clubVO.clubName}			
<%if(clubJoinVO==null){%>
<a href="clubJoin.eco?clubNo=${clubVO.clubNo}">가입</a>
<%} %>
&nbsp;&nbsp;
<%if(clubJoinVO!=null&&clubJoinVO.getClubRole().equals("clubmanager")){%>
<a href="clubManage.eco?clubNo=${clubVO.clubNo}">관리</a>
<%}%>
&nbsp;&nbsp;
<%if(clubJoinVO!=null&&clubJoinVO.getClubAgreeOk().equals("false")){%>
승인대기중...
<%}%>
<br>
클럽장 : ${clubVO.clubManagerID} 
<br>
클럽 게시글 		<a href="clubPostingForm.eco?clubNo=${clubVO.clubNo}">게시글 작성</a><br>
<table border=1>
	<tr>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
	</tr>
<%
if(posts!=null){
for(PostVO post : posts){%>
	<tr>
		<td><a href="clubBoard.eco?postNo=<%=post.getPostNo()%>&clubNo=${clubVO.clubNo}"><%=post.getPostTitle()%></a></td>
		<td><%=post.getMemberID()%></td>
		<td><%=post.getPostCreateDate()%></td>
		<td><%=post.getPostCount()%></td>
	</tr>
<%} }%>
</table>
</body>
</html>