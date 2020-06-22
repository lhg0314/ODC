<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!-- main header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

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

.classimg{
	width: 300px;
	height: 200px;
	border: 1px solid #ccc;
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
	<h2>카테고리별 클래스 - 이미지 넣는 곳</h2>
</div>
<div id="content">
<div id="sidenav">
	<ul id="navi">
       <li><a href="#"><strong>플라워</strong></a></li>
       <li><a href="#"><strong>음악</strong></a></li>
       <li><a href="#"><strong>수공예</strong></a></li>
       <li><a href="#"><strong>요리</strong></a></li>
       <li><a href="#"><strong>뷰티</strong></a></li>
       <li><a href="#"><strong>미술</strong></a></li>
       <li><a href="#"><strong>기타</strong></a></li>
    </ul>
</div>


<div id="main">

	<!-- 서브 네비게이션바에서 선택할 때마다 바뀜 -->
	<h4>카테고리명</h4>
	<hr>
	
	<ul id="classIntro">
	<!-- 서버에서 데이터 가져와서 for 문으로 있는 만큼 출력하기.. -->
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 <li>
	  <div class="col-xs-5 col-xs-4">
	 	<a href="#">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	      </div>
	    </div>
		</a> 
	   </div>
	 </li>
	 </ul>
</div>

</div>

<div class="clearfix"></div>

<!-- 페이징 처리 임포트 -->
<c:import url="/WEB-INF/layout/paging/paging.jsp"/>

</div>

<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>