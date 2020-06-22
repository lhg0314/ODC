<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OneDayClass</title>
<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- w3schools css 라이브러리 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        
<!-- 사이드 메뉴바 -->
<style type="text/css">
body {
    margin:20px auto;
    padding: 0;
    font-family:sans-serif; 
}
ul#navi {
    width: 200px;
    text-indent: 10px;
    border: 1px solid #ccc;
}
ul#navi, ul#navi ul {
    margin:0;
    padding:0;
    list-style:none;
}
li.group {
    margin-bottom: 3px;
}
li.group div.title {
    height: 35px;
    line-height: 35px;
    background: thistle;
    cursor:pointer;
    font-weight: bold;
}
ul.sub li {
    margin-bottom: 2px;
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
    color:#000;
}
ul.sub li:hover {
    background:#ecdfec;
}
</style>

<style type="text/css">
#sidenav {
/* 	background-color: blue; */
 	width: 200px;
 	height: 100%;
 	float: left;

}

#main{
 	width: 960px;
 	height: 100%;
 	float: right;
/*  border: 1px solid green */
}

</style>


<style type="text/css">
.aTagStyleNone {
    text-decoration : none;
    color : black;
}

#wrapper{
   width: 1200px;
   margin: 20px auto;

/*    border: 1px solid #ccc; */

}

</style>
</head>
<body>

<div id="wrapper"> <!-- 가운데 오게 하기  -->
<a href="/admin/main"><h3>관리자 페이지</h3></a>
<hr>

<div id="sidenav">
<ul id="navi">
        <li class="group">
            <div class="title">회원 관리</div>
            <ul class="sub">
                <li><a href="/admin/userlist">회원 정보</a></li>
            </ul>
        </li>
        <li class="group">
            <div class="title">사업자 관리</div>
            <ul class="sub">
                <li><a href="/admin/artlist">사업자 정보</a></li>
            </ul>
        </li>
        <li class="group">
            <div class="title">클래스 관리</div>
            <ul class="sub">              

                <li><a href="/admin/class/check" id="SnvClassCheck">클래스 검토</a></li>                
                <li><a href="/admin/class/post" id="SnvClassPost">클래스 정보</a></li>                
            </ul>
        </li>
        <li class="group">
            <div class="title">수익 관리</div>
            <ul class="sub">
                <li><a href="/admin/artsales/list">사업자 수익 관리</a></li>                
                <li><a href="/admin/adminsales/list">관리자 수익 관리</a></li>    
            </ul>
        </li>   
        <li class="group">
            <div class="title">기부 관리</div>
            <ul class="sub">
                <li><a href="/admin/talent">재능기부 클래스</a></li>                
                <li><a href="/admin/donation">작가 후원 내역</a></li>    
            </ul>
        </li> 
        <li class="group">
            <div class="title">게시판 관리</div>
            <ul class="sub">
                <li><a href="#">공지사항 관리</a></li>                
                <li><a href="#">후기게시판 관리</a></li>    
            </ul>
        </li> 
    </ul>
</div>


<div id="main">