<%@page import="kr.co.eco.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Justified Nav Template for Bootstrap</title>
	 
    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./bootstrap/ecoexam.css" rel="stylesheet">

	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./../assets/js/ie-emulation-modes-warning.js"></script>
    
	<!-- google web fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;subset=latin,latin-ext,cyrillic-ext' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700,800,900,200,100' rel='stylesheet' type='text/css'>

  </head>
<body>
	<%
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
	%>
  <header class="header-wrapper">
  	<div class="navbar navbar-default navbar-fixed-top">
  		<div class="container">
				<div class="col-md-2">
					<a class="navbar-brand" href="main.eco"><img
						src="./img/EcoExam.png" alt="" width=140 height=120
						class="img-rounded"></a>
				</div>
				<div class="col-md-10">
					<div class="container">
						<ol class="breadcrumb">
							<li><a href="main.eco">Home</a></li>
							<%
								if (member != null) {
							%>
							<li><%=member.getMemberID()%> 님</li>
							<li><a href="logout.eco">Logout</a></li>
							<%
								} else {
							%>
							<li><a href="loginForm.eco">Login</a></li>
							<li><a href="joinForm.eco">Sign Up</a></li>
							<%
								}
							%>
						</ol>
					</div>
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>

						</div>
						<div class="navbar-collapse collapse">
							<ul class="nav nav-pills navbar-nav navbar-right">
								<li><a href="ecoexam.eco">Eco Exam이란?</a></li>
								<% if(member != null && member.getMemberID().equals("admin")) { %>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">문제제작<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="testCreateIndex.eco">문제검색</a></li>
										<li><a href="testCreateForm.eco">문제제작</a></li>
										<li><a href="testBaseForm.eco">기본문제제작</a></li>
									</ul></li>
								<% }  else { %>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">문제제작<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="testCreateIndex.eco">문제검색</a></li>
										<li><a href="testCreateForm.eco">문제제작</a></li>
									</ul></li>
								<% } %>
								<li><a href="clubIndex.eco">스터디그룹</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">커뮤니티<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="communityIndex.eco">INDEX</a></li>
										<li><a href="boardList.eco?boardNo=1">공지사항</a></li>
										<li><a href="boardList.eco?boardNo=2">자유게시판</a></li>
										<li><a href="#">FAQ</a></li>
										<li><a href="boardList.eco?boardNo=4">Q&A</a></li>
										<li><a href="#">실시간 채팅</a></li>
									</ul>
								</li>
								<li><a href="myPageIndex.eco">마이페이지</a></li>
							</ul>
						</div>
						<!--/.nav-collapse -->
					</div>
				</div>
			</div>
		</div>
  </header>
	<%
		String str = request.getParameter("nextPage");
		System.out.println("nextPage : " + str);
	%>
	<jsp:include page="${param.nextPage}"></jsp:include>
	
	<footer class="footer-wrapper">
		<!-- Site footer -->
		<div class="footer">
			<p>&copy;Copyrightⓒ 2014 by Eco Exam Company. All rights
				reserved.
		</div>
	</footer>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./bootstrap/assets/js/ie10-viewport-bug-workaround.js"></script>

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="./bootstrap/dist/js/bootstrap.js"></script>

	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<script src="./bootstrap/dist/js/respond.js"></script>
</body>
</html>