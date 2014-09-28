<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>club create</title>
</head>
<body>
<form action="clubCreate.eco" onsubmit="javascript: return checkAll();" method="post">
클럽 이름 : <input type="text" id="newName" name="clubName" />
<br>
<input type="submit" value="클럽제작" />
</form>
<script type="text/javascript">
	function checkAll(){

		<c:forEach var="clubName" items="${clubNameList}" varStatus="loop">
			if($("#newName").val()==="${clubName}"){							
				$("#newName").val('');
				alert("이미 있는 이름입니다.");
				return false;
			}
		</c:forEach>
		return true;
	}
</script>
</body>
</html>