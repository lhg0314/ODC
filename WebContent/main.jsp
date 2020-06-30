<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>



<!-- 레이아웃 -->
<style type="text/css">

#banner { 
   
   width: 100%;
   margin: 0 auto; 
   text-align: center;
}

section {

   width: 1200px;
   height: 100%;
   margin: 50px auto;
}

.slideWrapper { margin: 60px 0 100px; }

</style>


<!-- 메인배너 -->
<style type="text/css">

#myCarousel {

    width: 100%;
   height: 410px;
}

#myCarousel img {

   width: 100%;
   height: 410px;
} 

</style>


<!-- 클래스 슬라이드 레이아웃 -->
<style type="text/css">

#classLink {

   width: 80%;
   float: left;
   font-size: 18px;
   color: #333;
   
}

#classLink a {

   text-decoration: none;
   color: #333;
}

#arrow {

   text-align: right;
   width: 10%;
   float: right;
}

#arrow span {

   border: 1px solid #ddd;
   border-radius: 5px;
   padding: 4px;
   color: #aaa;
    box-shadow: 1px 1px 1px 1px #eee;
}

#sliderbox1 {

   width: 1100px;
   height: 320px;
   
   margin: 0 auto;
   overflow: hidden; 
}

#slider1 {

   padding: 0; 
   margin: 5px 0;
   list-style: none; 

   position: relative;
}

#sliderbox2 {

   width: 1100px;
   height: 320px;
   
   margin: 0 auto;
   overflow: hidden; 
}

#slider2 {

   padding: 0; 
   margin: 5px 0;
   list-style: none; 

   position: relative;
}

#sliderbox3 {

   width: 1100px;
   height: 320px;
   
   margin: 0 auto;
   overflow: hidden; 
}

#slider3 {

   padding: 0; 
   margin: 5px 0;
   list-style: none; 

   position: relative;
}

</style>


<!-- 클래스 슬라이드 내부 스타일 -->
<style type="text/css">

#li { 

   list-style: none; 
   width: 200px;
    height: 320px;
   margin: 0 40px;
    float: none; 
    display: inline-block; 
}

#eachClass {

   color: black;
   border: 1px solid #eee;
   text-align: center;
}

#eachClass #img {
   
   width: 100%;
   height: 200px;
   overflow: hidden;
}

#eachClass #img:hover img {

   /* 커서 올렸을때 살짝 확대되게 하기 */
   width: 205px;
   height: 205px;
}

#eachClass a:hover { 

   text-decoration: none; 
   color: black;
} 

#sort { 
   
    margin: 5px;
    font-size: 15px;
    color: #999;
} 

#classname { 
   
/*    width: 200px; */
   height: 40px;
    
    font-size: 18px; 
    color: black; 
    
    /* 제목 길때 ...으로 생략하기 */
   overflow: hidden;
    white-space: nowrap; 
    text-overflow: ellipsis; 
} 

#btns { margin: 0 0 5px; }

</style>



<!-- 클래스 슬라이드 돌아가게 하기 -->
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
    
    
    var slideWidth=2400;
    var slideMargin=50;
    
    var ulwidth=(slideWidth+slideMargin)*slideCount1-50+'px';

    
    
    $slider1.css("width",ulwidth);
    $slider2.css("width",ulwidth);
    $slider3.css("width",ulwidth);

    $slider1.css("left",0);
    
    
    
    
    $(".prev").eq(0).on("click",function (){
      
       curSlide1--;
       
       if(curSlide1>=0){
          
          $slider1.animate({"left": "+=290px"})
       }
       
       if(curSlide1<0){
          
          curSlide1=0;
       }
      
    })
    
        $(".next").eq(0).on("click",function (){
       
          curSlide1++;
           
          if(curSlide1 <= slideCount1-4){
             
             $slider1.animate({"left": "-=290px"})
          }
          
          if(curSlide1 > slideCount1-4){
             
             curSlide1 = slideCount1-4;
          }
          
    })
    
   
    /************************************************/
    
    
       
    $(".prev").eq(1).on("click",function (){
      
       curSlide2--;
       
       if(curSlide2>=0){
          
          $slider2.animate({"left": "+=290px"})
       }
       
       if(curSlide2<0){
          
          curSlide2=0;
       }
      
    })
    
        $(".next").eq(1).on("click",function (){
       
          curSlide2++;
           
          if(curSlide2 <= slideCount2-4){
             
             $slider2.animate({"left": "-=290px"})
          }
          
          if(curSlide2 > slideCount2-4){
             
             curSlide2 = slideCount2-4;
          }
          
    })
    
    
    
    /************************************************/
    
    
    
    $(".prev").eq(2).on("click",function (){
      
       curSlide3--;
       
       if(curSlide3>=0){
          
          $slider3.animate({"left": "+=290px"})
       }
       
       if(curSlide3<0){
          
          curSlide3=0;
       }
      
    })
    
        $(".next").eq(2).on("click",function (){
       
          curSlide3++;
           
          if(curSlide3 <= slideCount3-4){
             
             $slider3.animate({"left": "-=290px"})
          }
          
          if(curSlide3 > slideCount3-4){
             
             curSlide3 = slideCount3-4;
          }
          
    })
   
})
 </script>



<div id="banner">

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
            <img src="/resources/img/banner/banner11.jpg" alt="banner1" />
          </div>
      
          <div class="item">
            <img src="/resources/img/banner/banner22.jpg" alt="banner2" />
          </div>
      
          <div class="item">
            <img src="/resources/img/banner/banner33.jpg" alt="banner3" />
          </div>
      
          <div class="item">
            <img src="/resources/img/banner/banner44.jpg" alt="banner4" />
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
     
   </div><!-- end #myCarousel -->

</div><!-- end banner -->


