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

<<<<<<< HEAD
#main > section { 
=======
#main > form > select { 

>>>>>>> sy
	float: left;
	margin: 0 40px; 
}

#section {

	width: 1100px;
	height: 100%;
	margin: 0 auto;
}

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

#talentDonation {

	margin: 100px 0;
}

#li { 

	list-style: none; 
	width: 200px;
 	height: 320px;
	margin: 0 30px 50px;
	float: left;
	display: inline-block;

}

#eachClass {

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

.CateLoc{

    margin: 5px;
    font-size: 15px;
    color: #999;
}


#classname { 
/* 	width: 200px; */
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




<div id="main">

	
	<div id="title">재능기부 클래스</div>
	<div style="color: #666;">무료로 다양한 클래스를 만나보세요</div><br>
	<hr>
	
	<form action="/talentDonation" method="post" id="cateForm">
	<select name="category" onchange="this.form.submit();">
		<option value="0" selected="selected">카테고리</option>
		<option value="1">플라워</option>
		<option value="2">음악</option>
		<option value="3">수공예</option>
		<option value="4">요리</option>
		<option value="5">뷰티</option>
		<option value="6">미술</option>
		<option value="7">기타</option>
	</select>
	</form>
	
	<section id="section">
	
		<ul id="talentDonation"><!-- 클래스 목록 한줄 -->
	
		<c:forEach items="${list }" var="c" >
		
			<li id="li">
			<div id="eachClass">
				<div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
					<a href="#"><img src="/upload/${c.filename }" alt="썸네일" width="200px;" height="200px;"></a>
<!-- 	테스트용		<a href="#"><img src="/resources/img/Tulips.jpg" alt="썸네일" width="200px;" height="200px;"></a> -->
				</div>
				<div class="sort CateLoc">
 			       <div align="center" class="CateLoc">${c.location } | ${c.category }</div>
				</div>
				<div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
					<a href="/userclass/detail?classno=${c.classNo }"><span>${c.className }</span></a>
				</div>
				<div id="btns"><!-- 각각 상세 페이지로 이동 / 장바구니 담기 -->
			        <a style="background: thistle;" href="/userclass/detail?classno=${c.classNo }"><img src="/resources/img/classbutton/reservation_btnimg.png"></a> 
			        <a style="background: #ccc;" href="#"><img src="/resources/img/classbutton/wishlist_btnimg.png"></a>
		       </div>
			</div>
			</li>
		
		</c:forEach>
		
		</ul>
	
	</section>


</div><!-- end main -->

</body><!-- end body (header에서 옴) -->



<div id="totop">
	<a href="/talentDonation"><img alt="up" src="/resources/img/totop.png" width="40px" height="35px"/></a>
</div>


<div class="clearfix"></div>
<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>