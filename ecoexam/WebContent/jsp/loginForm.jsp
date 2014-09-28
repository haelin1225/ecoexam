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
	    <strong>LOGIN</strong>
	  </div>
	</div>
    <div class="container">

      <form class="form-signin" action="login.eco" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="memberID" placeholder="ID" required autofocus>
        <input type="password" class="form-control" name="memberPW" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
	</div>

</body>
</html>