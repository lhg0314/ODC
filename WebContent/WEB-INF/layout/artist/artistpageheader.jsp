<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<!-- font -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>


<style type="text/css">

#wrapper {
	width: 1200px;
 	height: 1000px;
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
	height: 700px;
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

#userbox_cont img:first-child {
    width: 100px;
    height: 100px;
}

#userbox_cont img:nth-child(2) {
    width: 170px;
    height: 55px;
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
	padding: 20px;

}


#class_upload_notice span:first-child {
	
	font-size: 25px;
	font-weight: bold;

}


</style>


<!-- button -->
<style type="text/css">

.class_button {
  background-color: thistle; 
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
  background-color: #b798b7;
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
			<img src="/resources/img/mini.jpg" />		
			<img src="/resources/img/grade/artistgrade.PNG" />		
			<span>홍길동 님 </span>
		</div>
	</div>
	
	<ul class="navi">
		<li class="group">
		    <div class="title">작가 프로필</div>
		    <ul class="sub">
		        <li><a href="#">작가 프로필 조회 및 수정</a></li>
		        <li><a href="#">작가 탈퇴</a></li>
		    </ul>
		</li>
	</ul>
		
	<ul class="navi">
		<li class="group">
		    <div class="title">클래스</div>
		    <ul class="sub"> 
		        <li><a href="#">클래스 등록</a></li>
		        <li><a href="#">클래스 검수 확인</a></li>
		        <li><a href="#">클래스 관리</a></li>
		        <li><a href="#">클래스 매출 현황</a></li>
		    </ul>
		</li>
	</ul>
		
	<ul class="navi">
		<li class="group">
		    <div class="title">기부 및 후원</div>
		    <ul class="sub">
		        <li><a href="#">재능 기부 클래스 등록</a></li>                
		        <li><a href="#">재능 기부 클래스 검수</a></li>                
		        <li><a href="#">후원 받은 내역</a></li>                
		    </ul>
		</li>
	</ul>
	
	<ul class="navi">
		<li class="group">
		    <div class="title">게시판</div>
		    <ul class="sub">
		        <li><a href="#">고객 문의 내역</a></li>                
		        <li><a href="#">후기 게시판</a></li>                
		    </ul>
		</li>
	</ul>
	    
</div>

<div id="artistpage">ARTIST PAGE</div>
