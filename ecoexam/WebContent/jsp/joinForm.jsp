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
	    <strong><br>SIGN UP</strong>
	  </div>
	</div>
    <div class="container">

		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script type="text/javascript">
			function joinCheck() {
				if($("#memberID").val().trim() == "") {
					$("#memberID").val("");
					alert("아이디를 입력하세요.");
					$("#memberID").focus();
					return false;
				}
				else if($("#memberPW").val().trim() == "") {
					$("#memberPW").val("");
					alert("비밀번호를 입력하세요.");
					$("#memberPW").focus();
					return false;
				}
				else if($("#email").val().trim() == "") {
					$("#email").val("");
					alert("이메일을 입력하세요.");
					$("#email").focus();
					return false;
				}
				else if($("#vCode").val().trim() == "") {
					$("#vCode").val("");
					alert("인증번호를 입력하세요.");
					$("#vCode").focus();
					return false;
				}
				return true;
			}
			
			function idCheck() {
				if($("#memberID").val().trim() == "") {
					$("#memberID").val("");
					alert("아이디를 입력하세요.");
					$("#memberID").focus();
					return;
				}
				else
				{
					var param = $("#memberID").serialize();
					$.ajax({
						url : "idCheck.eco",
						type : "get",
						dataType:"json",
						data : param,
						contentType:"application/json",
						success : function(data) {
							if(data.memberVO == "possible")
								alert("사용가능합니다.");
							else {
								$("#memberVO").append(data.memberVO.memberID);
								alert("아이디가 중복됩니다. 다시 입력하세요.");
							}
						}
					});
				}
			}
			
			function pwdCheck() {
				if($("#memberPW").val().trim() == "") {
					$("#memberPW").val("");
					alert("비밀번호를 입력하세요.");
					$("#memberPW").focus();
					return;
				}
				else if($("#memberPW").val() != $("#pwd_check").val()) {
					alert("비밀번호가 일치하지 않습니다.");
					$("#pwd_check").focus();
					return;
				} else {
					alert("비밀번호가 일치합니다.");
				}
			}
			
			function authNum() {
				var email;
				email=$("#email").val();
				
				alert(email);
		// 		alert("이메일 확인 부탁드립니다.");
				location.replace("email.eco"); 
			}
			
		</script>

		<div class="page-header">
			<h2>회원 가입 양식</h2>
		</div>
		
		<div class="well well-lg">
		<form class="form-horizontal" role="form" action="join.eco" onsubmit="return joinCheck()">
			<div class="form-group">
			    <label for="inputID1" class="col-lg-2 control-label">ID</label>
			    <div class="col-lg-8">
			    	<input type="text" class="form-control" name="memberID" id="memberID" placeholder="ID">
			    </div>
			    <div class="col-lg-2">
			      	<input type="button" class="btn btn-default" onclick="idCheck()" value="중복확인"/>
			    </div>
			</div>
			<div class="form-group">
			    <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
			    <div class="col-lg-8">
			      	<input type="password" class="form-control" name="memberPW" id="memberPW" placeholder="Password">
			    </div>
			</div>
			<div class="form-group">
			    <label for="inputPassword2" class="col-lg-2 control-label">Password Confirm</label>
			    <div class="col-lg-8">
			      	<input type="password" class="form-control" name="pwd_check" id="pwd_check" placeholder="Password 확인">
			    </div>
			    <div class="col-lg-2">
			 		<input type="button" class="btn btn-default" onclick="pwdCheck()" value="확인" />
			    </div>
			</div>
			<div class="form-group">
			    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
			    <div class="col-lg-8">
			      	<input type="email" class="form-control" name="memberEmail" id="email" placeholder="Email">
			    </div>
			    <div class="col-lg-2">
			      	<input type="button" class="btn btn-default" name="authoEmail" onclick="authNum()" value="인증번호 받기" />
			    </div>
			</div>
			<div class="form-group">
			    <label for="inputPassword1" class="col-lg-2 control-label">Verification Code</label>
			    <div class="col-lg-8">
			      	<input type="text" class="form-control" name="vCode" id="vCode" placeholder="인증번호">
			    </div>
			    <div class="col-lg-2">
			    	<input type="button" class="btn btn-default" value="인증확인" /> 
			    </div>
			</div>
			<div class="form-group">
			    <div class="col-lg-offset-2 col-lg-10">
			    	<button type="submit" class="btn btn-default">Sign in</button>
			    	<button type="reset" class="btn btn-default">Cancel</button>
			    </div>
			</div>
					
		</form>
		</div>
		</div>	

</body>
</html>