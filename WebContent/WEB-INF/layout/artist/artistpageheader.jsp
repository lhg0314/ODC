<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- font -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>


<style type="text/css">

#wrapper {
	width: 1200px;
 	height: 100%;
 	margin-top: 20px;
}

</style>



<!-- sidenav -->
<style type="text/css">

#sidenav {
	display: inline-block;
	float: left;

/* 	border: 1px solid #ccc; */
	
	width: 25%;
	height: 100%;
}

#userbox {
	width: 200px;
	height: 200px;
	border: 1px solid #ccc;
	color: black;
	
	margin: 20px auto;
	
	display: table;
}

#userbox_cont {
	display: table-cell;
	padding: 10px;
	
	text-align: center;
	vertical-align: middle;
	font-size: 15px;
	font-weight: bold;
}

/* #userbox_cont img:first-child { */
/*     width: 100px; */
/*     height: 100px; */
/* } */

#userbox_cont img{
    width: 170px;
    height: 55px;
    margin: 20px 0;
}

</style>



<!-- main -->
<style type="text/css">

#main {
	display: inline-block;
	float: right;
/* 	border: 1px solid #ccc; */
	width: 75%;
/* 	height: 90%; */
	
	padding: 0 20px;
/* 	margin: 20px 0; */
}

.row { margin: 10px 0; }


#table  {
	width: 100%;
	text-align: center;
	margin: 10px 0;
	font-size: 14px;
}
 
#table th {
	background: thistle;
	text-align: center;
}

#table tr:hover { background-color:#f5f5f5; }

#table tr.table_content {

	  cursor:pointer;
}

</style>



<!-- 메뉴바 style -->
<style type="text/css">

ul.navi, ul.navi ul {
    margin:0;
    padding:0;
    list-style:none;
}

ul.navi {
    width: 200px;
    text-indent: 10px;
/*     border: 1px solid #ccc; */
    margin: 20px auto;
}

li.group div.title {
    height: 35px;
    line-height: 35px;
    border-bottom: 1px solid #ccc;
/*     cursor:pointer; */
    
    font-weight: bold;
    font-size: 16px;
}

ul.sub li {
    height:35px;
    line-height:35px;
    background:white;
    cursor:pointer;
}

ul.sub li a {
    display: block;
    width: 100%;
    height:100%;
    
    text-decoration:none;
    color: #333; 
    font-size: 14px;
}

 ul.sub li:hover a { color: #e7717d; }

</style>



<!-- texts -->
<style type="text/css">

#artistpage {

	font-size: 30px;
	font-family: serif;
 	font-weight: bolder;
	text-align: center; 
	margin: 20px 0;
 	color: #8b6d8b;
}

#artistpage a {

	text-decoration: none;
 	color: #8b6d8b;
}

#viewmore { 

	float:right; 
	text-decoration: none;
	color: #999;
    font-size: 14px;
}

#boardtitle {

    font-size: 16px;
    font-weight: bold;
}

#class_upload_notice {

	text-align: center;
	border: 1px solid #ccc;
	border-radius: 20px;
	padding: 50px 120px;
}

#ctitle {
	
	font-size: 26px;
	font-weight: bold;
/*  	font-style: italic;  */
/* 	background: thistle; */
	padding: 3px;
	color: #845f84;
}

#class_upload_notice_content {

	text-align: left;
	font-size: 15px;
}

#class_upload_notice_content p {

	font-size: 14px;
    color: #383839d4;
}


</style>


<!-- button -->
<style type="text/css">

.class_button {
  background-color: #b798b7; 
  color: white;
  border: none;
  
  text-align: center;
  text-decoration: none;
  font-size: 17px;
  font-weight: bold;
  
  display: inline-block;
  margin: 4px 2px;
  padding: 16px 32px;
  cursor: pointer;
  
}

.class_button:hover {
  background-color: #8c7599;
  color: white;
}

#btn {

	text-align: center;
}

</style>



<section>

<div id="wrapper" class="container"> <!-- 전체를 감싸는 div -->

<div id="sidenav">

	<div id="userbox">
		<div id="userbox_cont">
			<img src="/resources/img/grade/artistgrade.PNG" />		
			<span>${artid } 님 </span>
		</div>
	</div>
	
	<ul class="navi">
		<li class="group">
		    <div class="title">클래스</div>
		    <ul class="sub"> 
		        <li><a href="/artist/class/app" id="SvnclassApp">클래스 등록</a></li>
		        <li><a href="/artist/class/check" id="SvnClassCheck">클래스 검수 확인</a></li>
		        <li><a href="/artist/class/manage" id="SvnClassManage">클래스 관리</a></li>
		        <li><a href="/artistpage/class/sales">클래스 매출 현황</a></li>
		    </ul>
		</li>
	</ul>
		
	<ul class="navi">
		<li class="group">
		    <div class="title">후원</div>
		    <ul class="sub">               
		        <li><a href="/artist/donation">후원 받은 내역</a></li>                
		    </ul>
		</li>
	</ul>
	
	<ul class="navi">
		<li class="group">
		    <div class="title">게시판</div>
		    <ul class="sub">
		        <li><a href="/artist/asklist">고객 문의 내역</a></li>                
		        <li><a href="/artist/reviewlist">후기 게시판</a></li>                
		    </ul>
		</li>
	</ul>
	
	<ul class="navi">
		<li class="group">
		    <div class="title">작가 프로필</div>
		    <ul class="sub">
		        <li><a href="/artist/info">작가 프로필 조회 및 수정</a></li>
		        <li><a href="/artist/leave">작가 탈퇴</a></li>
		    </ul>
		</li>
	</ul>
		
	    
</div>

<div id="artistpage"><a href="/artist/artistpage">ARTIST PAGE</a></div>
