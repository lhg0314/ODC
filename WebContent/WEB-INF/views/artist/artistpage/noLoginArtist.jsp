<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<%-- //<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import>  --%>
<style type="text/css">
#wrapper{
	width: 1200px;
	margin: 20px auto;

/* 	border: 1px solid #ccc; */
	font-family:sans-serif;
	
	text-align: center;
}

#loginbox{
	
 	
	
	align-content: center;
	text-align: center;
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

<div id="loginbox">






<div id="loginInfo">
<p>작가 페이지 서비스를 이용하기 위해서는 로그인이 필요합니다</p>

<div id="find">
<ul>
	
	
	<li><a href="/artist/join" class="ack">회원가입</a></li>
	<li>&nbsp;|&nbsp;</li>
	<li><a href="/member/login" class="ack">로그인 하기</a></li>
</ul>
</div>
</div>









</div>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>