<br>


<section>


<div class="slideWrapper">

   <div id="title">
   
      <div id="classLink">
          <a href="/hotclass">
             <span class="glyphicon glyphicon-fire" aria-hidden="true" style="color: #e84e4e;"></span>
             <strong> 인기 클래스</strong>
          </a>
       </div>
       <div id="arrow">
         <span class="glyphicon glyphicon-chevron-left prev"></span>
         <span class="glyphicon glyphicon-chevron-right next"></span>
      </div>
      
    </div><!-- end title -->
    
    <br><hr>

   <div id="sliderbox1">

      <ul id="slider1">
      
          <li id="li">
            <div id="eachClass">
               <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><img src="/resources/img/Tulips.jpg" alt="썸네일" width="200px;" height="200px;"></a>
               </div>
               <div id="sort">
                  <span>서울</span>
                  |
                  <span>플라워</span>
               </div>
               <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><span>클래스이름</span></a>
               </div>
               <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                    <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                    <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
                </div>
            </div>
         </li>
          <li id="li">
            <div id="eachClass">
               <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><img src="/resources/img/mini.jpg" alt="썸네일" width="200px;" height="200px;"></a>
               </div>
               <div id="sort">
                  <span>서울</span>
                  |
                  <span>플라워</span>
               </div>
               <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><span>클래스이름</span></a>
               </div>
               <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                    <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                    <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
                </div>
            </div>
         </li>
          <li id="li">
            <div id="eachClass">
               <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><img src="/resources/img/logo2.png" alt="썸네일" width="200px;" height="200px;"></a>
               </div>
               <div id="sort">
                  <span>서울</span>
                  |
                  <span>플라워</span>
               </div>
               <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><span>클래스이름</span></a>
               </div>
               <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                    <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                    <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
                </div>
            </div>
         </li>
          <li id="li">
            <div id="eachClass">
               <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><img src="/resources/img/Tulips.jpg" alt="썸네일" width="200px;" height="200px;"></a>
               </div>
               <div id="sort">
                  <span>서울</span>
                  |
                  <span>플라워</span>
               </div>
               <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><span>클래스이름</span></a>
               </div>
               <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                    <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                    <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
                </div>
            </div>
         </li>
         
          <li id="li">
            <div id="eachClass">
               <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><img src="/resources/img/Tulips.jpg" alt="썸네일" width="200px;" height="200px;"></a>
               </div>
               <div id="sort">
                  <span>서울</span>
                  |
                  <span>플라워</span>
               </div>
               <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="#"><span>클래스이름</span></a>
               </div>
               <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                    <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                    <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
                </div>
            </div>
         </li>
         
      </ul>
     
   </div><!-- end sliderbox1 -->
   
</div><!-- end slideWrapper --><!-- hotclass -->



<div class="slideWrapper">

   <div id="title">
   
      <div id="classLink">
          <a href="/newclass">
             <span class="glyphicon glyphicon-flash" aria-hidden="true" style="color: #ffc107;"></span>
             <strong> 신규 클래스</strong>
          </a>
       </div>
       <div id="arrow">
         <span class="glyphicon glyphicon-chevron-left prev"></span>
         <span class="glyphicon glyphicon-chevron-right next"></span>
      </div>
      
    </div><!-- end title -->
    
    <br><hr>

   <div id="sliderbox2">
      <ul id="slider2">
      
          <c:forEach items="${newList }" var="n" begin="0" end="9" >
         <li id="li">
         <div id="eachClass">
            <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
               <a href="/userclass/detail?classno=${n.classno }"><img src="/upload/${n.filename }" alt="썸네일" width="200px;" height="200px;"></a>
      <!--테스트용   <a href="#"><img src="/resources/img/Tulips.jpg" alt="썸네일" width="200px;" height="200px;"></a> -->
            </div>
            <div id="sort">
               <span>${n.location }</span> | <span>${n.category }</span>
            </div>
            <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
               <a href="/userclass/detail?classno=${n.classno }"><span>${n.className }</span></a>
            </div>
            <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                 <a style="background: thistle;" href="userclass/detail?classno=${n.classno }"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                 <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
             </div>
         </div>
         </li>
      </c:forEach>
          
      </ul>
     
   </div><!-- end sliderbox2 -->
   
       
</div><!-- end slideWrapper --><!-- newclass -->



<div class="slideWrapper">

   <div id="title">
   
      <div id="classLink">
          <a href="/talentDonation">
             <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true" style="color: #599a5c;"></span>
             <strong> 재능기부 클래스</strong>
          </a>
       </div>
       <div id="arrow">
         <span class="glyphicon glyphicon-chevron-left prev"></span>
         <span class="glyphicon glyphicon-chevron-right next"></span>
      </div>
      
    </div><!-- end title -->
    
    <br><hr>

   <div id="sliderbox3">

      <ul id="slider3">
      
         <c:forEach var="tal" items="${talentList }" begin="0" end="9">
            <li id="li">
            <div id="eachClass">
               <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="/userclass/detail?classno=${tal.classNo }"><img src="/upload/${tal.filename }" alt="썸네일" width="200px;" height="200px;"></a>
               </div>
               <div id="sort">
                  <span>${tal.location }</span> | <span>${tal.category }</span>
               </div>
               <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
                  <a href="/userclass/detail?classno=${tal.classNo }"><span>${tal.className }</span></a>
               </div>
               <div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
                    <a style="background: thistle;" href="/userclass/detail?classno=${tal.classNo }"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
                    <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
                </div>
            </div>
            </li>
          </c:forEach>

          
      </ul>
     
   </div><!-- end sliderbox3 -->
   
       
</div><!-- end slideWrapper --><!-- talentDonation -->


</section>



<div class="clearfix"></div>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>