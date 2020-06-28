<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
	
	var location = '<c:out value="${message }"/>'
	
	console.log(location);
	if( location == '전체'){
		$("#navi:nth-child(1)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '서울'){
		$("#navi:nth-child(2)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '경기'){
		$("#navi:nth-child(3)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '강원'){
		$("#navi:nth-child(4)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '충청'){
		$("#navi:nth-child(5)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '경상'){
		$("#navi:nth-child(6)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '전라'){
		$("#navi:nth-child(7)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}else if( location == '제주'){
		$("#navi:nth-child(8)").css("border-bottom","2px solid thistle").children("a").css("color","thistle");
	}
	

	
	
});
</script>
<!-- 사이드 메뉴바 -->
<style type="text/css">


ul#navi {
    width: 100%;
    list-style:none;
    margin:0;
    padding:0;
}

ul#navi li {
    margin: 0;
    line-height:40px;
    cursor:pointer;
	border-bottom: 2px solid white;
}
ul#navi li a {
    display: block;
    width: 100%;
    height:100%;
    text-decoration:none;
    text-align: center;
    padding: 0;
}

/* 마우스 올리면 밑에 밑줄 */
ul#navi li:hover {
	border-bottom: 2px solid thistle;
}
#navi li a:hover {
	color: thistle;
}


ul#classIntro {
    list-style:none;
    margin:0;
    padding:0;
}

</style>

<style type="text/css">

#wrapper{
	width: 1200px;
	margin: 20px auto;

/* 	border: 1px solid #ccc; */
	font-family:sans-serif;
	

}

#wrapper > #content{
	width: 1100px;
	margin: 0 auto;
}

#locImg{
	width: 100%;
	height: 200px;
	border: 1px solid blue;
	margin-bottom: 20px;
}

#sidenav {
	float: left;

	width: 120px;
	
	margin-top: 48px;

/* 	border: 1px solid red; */

/* 	text-align: center; */
}

#main{
/*    background-color:tomato; */
	float: right;

	width: 970px;

/* 	border: 1px solid green; */

}

#locationList{
	list-style: none;
	padding: 0;
	margin: 0;
}

#locationList li{
	float: left;
	margin: 10px;
}

.bannerborder{
	width:252px;
	border:1px solid #ccc;
	border-radius: 15px;
	text-align: center;
}

.imgsize{
	width:230px;
	height:230px;
	margin: 10px 10px 0;
	border-radius: 15px;
	
}

#section{
	margin: 0 auto;
	width: 940px;
}

.aTagStyleNone {
    text-decoration : none;
    color : black;
}

a:link { color: none; text-decoration: none;}
a:visited { color: none; text-decoration: none;}
a:hover { color: none; text-decoration: none;}

</style>

<div id="wrapper">
<div id="locImg">
	<h2>지역별 클래스 - 이미지 넣는 곳</h2>
</div>
<div id="content">
<div id="sidenav">
	<ul id="navi">
       <li><a href="/class/location"><strong>전체</strong></a></li>
       <li><a href="/class/location?location=1"><strong>서울</strong></a></li>
       <li><a href="/class/location?location=2"><strong>경기</strong></a></li>
       <li><a href="/class/location?location=3"><strong>강원</strong></a></li>
       <li><a href="/class/location?location=4"><strong>충청</strong></a></li>
       <li><a href="/class/location?location=5"><strong>경상</strong></a></li>
       <li><a href="/class/location?location=6"><strong>전라</strong></a></li>
       <li><a href="/class/location?location=7"><strong>제주</strong></a></li>
    </ul>
</div>


<div id="main">

	<!-- 서브 네비게이션바에서 선택할 때마다 바뀜 -->
	<h4>${message }</h4>
	<hr>
	<div id="section">
	
	<ul id="locationList">
	<!-- 서버에서 데이터 가져와서 for 문으로 있는 만큼 출력하기.. -->
	
	<c:forEach var="info" items="${list }" >
	 <li>
	 <div class="bannerborder">
      <img class="imgsize" src="/upload/${info.filename }" alt="...">
      <div class="caption">
        <p align="center">${info.category }</p>
        <h3 align="center">${info.className }</h3>
        <p align="center">${info.classPrice } \</p>
        <p align="center"><a style="background: thistle;"  href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a></p>
      </div>
     </div>
	 </li>
	 </c:forEach>
	
	</ul>
	 
	 <div class="clearfix"></div>
	 </div>
</div>

</div>

<div class="clearfix"></div>

</div>

<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>