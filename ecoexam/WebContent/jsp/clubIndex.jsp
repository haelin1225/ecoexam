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
		</form>
	
		<br>
		<h2>BEST 스터디그룹</h2>
		<div class="well well-lg">
			<div class="row">
				<div class="col-sm-6 col-md-3">
			    	<a href="#" class="thumbnail">
			      		<img data-src="holder.js/100%x180" alt="image">
			    	</a>
			  	</div>
			  	<div class="col-sm-6 col-md-3">
			    	<a href="#" class="thumbnail">
			      		<img data-src="holder.js/100%x180" alt="image">
			    	</a>
			  	</div>
			  	<div class="col-sm-6 col-md-3">
			    	<a href="#" class="thumbnail">
			      		<img data-src="holder.js/100%x180" alt="image">
			    	</a>
			  	</div>
			  	<div class="col-sm-6 col-md-3">
			    	<a href="#" class="thumbnail">
			      		<img data-src="holder.js/100%x180" alt="image">
			    	</a>
			  	</div>
			</div>
		</div>
	</div>	
  	<a href="clubCreateForm.eco">클럽 만들기</a>
</body>
</html>
