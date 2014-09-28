<%@page import="kr.co.eco.vo.ClubVO"%>
<%@page import="kr.co.eco.vo.ClubJoinVO"%>
<%@page import="kr.co.eco.vo.ClubMemberVO"%>
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
	    <strong>그룹 관리 페이지!!!!!(Example)</strong>
	  </div>
	</div>
	<div class="container">
		<% 
			MemberVO member = (MemberVO)session.getAttribute("loginInfo"); 
			List<ClubMemberVO> clubJoins= (List)request.getAttribute("clubJoins");
    		ClubVO clubVO = (ClubVO)request.getAttribute("clubVO");
		%>
		<p align="right"><a href="clubPage.eco?clubNo=${clubVO.clubNo}" class="btn btn-primary">${clubVO.clubName}</a></p>
		<h2>회원정보</h2>
		<table class="table table-striped">
			<tr>
				<th>아이디</th>
				<th>메일</th>
				<th>가입날짜</th>
				<th>상태</th>
			</tr>
<%
	if(clubJoins!=null){
		for(ClubMemberVO clubJoin : clubJoins){
			if(clubVO.getClubManagerID().equals(clubJoin.getMemberID())){
		%>
			<tr>
				<td><b><%=clubJoin.getMemberID()%></b></td>
				<td><b><%=clubJoin.getMemberEmail()%></b></td>
				<td><b><%=clubJoin.getClubJoinDate()%></b></td>
				<td><b>MANAGER</b></td>
			</tr>
		<%}else{%>	
			<tr>
				<td><%=clubJoin.getMemberID()%></td>
				<td><%=clubJoin.getMemberEmail()%></td>
				<td><%=clubJoin.getClubJoinDate()%></td>
				<td>
					<%if(clubJoin.getClubAgreeOk().equals("true")) {%>
						<button class="btn btn-primary" onclick="getout('<%=clubJoin.getMemberID()%>');">내보내기</button>						
					<%}else{%>
						<button class="btn btn-primary" onclick="welcome('<%=clubJoin.getMemberID()%>');">가입승인</button>
						<button class="btn btn-primary" onclick="getout('<%=clubJoin.getMemberID()%>');">가입거절</button>						
					<%} %>
				</td>
			</tr>			
<%
		}
	}
}
%>
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

<script type="text/javascript">
function getout(name){			
	var result = confirm("클럽에서 내보내시겠습니까?");
	if(result) location.replace("clubJoinAgree.eco?clubNo=${clubVO.clubNo}&memberID="+name+"&state=1");
}
function welcome(name){		
	var result = confirm("가입 승인하시겠습니까?");
	if(result) location.replace("clubJoinAgree.eco?clubNo=${clubVO.clubNo}&memberID="+name+"&state=0");
}
</script>
</body>
</html>