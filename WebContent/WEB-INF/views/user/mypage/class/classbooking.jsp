<!-- 20200624 이인주 -->
<!-- 마이페이지 - 클래스 - 예약한 클래스 확인 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 

<style type="text/css">
.anone{
 text-decoration: none;
 color: black;
}

.anone:hover{
	text-decoration: none; 
	color: black; 
}

#bookingbox {
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 20px;
	padding: 20px;
	height: 100%;
	margin: 0;
}

.imgsize{
	width: 100px;
	height: 100px;
}


</style>

<div id="main">
	<span id="boardtitle">클래스</span>
	<hr>
	<span id="boardtitle" ><a href="/mypage/class/booking" class="anone">예약한 클래스</a></span>
	<br><br>

	
	<table class="table-striped table-hover table-condensed">
	
	<!-- 테이블 th -->
	<tr style="background: thistle;" >
	<th style="width: 15%">대표 사진</th>
	<th style="width: 15%">클래스 이름</th>
	<th style="width: 15%">작가 이름</th>
	<th style="width: 10%">결제날짜</th>
	<th style="width: 10%">예약날짜</th>
	<th style="width: 10%">예약 인원</th>
	<th style="width: 10%">결제 금액</th>
	</tr>
	
	<tr>
	<td><img src="/resources/img/mini.jpg" alt="..." class="img-rounded imgsize"></td>
	<td>클래스 이름ex</td>
	<td>작가 이름ex</td>
	<td>결제 날짜ex</td>
	<td>예약날짜ex</td>
	<td>예약 인원</td>
	<td>결제 금액</td>
	<tr>
	
	<tr>
	<td><img src="/resources/img/mini.jpg" alt="..." class="img-rounded imgsize"></td>
	<td>클래스 이름ex</td>
	<td>작가 이름ex</td>
	<td>결제 날짜ex</td>
	<td>예약날짜ex</td>
	<td>예약 인원</td>
	<td>결제 금액</td>
	<tr>
	
	</table>
	
	
	
	<br>
	
	
	
	

</div> <!-- 전체를 감싸는 div -->

<!-- float 막는 clear -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>