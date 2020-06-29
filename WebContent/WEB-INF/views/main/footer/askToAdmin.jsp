<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ODC::관리자문의</title>
</head>


<style type="text/css">

#wrapper {
	width: 1200px;
 	height: 90%;
 	margin-top: 20px;
}

</style>


<!-- main -->
<style type="text/css">

#main {
	display: inline-block;
	
	width: 1200px;
	height: 90%;
	
    padding: 0 200px;
}

#header {
	text-align: center;
}

#logo { text-align: center; }

#loginFooter {text-align: center; }

#loginFooter > a:visit{
	text-decoration: none;
	color: black;
}
#loginFooter > a:link{
	color: black;
}

#loginFooter > a{
	color: black;
}

</style>


<!-- 본문 -->
<style type="text/css">

#title {

	text-align: center;
	color: #999;
	font-size: 25px;
  	font-family: serif;  
 	font-style: italic; 
/*  	font-weight: bold;  */

}
#title2 {

	text-align: center;
	color: #333;
	font-size: 15px; 

}

div#kakao { 

	text-align: center; 
	width: 33%;
	float: left;
}

img#kakaologo {
	
    width: 130px;
    height: 130px;
    margin: 30px 0 8px;
}

#kakao span { 

	color: black;
	font-size: 20px;
	font-weight: bold;
	border: 2px solid black;
	border-radius: 25px;
	padding: 10px;
}

#kakao a:hover { text-decoration: none; }

#kakao p {

	color: #333;
	font-size: 15px;
	
}


div#email { 

	text-align: center; 
	width: 37%;
	float: left;
}

img#emaillogo {
	
    width: 160px;
    height: 155px;
    margin: 20px 0 13px;	
}

#email span { 

	color: black;
	font-size: 20px;
	font-weight: bold;
	border: 2px solid black;
	border-radius: 25px;
	padding: 10px;
}

#email a { 
	text-decoration: none; 
	color: black;
}

#email p {

	color: #333;
	font-size: 15px;
}

div#call { 

	text-align: center; 
	width: 30%;
	float: right;
	padding: 20px 0;
	margin: 10px 0;
}

img#calllogo {
	
    width: 110px;
    height: 117px;
    margin: 9px 0 12px;
}

#call span { 

	color: black;
	font-size: 20px;
	font-weight: bold;
	border: 2px solid black;
	border-radius: 25px;
	padding: 10px;
}

</style>





<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<body>






<section>

<div id="wrapper" class="container"> 
	<div id="main">
	<div id="header">	
		<a href="/"><img alt="logo" src="/resources/img/logo2.png" width="200px;" height="200px;"></a>
		<h2 style="font-weight: bold;">관리자에게 문의하기</h2>
		<hr>
	</div><!-- header end -->
		
		<br><br><br>
	
		<div id="title">❝  ODC를 이용하시면서 궁금한 점이 있으신가요? ❞</div><br>
		<div id="title2">고객센터 운영시간&nbsp;|&nbsp;월-금  9:00-18:00</div><br><br><br>
	
	
	
		<div id="kakao">
			<a href="https://open.kakao.com/o/sts6uKic" target="_blank" >
				<img id="kakaologo" alt="kakao" src="/resources/img/footer/kakaoLogo.png" 
					title="클릭하시면 PC 카카오톡 오픈채팅으로 이동합니다"/>
			</a>
			<br><br>
			<a href="https://open.kakao.com/o/sts6uKic" target="_blank" 
				title="클릭하시면 PC 카카오톡 오픈채팅으로 이동합니다">
				<span>카카오톡 문의</span>
			</a>
				<br><br>
				<hr>
				<h5>카카오톡 오픈채팅에</h5>
				<h5>ODC를 검색하세요</h5>
				<hr>
		</div>
		
	
		
		<div id="email">
			<a href="mailto:abc12345@gmail.com" title="클릭하시면 메일 서비스로 이동합니다">
				<img id="emaillogo" alt="email" src="/resources/img/footer/emailLogo.png"/>
			</a>
			<br>
			<a href="mailto:abc12345@gmail.com" title="클릭하시면 메일 서비스로 이동합니다">
				<span>이메일 문의</span>
			</a>
			<br><br>
			<hr>
			<h5>고객센터 이메일</h5>
			<h5>abc12345@gmail.com</h5>
			<hr>
		</div>
		
		
		
		<div id="call">
			<img id="calllogo" alt="call" src="/resources/img/footer/callLogo.png" />
			<br><br>
			<span>전화 문의</span><br><br>
			<hr>
			<h5>고객센터 연락처</h5>
			<h5>010-1234-5678</h5>
			<hr>
		</div>



	</div><!-- main end -->
</div><!-- wrapper end -->

</section> 

<br>

<hr> 
<div id="loginFooter" >	
<a href="/footer/termsofservice" class="aTagNone left">서비스 이용약관</a>&nbsp;&nbsp;
<a href="/footer/privacypolicy" class="aTagNone">개인정보 처리방침</a>&nbsp;&nbsp;
<a href="/footer/memberIntroduce" class="aTagNone">제작자 소개</a>&nbsp;&nbsp;
<a href="/footer/siteIntroduce" class="aTagNone">사이트 소개</a>&nbsp;&nbsp;
<a href="/footer/askToAdmin" class="aTagNone">문의하기</a>&nbsp;&nbsp;
<p>&copy; ODC</p>
</div>
<br><br> 

</body>
</html>  