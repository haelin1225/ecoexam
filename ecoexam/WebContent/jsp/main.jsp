<%@page import="kr.co.eco.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Justified Nav Template for Bootstrap</title>
  </head>
  <body>

	<!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
            <img alt="" src="./img/GreenIT.jpg" class="img-circle" width=250 height=250>
              <h1>Green IT 실현!</h1>
              <p>시험지가필요없습니다!</p>
              
            </div>
          </div>
        </div>
        <div class="item">
          <img src="data:image/gif;base64,R0lGODlhAQABAIAAAGZmZgAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
            <img alt="" src="./img/web.jpg" class="img-circle" width=250 height=250>

              <h1>쉬운 웹페이지 제작 시험!</h1>
              <p>웹페이지에서 쉽게 제작하세요!</p>
              
            </div>
          </div>
        </div>
        <div class="item">
          <img src="data:image/gif;base64,R0lGODlhAQABAIAAAFVVVQAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
            <img alt="" src="./img/excell.jpg" class="img-circle" width=250 height=250>
            
              <h1>쉬운 성적관리!</h1>
              <p>시험성적을 엑셀로 관리하세요!</p>
              
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
	

    <div class="container">

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>공지사항</h2>
          <p class="text-danger">공지사항.</p>
          <p>1.컨닝금지<br>
          	 2.시간엄수</p>
          
        </div>
        <div class="col-lg-4">
          <h2>New Test</h2>
          <p>새로운시험 확인! </p>
          
       </div>
        <div class="col-lg-4">
          <h2>Best Study Group!</h2>
          <p>이번 베스트 스터디 그룹!</p>
          
        </div>
      </div>
   	</div>   

 </body>
 </html>