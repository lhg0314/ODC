<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ODC::제작자 소개</title>
<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
	float: right;
	
/* 	border: 1px solid #eee; */
	
	width: 1200px;
	height: 90%;
	
	padding: 50px 100px;
}

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

<!-- members -->
<style type="text/css">

.member {

	display: inline-block;
	margin: 50px 0;
}

.photo {

	float: left;
	left: 30%;
	margin: 60px 0;
	margin-right: 30px;
	
}

.photo img {

	width: 200px;
	height: 200px;
	
}

.caption {

	text-align: center;
	color: black;
	font-size: 25px;
	font-weight: bolder;
}

.caption span:first-child {

	color: #8b6d8b;
}

.content {
	
 	border-top: 1px solid #ccc;
 	border-bottom: 1px solid #ccc;
 	
	float: right;
	right: 70%;
	
	width: 600px;
	padding: 30px 0;
	margin: 20px 0;
	
	text-align: center;
	color: black;
}

</style>



<!-- texts -->
<style type="text/css">

#member_introduce {
	font-size: 45px;
	font-family: batang;
  	font-weight: bolder; 
	text-align: center; 
	margin: 50px 0;
 	color: #8b6d8b;
}
#header {
	text-align: center;
}

h4 { font-weight: bold; }

span#ment {
	font-size: 17px;
}

</style>





<section>

<div id="wrapper" class="container"> 
<div id="main">
<div id="header">	
<a href="/"><img alt="logo" src="/resources/img/logo2.png" width="200px;" height="200px;"></a>
<h2 style="font-weight: bold;">제작자 소개</h2>
<hr>
</div>	
	
	
	
	
<div class="member">
    <div class="photo">
      		<img src="/resources/img/footer/introduce/inju.png" alt="inju">
        <div class="caption">
	        <span>조장</span>
	        <span>이인주</span>
        </div>
 		</div>
 		
 		<div class="content">
 			<h4>개발 담당 파트</h4>
<<<<<<< HEAD
 			<span id="ment">관리자(사업자/관리자 수익관리)<br>사업자(클래스 매출 현황)<br>사용자(예약 클래스, 장바구니, 수강 클래스, 후기 게시판)<br>footer - 서비스 이용약관, 개인정보 처리 방침<br>API - 아임포트 결제</span><br><br><br>
=======
 			<span id="ment">관리자(사업자/관리자 수익관리)<br>사업자(클래스 매출 현황)<br>사용자(예약 클래스, 장바구니, 수강 클래스, 후기 게시판,<br> 서비스 이용약관, 개인정보 처리 방침)<br>API - 아임포트 결제</span><br><br><br>
>>>>>>> sy
 			<h4>다섯 글자 소감</h4>
 			<span id="ment">다하셨네요</span><br>
 		</div>
 	</div>
 	

 	
<div class="member">
    <div class="photo">
      		<img src="/resources/img/footer/introduce/dy.png" alt="dy">
        <div class="caption">
	        <span>조원</span>
	        <span>구동영</span>
        </div>
 		</div>
 		
 		<div class="content">
 			<h4>개발 담당 파트</h4>
 			<span id="ment">관리자(클래스 검토/상세정보, 공지사항)<br>사업자(클래스 등록/검수 확인/수정)<br>사용자(지역/카테고리/기부 클래스 페이지, 인기순위 랭크, 공지사항 게시판)</span><br><br><br>
 			<h4>다섯 글자 소감</h4>
<<<<<<< HEAD
 			<span id="ment">백업은 필수</span><br>
=======
 			<span id="ment">저 다했어요</span><br>
>>>>>>> sy
 		</div>
 	</div>
 	
<div class="member">
    <div class="photo">
      		<img src="/resources/img/footer/introduce/ji.png" alt="ji">
        <div class="caption">
	        <span>조원</span>
	        <span>박주이</span>
        </div>
 		</div>
 		
 		<div class="content">
 			<h4>개발 담당 파트</h4>
 			<span id="ment">관리자(재능기부 클래스, 작가 후원 내역, 공지사항, 후기 게시판)<br>사업자(후원받은 내역, 고객 문의 내역, 후기 게시판)<br>사용자(클래스 수강후기, 클래스 문의내역, 검색)</span><br><br><br>
 			<h4>다섯 글자 소감</h4>
 			<span id="ment">많이 배웠다</span><br>
 		</div>
 	</div>
 	
<div class="member">
    <div class="photo">
      		<img src="/resources/img/footer/introduce/sy.jpg" alt="sy">
        <div class="caption">
	        <span>조원</span>
	        <span>이서연</span>
        </div>
 		</div>
 		
 		<div class="content">
 			<h4>개발 담당 파트</h4>
 			<span id="ment">관리자(회원/사업자 정보)<br>사업자(작가 프로필 조회/수정/탈퇴)<br>사용자(회원정보 조회/수정/탈퇴, 인기/최신 클래스 페이지)<br>footer - 문의사항/제작자/사이트 소개</span><br><br><br>
 			<h4>다섯 글자 소감</h4>
 			<span id="ment">아직 세미야?</span><br>
 		</div>
 	</div>
 	
<div class="member">
    <div class="photo">
      		<img src="/resources/img/footer/introduce/hj.png" alt="hj">
        <div class="caption">
	        <span>조원</span>
	        <span>이효진</span>
        </div>
 		</div>
 		
 		<div class="content">
 			<h4>개발 담당 파트</h4>
<<<<<<< HEAD
 			<span id="ment">관리자(로그인/회원가입)<br>사업자(로그인/회원가입, 아이디/비밀번호 찾기)<br>사용자(로그인/회원가입, 아이디/비밀번호 찾기,메인 헤더/베너, 클래스 예약 페이지, 장바구니 추가)<br>API - 이메인 인증/카카오 지도/카카오 주소/네이버 소셜 로그인</span><br><br><br>
=======
 			<span id="ment">관리자(로그인/회원가입)<br>사업자(로그인/회원가입, 아이디/비밀번호 찾기)<br>사용자(로그인/회원가입, 아이디/비밀번호 찾기 배너,<br>  클래스 상세 페이지,장바구니 추가, 메인 헤더)<br>API - 이메인 인증/카카오 지도/카카오 주소/네이버 소셜 로그인</span><br><br><br>
>>>>>>> sy
 			<h4>다섯 글자 소감</h4>
 			<span id="ment">너무 힘들다</span><br>
 		</div>
</div>


</div>	
</div>
</section> 

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