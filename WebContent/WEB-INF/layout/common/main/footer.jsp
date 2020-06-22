<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

#info1 {text-align: center;}
#info3 {text-align: left; font-size: small; }
#info4 {text-align: left; font-size: small; }
#info5 {font-size: 35px; color: black; }

#wrap {
	border:  1px solid #ccc;

	width: 1200px;
 	
	/* 외부정렬 */
 	margin: 0 auto; 

	/* <table>처럼 레이아웃 설정됨 */
	display: table;
	
	/* 내용물(table-cell)의 크기가 일정하도록 설정 */
	table-layout: fixed;
	
	border-right:none;

	border-left:none;
	
	border-top:none;

	border-bottom:none;
}

#wrap > div {
	width: 25%; /* 4개 */
	
	height: 130px;
	
	/* 테이블의 내용물(tabl-cell ,td, th)처럼 레이아웃 설정됨 */
	display: table-cell;
	
	/* table-cell, inline에서 사용 가능  */
	
	/* 수직 정렬 : 중앙 */
	vertical-align: middle;
	
	/* 내부 정렬 : 가운데 */
	text-align: center;  
}

.aTagNone {
	text-decoration: none;
	color: black;
}

.aTagNone:visit{
   text-decoration: none;
   color: black;
}

.aTagNone:hover{
   text-decoration: none;
   color: black;
}

.left{
	text-align: left;
}

</style>
 
<div class="wrappermain">
<br>
<hr>

<div id="info1" >	
<a href="/footer/termsofservice" class="aTagNone left">서비스 이용약관</a>&nbsp;&nbsp;
<a href="/fooer/privacypolicy" class="aTagNone">개인정보 처리방침</a>&nbsp;&nbsp;
<a href="/fooer/memberIntroduce" class="aTagNone">제작자 소개</a>&nbsp;&nbsp;
<a href="/fooer/siteIntroduce" class="aTagNone">사이트 소개</a>&nbsp;&nbsp;
</div>

<br>

<div id="wrap" >

<div id="info2" >
<img src="/resources/img/logo2.png" width="200px;" height="200px;">
</div>

<div id="info3" >
(주) 오디씨<br><br>
전화 010-1234-5789<br><br>
주소 서울 강남 KH빌딩<br><br>
사업자 번호 012 - 3456 - 7890
</div>

<div id="info4" >
고객센터   월-금 ( 9:00- 18:00)<br><br>
카카오톡 플러스 친구  오디씨<br><br>
메일  abc12345@gamil.com
</div>

<div id="info5" >
<div class="glyphicon glyphicon-phone" onclick="location.href='#';"></div>
<div class="glyphicon glyphicon-envelope" onclick="location.href='#';"></div>
<div class="glyphicon glyphicon-map-marker" onclick="location.href='#';"></div>
</div>

</div>
</div>
</body>
</html>