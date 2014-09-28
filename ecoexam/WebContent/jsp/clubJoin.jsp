<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${clubVO.clubName}</title>
</head>
<body>
<script type="text/javascript">
var sec = 3;
function countdown(){
	if(sec==0){clearInterval(s);}
	else{
		sec--;		
	}
	
	document.getElementById("count").innerHTML=sec;
}
var s = setInterval(countdown,1000); //1초 

setTimeout("location.href='clubPage.eco?clubNo=${clubVO.clubNo}'",3000);
</script>
${member.memberID}님, ${clubVO.clubName}에 가입 신청 완료 되었습니다. <br>
<p>
클럽 관리자의 승인을 기다려 주시기 바랍니다.<br>
<p>
<span id="count">3</span>초 후 ${clubVO.clubName}페이지로 이동합니다.

</body>
</html>