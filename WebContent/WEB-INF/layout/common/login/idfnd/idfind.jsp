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

#actorChk{
	margin: 20px;
}

#loginInfo input{
	font-size: 14px;
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
.inputstyle{
	width: 75%;
}
.labelstyle{
	width: 20%;
	margin-left: 10px;
}


#chk{
	text-align: left;
	padding-left: 0;
	margin: 0;
}
</style>
</head>
<body>

<div id="wrapper">
<div id="loginbox">

<div id="loginLogoImg">
<a href="/"><img id="loginLogo" alt="logo" src="/resources/img/logo2.png"></a>
</div>

<div>
<h1>아이디 찾기</h1>
</div>
<br><br>

<form action="#" method="post" class="form-horizontal">
<label id="chk" class="col-xs-3 control-label">회원 구분</label>
<div id="actorChk">
 <label class="radio-inline">
  <input type="radio" name="loginActor" id="userChk" value="user"> 일반 회원
 </label>
 <label class="radio-inline">
  <input type="radio" name="loginActor" id="artistChk" value="artist"> 사업자 회원
 </label>
</div>
<div id="loginInfo">
 <div class="form-group">
    <label for="name" class="col-xs-3 control-label labelstyle">이름</label>
    <div class="col-xs-8 inputstyle">
      <input type="text" class="form-control" id="name" name="name">
    </div>
  </div>
 <div class="form-group">
    <label for="email" class="col-xs-3 control-label labelstyle">이메일</label>
    <div class="col-xs-8 inputstyle">
      <input type="email" class="form-control" id="email" name="email">
    </div>
  </div>
<br>

</div>
  <button type="submit" id="btnLogin">확인</button>
</form>



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