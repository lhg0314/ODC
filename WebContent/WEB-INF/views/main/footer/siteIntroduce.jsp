<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ODC::사이트소개</title>
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
/* 	border: 1px solid #eee; */
	
	width: 1200px;
	height: 90%;
	
    padding: 0 200px;
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

<!-- 본문 -->
<style type="text/css">

#logo { text-align: center; }

#content {
	text-align: center;
	font-size: 1.8rem;
	color: black;
	line-height: 1.5;
	
}

#content p {
	color: red;
	font-family: serif;
	font-size: 50px;
	font-weight: bold;
}

#loc { text-align: center; }
</style>



<!-- texts -->
<style type="text/css">

#site_introduce {

	font-size: 45px;
	font-family: batang;
  	font-weight: bolder; 
	text-align: center; 
	margin: 50px 0;
 	color: #8b6d8b;
}


#title {

    font-size: 16px;
    font-weight: bold;
}
#header {
	text-align: center;
}
#map{
	margin:0 auto;
}

</style>





<section>

<div id="wrapper" class="container"> 
<div id="main">
<div id="header">	
<a href="/"><img alt="logo" src="/resources/img/logo2.png" width="200px;" height="200px;"></a>
<h2 style="font-weight: bold;">사이트 소개</h2>
<hr>
</div>		
		
<div id="content">
	<span>ODC는 OneDayClass 의 줄임말로</span><br>
	<span>클래스 공방예약 서비스를 제공하는 사이트입니다</span><br>
	<span>사용자 페이지와 사업자 페이지가 분리되어있어서</span><br>
	<span>사용자와 사업자 개별된공간에서 활동할수있습니다</span>
	
	
</div>


<br><br><br><br><br><br>


<span id="title">LOCATION</span>
<hr>

<div id="map" style="width:800px;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78d749f240f49d7001ae30cc94cd9aa1&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 141.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 
map.setZoomable(false);
map.setDraggable(false);  

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울 강남구 테헤란로10길 9 (우)06234 ', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">ODC</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>

	

<br><br><br><br><br><br>



<span id="title">CONTACT US</span>
<hr>


<div id="contact_info">
	<span>(주)ODC</span><br>
	<span>서울특별시 강남구 테헤란로 10길 9 그랑프리빌딩 4F</span><br>
	<span>010-1234-5789</span><br>
	<span>abc12345@gmail.com</span><br>
	<span>MON-FRI (9:00- 18:00)</span><br>
</div>
</div>
</div>	
</section> 
<br><br><br><br>
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