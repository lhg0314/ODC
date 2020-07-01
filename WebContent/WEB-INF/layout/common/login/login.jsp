<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/httpRequest.js" ></script>

<script type="text/javascript">

var opt=$('input[name=loginActor]:checked').val();
function logincheck(){
	
	var id=document.getElementById("id").value;
	var pw=document.getElementById("pw").value;
	opt=$('input[name=loginActor]:checked').val();
	 

	
	var param="id="+id+"&pw="+pw+"&opt="+opt;
	console.log(param)
	sendRequest("POST","/member/login",param,ajaxFromServer);

	
}


function findid(){
	
	opt=$('input[name=loginActor]:checked').val();
	console.log(opt)
	if(opt=="user"){
		location.href="/find/userid"
	}else if(opt=="artist"){
		location.href="/find/artid"
	}
	
	
}
function findpw(){
	opt=$('input[name=loginActor]:checked').val();
	console.log(opt)
	
	if(opt=="user"){
		location.href="/find/userpw"
	}else if(opt=="artist"){
		location.href="/find/artpw"
	}
	
}

function ajaxFromServer(){
	if(httpRequest.readyState==4){//DONE,응답완료
		if(httpRequest.status==200){//OK
			var resultText = httpRequest.responseText;
			if(resultText == 0){//아이디가 없을때
				
				document.getElementById("msg").innerHTML ="ID또는 비밀번호가 틀립니다";
			} 
			else if(resultText == 1){ //이메일 전송 완료
				console.log("회원가입 성공")
				console.log(opt)
				if("user"==opt){
					location.href="/main";
				}else if("artist"==opt){
					location.href="/artist/main";
				}else if("admin"==opt){
					location.href="/admin/main";
				}
			}
			
		}else{
			console.log("AJAX요청/응답 에러")
		}
	}
}

</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#pw").keydown(function(e) {
		if( e.keyCode == 13 ) {
			$("#btnLogin").click();
		}
	});
})

</script>
<style type="text/css">
#wrapper{
	width: 1200px;
	margin: 20px auto;

/* 	border: 1px solid #ccc; */
	font-family:sans-serif;
	
	text-align: center;
}

#loginbox{
	width: 30%;
/* 	border: 1px solid #ccc; */
	margin: 0 auto;
}

#loginLogo{
	width: 300px;
}

#btnLogin{
	width: 100%;
	height: 40px;	
	border: none;
	background-color: thistle; 
	border-radius: 22px;
	color: rgb(125, 91, 125);
	font-weight: bold;
}

#naverLogin{
	width: 100%;
	height: 40px;	
	border: none;
	background-color: #85D638; 
	
}
#actorChk{
	margin: 10px;
}

#loginInfo input{
	font-size: 14px;
}

.hr{
 background-color: #bbb;
 height: 1px;
 width: 150px;
 display: inline-block;
 margin-bottom: 5px;
}

#or{
	margin: 10px;
	display: inline-block;
	color: #bbb;
}


#find > ul{
	list-style: none;
	padding:0;
	white-space: nowrap;
	align-content: center; 
	width: 100%;
	margin-top: 20px;
}

#find > ul > li{
	display: inline-block;
	line-height: 30px;
	margin: 0 8px;
}

#dl{
	vertical-align: center;
	margin: 13px 0;
}
#find a{
	text-decoration: none;
	color: black;
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
</head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<body>

<div id="wrapper">
<div id="loginbox">

<div id="loginLogoImg">
<a href="/"><img id="loginLogo" alt="logo" src="/resources/img/logo2.png"></a>
</div>

<form action="/member/login" method="post">

<div id="actorChk">
 <label class="radio-inline">
  <input type="radio" name="loginActor"  value="user" checked="checked"> 일반 회원
 </label>
 <label class="radio-inline">
  <input type="radio" name="loginActor" value="artist"> 사업자 회원
 </label>
  <label class="radio-inline">
  <input type="radio" name="loginActor" value="admin"> 관리자
 </label>
</div>
<div id="loginInfo">
 <div class="form-group">
    <input type="text" class="form-control input-lg" name="id" id="id" placeholder="아이디">
  </div>
  <div class="form-group">
    <input type="password" class="form-control input-lg" name="pw" id="pw" placeholder="비밀번호">
  </div>
</div>
<div id="msg"></div>
</form>
  <button onclick="logincheck()" id="btnLogin">로그인</button>



<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "FTjpSVA3C4iv0BRuSLRA",
			callbackUrl: "http://localhost:8088/callback.jsp",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
</script>
<!-- // 네이버아이디로로그인 초기화 Script -->

<div id="find">
<ul>
	<li><a href="javascript:findid();"  class="ack">아이디 찾기</a></li>
	<li>&nbsp;|&nbsp;</li>
	<li ><a href="javascript:findpw();"  class="ack">비밀번호 찾기</a></li>
	<li>&nbsp;|&nbsp;</li>
	<li><a href="/user/join" class="ack">회원가입</a></li>
</ul>
</div>


</div>
<br><br><br><br><br><br>
<hr>

<div id="loginFooter" >
<a href="/footer/termsofservice" class="aTagNone left">서비스 이용약관</a>&nbsp;&nbsp;
<a href="/fooer/privacypolicy" class="aTagNone">개인정보 처리방침</a>&nbsp;&nbsp;
<a href="/fooer/memberIntroduce" class="aTagNone">제작자 소개</a>&nbsp;&nbsp;
<a href="/fooer/siteIntroduce" class="aTagNone">사이트 소개</a>&nbsp;&nbsp;	
<p>&copy; ODC</p>
</div>

<br><br>



</div>

</body>
</html>