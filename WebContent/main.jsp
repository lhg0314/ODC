<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<style type="text/css">

.slideWrapper{


	position: relative;
	margin:0 auto;
	width:1200px;
	
}

.imgsize{
	width:210px;
	height:150px;
	
}

.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
    display: block;
    /* max-width: 100%; */
    height: 411px;
    width: 1200px;
    margin: 0 auto;
}


.bannerborder{
	width:215px;
	border:1px solid black;
}

.prev {
	color:#888;
    font-size: 20px;
    position: absolute;
    top: 14px;
    border: 1px solid #888;
    padding: 3px;
    right: 49px;
}


.next{
	color:#888;
	font-size: 20px;
	position: absolute;
	top: 4%;
	right: 18px;
	border: 1px solid #888;
	padding: 3px;
}


#sliderbox1{
	width:1000px;
	height:275px;
	
	/* 외부정렬 가운데  */
	margin:0 auto;
	position: relative;
	/* div영역을 벗어난 부분 안부이게 처리하기  */
	overflow:hidden; 
}
/* 이미지 목록 */
#slider1 {
	padding:0;
	top:0;
	left:0;	
	list-style:none;
	position:absolute;
	/* 자식요소 absolute박스의 기준점이 되는 설정 */
	
	
	}
	
#slider1 li{
	margin-right: 35px;
	float:left;	
}

/*  */


#sliderbox2{
	width:1000px;
	height:275px;
	
	/* 외부정렬 가운데  */
	margin:0 auto;
	position: relative;
	/* div영역을 벗어난 부분 안부이게 처리하기  */
	overflow:hidden; 
}
/* 이미지 목록 */
#slider2 {
	top:0;
	left:0;	
	padding:0;
	list-style:none;
	position:absolute;
	/* 자식요소 absolute박스의 기준점이 되는 설정 */
	}
	
#slider2 li{
	margin-right: 35px;
	float:left;	
}

#sliderbox3{
	width:1000px;
	height:275px;
	
	/* 외부정렬 가운데  */
	margin:0 auto;
	position: relative;
	/* div영역을 벗어난 부분 안부이게 처리하기  */
	overflow:hidden; 
}
/* 이미지 목록 */
#slider3 {
	top:0;
	left:0;	
	padding:0;
	list-style:none;
	position:absolute;
	/* 자식요소 absolute박스의 기준점이 되는 설정 */
	}
	
#slider3 li{
	margin-right: 35px;
	float:left;	
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	 var $slider1=$("#slider1");
	 var $slider2=$("#slider2");
	 var $slider3=$("#slider3");
	
	 
	 var $slider_list1=$("#slider1 li");
	 var $slider_list2=$("#slider2 li");
	 var $slider_list3=$("#slider3 li");
	 
	 var curSlide1=0;
	 var curSlide2=0;
	 var curSlide3=0;

	 var slideCount1=$slider_list1.length;
	 var slideCount2=$slider_list2.length;
	 var slideCount3=$slider_list3.length;
	 
	 console.log(slideCount1)
	 console.log(slideCount2)
	
	 
	 var slideWidth=300;
	 var slideMargin=50;
	 
	 var ulwidth=(slideWidth+slideMargin)*slideCount1-50+'px';

	 $slider1.css("width",ulwidth);
	 $slider2.css("width",ulwidth);
	 $slider3.css("width",ulwidth);

	 $slider1.css("left",0);
	 
	 
	 
	 $(".prev").eq(0).on("click",function (){
		 //console.log("clicked")
		 curSlide1--;
		 console.log(curSlide1)
		 if(curSlide1>=0){
		 	$slider1.animate({"left": "+=250px"})
		 //보여줄 다음 슬라이드를 오른쪽으로 보내기
		 }
		 if(curSlide1<0){
			 curSlide1=0;
		 }
			 
	 })
	 
	 	 $(".next").eq(0).on("click",function (){
		 //console.log("clicked")

		 curSlide1++;
		 console.log(curSlide1)
		 if(curSlide1<=slideCount1-4){
		
		 $slider1.animate({"left": "-=250px"})
		 }
		 
		 if(curSlide1>slideCount1-4){
			curSlide1=slideCount1-4;
		 }
	 })
	 
	 //////////////////////////////////////////
	 
	 
		 $(".prev").eq(1).on("click",function (){
		 //console.log("clicked")
		 curSlide2--;
		 console.log(curSlide2)
		 if(curSlide2>=0){
		 	$slider2.animate({"left": "+=250px"})
		 //보여줄 다음 슬라이드를 오른쪽으로 보내기
		 }
		 if(curSlide2<0){
			 curSlide2=0;
		 }
			 
	 })
	 
	 	 $(".next").eq(1).on("click",function (){
		 //console.log("clicked")

		 curSlide2++;
		 console.log("curSlide2: "+curSlide2)
		 if(curSlide2<=slideCount2-4){
		
		 $slider2.animate({"left": "-=250px"})
		 }
		 
		 if(curSlide2>slideCount2-4){
			curSlide2=(slideCount2)-4;
		 }
	 })
	 
	 
	 ////////////////////////////////////////////////
	 
	 		 $(".prev").eq(2).on("click",function (){
		 //console.log("clicked")
		 curSlide3--;
		 console.log(curSlide3)
		 if(curSlide3>=0){
		 	$slider3.animate({"left": "+=250px"})
		 //보여줄 다음 슬라이드를 오른쪽으로 보내기
		 }
		 if(curSlide3<0){
			 curSlide3=0;
		 }
			 
	 })
	 
	 	 $(".next").eq(2).on("click",function (){
		 //console.log("clicked")

		 curSlide3++;
		 console.log("curSlide3: "+curSlide3)
		 if(curSlide3<=slideCount3-4){
		
		 $slider3.animate({"left": "-=250px"})
		 }
		 
		 if(curSlide3>slideCount3-4){
			curSlide3=slideCount3-4;
		 }
	 })
	 
	 
})
 </script>

