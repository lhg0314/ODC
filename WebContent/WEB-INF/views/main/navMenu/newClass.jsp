<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>


<!-- 레이아웃 -->
<style type="text/css">

#main {

	width: 1200px;
 	height: 100%;
  	margin: 100px auto; 
 	text-align: center;
}

#title {

	color: #845f84;
	font-size: 35px;
	font-weight: bold;
	margin: 10px;
}

select { 

	float: left;
	margin: 0 40px; 
}

.row { margin: 100px 0 }

#totop {

	width: 50px;
	height: 50px;
	padding: 4px 0;
	
	position: fixed;
	bottom: 30px;
	right: 30px;
}

</style>



<!-- 클래스들 -->
<style type="text/css">


#eachClass {
	
   	margin: 0 29px;   
	padding: 12px;
  	width: 20%;  
 	height: 320px;
 	 
	color: black;
	border: 1px solid #eee;
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
	
	width: 200px;
	margin: 5px;
	
 	font-size: 15px; 
 	font-weight: bold;
 	color: #666;
} 

#classname { 
	
	width: 200px;
	height: 40px;
 	padding: 5px;
 	
 	font-size: 17px; 
 	color: black; 
 	
 	/* 제목 길때 ...으로 생략하기 */
	overflow: hidden;
 	white-space: nowrap; 
    text-overflow: ellipsis; 
} 

</style>




<div class="container" id="main">

	
	<div id="title">신규 클래스</div>
	<div style="color: #666;">새롭게 등록된 클래스들을 구경하세요</div><br>
	<hr>
	
	
	<select>
		<option value="">카테고리</option>
		<option value="1">플라워</option>
		<option value="2">베이킹</option>
		<option value="3">ㅇㅇㅇㅇㅇㅇㅇ</option>
		<option value="4">임의로적었음</option>
	</select>
	
	
	<div class="row"><!-- 클래스 목록 한줄 -->

		<div class="col-md-3 col-xs-4" id="eachClass">
			<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><img src="/resources/img/Tulips.jpg" alt="튤립" width="200px;" height="200px;"></a>
			</div>
			<div id="sort">
				<span>카테고리</span>
				|
				<span>지역</span>
			</div>
			<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><span>클래스 이름 클래스 이름</span></a>
			</div>
			<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
		        <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
		        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
	       </div>
		</div>
		
		<div class="col-md-3 col-xs-4" id="eachClass">
			<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><img src="/resources/img/Tulips.jpg" alt="튤립" width="200px;" height="200px;"></a>
			</div>
			<div id="sort">
				<span>카테고리</span>
				|
				<span>지역</span>
			</div>
			<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><span>클래스 이름 클래스 이름</span></a>
			</div>
			<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
		        <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
		        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
	       </div>
		</div>
		
		<div class="col-md-3 col-xs-4" id="eachClass">
			<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><img src="/resources/img/Tulips.jpg" alt="튤립" width="200px;" height="200px;"></a>
			</div>
			<div id="sort">
				<span>카테고리</span>
				|
				<span>지역</span>
			</div>
			<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><span>클래스 이름 클래스 이름</span></a>
			</div>
			<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
		        <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
		        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
	       </div>
		</div>
		
		<div class="col-md-3 col-xs-4" id="eachClass">
			<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><img src="/resources/img/Tulips.jpg" alt="튤립" width="200px;" height="200px;"></a>
			</div>
			<div id="sort">
				<span>카테고리</span>
				|
				<span>지역</span>
			</div>
			<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><span>클래스 이름 클래스 이름</span></a>
			</div>
			<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
		        <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
		        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
	       </div>
		</div>
		
	</div><!-- end row -->
	
	
	
	<div class="row">
	
		<div class="col-md-3 col-xs-4" id="eachClass">
			<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><img src="/resources/img/Tulips.jpg" alt="튤립" width="200px;" height="200px;"></a>
			</div>
			<div id="sort">
				<span>카테고리</span>
				|
				<span>지역</span>
			</div>
			<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><span>클래스 이름 클래스 이름</span></a>
			</div>
			<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
		        <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
		        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
	       </div>
		</div>
		
		<div class="col-md-3 col-xs-4" id="eachClass">
			<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><img src="/resources/img/Tulips.jpg" alt="튤립" width="200px;" height="200px;"></a>
			</div>
			<div id="sort">
				<span>카테고리</span>
				|
				<span>지역</span>
			</div>
			<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
				<a href="#"><span>클래스 이름 클래스 이름</span></a>
			</div>
			<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
		        <a style="background: thistle;" href="#"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
		        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
	       </div>
		</div>
		
	</div><!-- end row -->
	
	
	


</div><!-- end main -->

</body><!-- end body (header에서 옴) -->



<div id="totop" class="icon-scrolltotop">
	<a href="/newclass"><img alt="up" src="/resources/img/totop.png" width="40px" height="35px"/></a>
</div>


<div class="clearfix"></div>
<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>