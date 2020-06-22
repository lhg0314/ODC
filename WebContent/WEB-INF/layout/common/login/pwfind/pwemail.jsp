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

/*    border: 1px solid #ccc; */
   font-family:sans-serif;
   
   text-align: center;
}

#loginbox{
   width: 30%;
/*    border: 1px solid #ccc; */
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

#joinemailbox{
   width: 100%;
   height: 250px;   
   border: none;
/*    background-color: thistle;  */
   border-radius: 22px;
/*    color: rgb(125, 91, 125); */
   font-weight: bold;
   border: 1px solid #ccc;
   
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
<body>

<div id="wrapper">
<div id="loginbox">

<div id="loginLogoImg">
<a href="/"><img id="loginLogo" alt="logo" src="/resources/img/logo2.png"></a>
</div>


<div id="joinemailbox">
<br><br><br>
<span>아래의 이메일로 비밀번호가 발송되었습니다.</span>
<br><br><br>
<span style="color:#e7717d; font-size: large;">abc1234@gmail.com</span>
<br><br><br>
<span>비밀번호 확인후 로그인 바랍니다.</span>
<br><br>

</div>
<br><br>
<button type="submit" id="btnLogin" onclick="location.href='/'">로그인</button>



</div>
<br><br><br><br><br><br>
<hr>

<div id="loginFooter" >
<a href="/footer/termsofservice" class="aTagNone left">서비스 이용약관</a>&nbsp;&nbsp;
<a href="/fooer/privacypolicy" class="aTagNone">개인정보 처리방침</a>&nbsp;&nbsp;
<a href="/fooer/memberIntroduce" class="aTagNone">제작자 소개</a>&nbsp;&nbsp;
<a href="/fooer/siteIntroduce" class="aTagNone">사이트 소개</a>&nbsp;&nbsp;   
</div>

<br><br>

<p>&copy; ODC</p>

</div>





</body>
</html>