<%@page import="kr.co.eco.vo.ClubVO"%>
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
		    <strong>스터디 그룹</strong>
		  </div>
		</div>
		<div class="container">
		
			<h2>GROUP SEARCH</h2>
			<form class="form-inline" role="form" action="clubSearch.eco">
				<div class="input-group">
					<input type="text" name="searchStr" class="form-control"  placeholder="study group name">
					<span class="input-group-btn">
		        		<button class="btn btn-default" type="submit">Search</button>
		      		</span>
				</div>
			
				<br><br><h2>검색 결과</h2>
				<%
					List<ClubVO> list = null;
					list = (List<ClubVO>)request.getAttribute("clubSearchList");
    				System.out.println(list);
						
					if(list !=null) { %>
						<table class="table table-striped">
						<tr>
							<th>그룹 번호</th>
				    		<th>그룹 이름</th>
				    		<th>관리자</th>
				    		<th>그룹 가입</th>
						</tr>
					<%	for(ClubVO clubVO : list) { %>	
							<tr>
								<td><%= clubVO.getClubNo() %></td>
								<td><a href="clubPage.eco?clubNo=<%=clubVO.getClubNo()%>"><%= clubVO.getClubName() %></a></td>
								<td><%= clubVO.getClubManagerID() %></td>
								<td> 가능 </td>
							</tr>  
					<% 	} %>
						</table>
				<%	} else { %>
						<h3>'${searchStr}'에 대한 검색결과가 없습니다.</h3>
				<%  } %>
			</form>
		</div>
	</body>
</html>