<style type="text/css">
#sliderbox{
	width:1100px;
	height:600px;
	
	/* 외부정렬 가운데  */
	margin:0 auto;
	/* div영역을 벗어난 부분 안부이게 처리하기  */
	/* overflow:hidden; */
}
/* 이미지 목록 */
#slider {
	padding:0;
	margin:0;
	list-style:none;
	/* 자식요소 absolute박스의 기준점이 되는 설정 */
	position:relative;
	}
#slider li{

	position:absolute;
	
}
#slider li img{
	width:1100px;
	height:600px;
}
</style>

<br>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="/resources/img/banner/banner1.jpg" alt="Chania">
      <div class="carousel-caption">
        <h3></h3>
        <p></p>
      </div>
    </div>

    <div class="item">
      <img src="/resources/img/banner/banner2.jpg" alt="Chania">
      <div class="carousel-caption">
        <h3></h3>
        <p></p>
      </div>
    </div>

    <div class="item">
      <img src="/resources/img/banner/banner3.jpg" alt="Flower">
      <div class="carousel-caption">
        <h3></h3>
        <p></p>
      </div>
    </div>

    <div class="item">
      <img src="/resources/img/banner/banner4.jpg" alt="Flower">
      <div class="carousel-caption">
        <h3></h3>
        <p></p>
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>



<br>


<div class="slideWrapper">

   <div style="font-size: 15pt;">
    	<a class="mainAc" href="#">
	    	<span class="glyphicon glyphicon-heart glyphicon" aria-hidden="true"></span>
	    	<strong>&nbsp;인기 클래스</strong>
    	</a>
    </div>
    <hr>
    
	<span class="glyphicon glyphicon-chevron-left prev"></span>

	<div id="sliderbox3">

		<ul id="slider3">
    
			<li>
			<div class="bannerborder">
				<img class="imgsize" src="/resources/img/mini.jpg" alt="...">
				<div class="caption">
					<h3 align="center">클래스이름</h3>
					<p align="center">클래스 소개 </p>
					<p align="center"><a style="background: thistle;"  href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a></p>
				</div>
			</div>
			</li> 
	   	 
		</ul>
     
	</div><!-- end sliderbox3 -->

     <span class="glyphicon glyphicon-chevron-right next" ></span>
     
</div><!-- end slideWrapper -->


<br>


<div class="slideWrapper">

   <div style="font-size: 15pt;">
    	<a class="mainAc" href="#">
	    	<span class="glyphicon glyphicon-heart glyphicon" aria-hidden="true"></span>
	    	<strong>&nbsp;신규 클래스</strong>
    	</a>
    </div>
    <hr>
    
	<span class="glyphicon glyphicon-chevron-left prev"></span>

	<div id="sliderbox3">

		<ul id="slider3">
    
			<li>
			<div class="bannerborder">
				<img class="imgsize" src="/resources/img/mini.jpg" alt="...">
				<div class="caption">
					<h3 align="center">클래스이름</h3>
					<p align="center">클래스 소개 </p>
					<p align="center"><a style="background: thistle;"  href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a></p>
				</div>
			</div>
			</li> 
	   	 
		</ul>
     
	</div><!-- end sliderbox3 -->

     <span class="glyphicon glyphicon-chevron-right next" ></span>
     
</div><!-- end slideWrapper -->


<br>


<div class="slideWrapper">

   <div style="font-size: 15pt;">
    	<a class="mainAc" href="#">
	    	<span class="glyphicon glyphicon-heart glyphicon" aria-hidden="true"></span>
	    	<strong>&nbsp;재능기부 클래스</strong>
    	</a>
    </div>
    <hr>
    
	<span class="glyphicon glyphicon-chevron-left prev"></span>

	<div id="sliderbox3">

		<ul id="slider3">
    
			<li>
			<div class="bannerborder">
				<img class="imgsize" src="/resources/img/mini.jpg" alt="...">
				<div class="caption">
					<h3 align="center">클래스이름</h3>
					<p align="center">클래스 소개 </p>
					<p align="center"><a style="background: thistle;"  href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a></p>
				</div>
			</div>
			</li> 
	   	 
		</ul>
     
	</div><!-- end sliderbox3 -->

     <span class="glyphicon glyphicon-chevron-right next" ></span>
     
</div><!-- end slideWrapper -->


<br>
<br>


<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>