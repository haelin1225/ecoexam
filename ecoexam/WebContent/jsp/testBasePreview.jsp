<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script> 
<script src="http://bxslider.com/lib/jquery.bxslider.js"></script>
</head>
<%
	int fileCount = (Integer)request.getAttribute("fileCount");
	System.out.println("View fileCount : " + fileCount);
	
%>

<body>

	<div class="container">   
	<ul id="slider1">
 <% 	
	for(int i=0; i<fileCount; i++) {
%> 
	<li><img width="80%" height="50%" src="./upload/${testVO.testName}/exam0<%=i%>.jpg" alt="C:/sk/workspace/ecoexam2/WebContent/upload/${testVO.testName}/exam0<%=i%>.jpg"/></li>
	 
<%
	}
%>	 
	
<%-- 		<li><img src="./upload/${testVO.testName}/exam01.jpg" /></li> --%>
<%-- 		<li><img src="./upload/${testVO.testName}/exam02.jpg" /></li> --%>
<%-- 		<li><img src="./upload/${testVO.testName}/exam03.jpg" /></li> --%>
<%-- 		<li><img src="./upload/${testVO.testName}/exam04.jpg" /></li> --%>
	</ul>
	</div>
	
	<script type="text/javascript">
           // 슬라이더 생성   
           var slider1 = $('#slider1').bxSlider({
                controls:false
            });
    
    </script>

</body>
</html>