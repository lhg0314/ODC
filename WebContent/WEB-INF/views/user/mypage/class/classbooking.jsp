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

<script type="text/javascript">
function bookingcancel(bookingno) {
	var result = confirm("클래스 예약 취소하시겠습니까?");

	if( result ) {
		location.href="/mypage/classbooking/cancel?bookingno="+bookingno;
	}
}
</script>



<div id="main">
	<span id="boardtitle" ><a href="/mypage/class/booking" class="anone">예약 클래스</a></span>
	<hr>


<table class="table-striped table-hover table-condensed">

<!-- 테이블 th -->
<tr style="background: thistle;" >
	<th style="width: 20%">주문번호</th>
	<th style="width: 15%">대표 사진</th>
	<th style="width: 15%">클래스 이름</th>
	<th style="width: 15%">작가 이름</th>
	<th style="width: 15%">결제날짜</th>
	<th style="width: 15%">예약날짜</th>
	<th style="width: 15%">예약 인원</th>
	<th style="width: 15%">결제 금액</th>
	<th style="width: 10%">결제 취소</th>
</tr>
	
<!-- 예약리스트가 없을 때  -->
<c:if  var="mon" test="${empty userbooking }">
<tr>
<td colspan="8" style="color: thistle; font-weight: bold; text-align: center;">예약리스트가 없습니다</td>
</tr>
</c:if>


<!--예약리스트가 있을 때 -->
<c:if  var="mon" test="${!empty userbooking }">
<!-- 값 출력 -->
<c:forEach items="${userbooking }" var="book" >

<tr style="text-align: center;">
	<!-- 사진을 누르면  classno 을 쿼리스트링 값으로 전달하여 페이지를 바꾼다 -->
	<td>${book.merchantuid }</td>
	<td><a href="#?classno=${book.classno }"><img src="/upload/${book.classrenamefilename }" alt="..." class="img-rounded imgsize"></a></td>
	<td>${book.classname }</td>
	<td>${book.artid }</td>
	<td>${book.paymentDate }</td>
	<td>${book.bookingDate }</td>
	<td>${book.bookingCount }</td>
	<td>${book.totalPrice }</td>
	<td><button class="btn btn-default" onclick="bookingcancel(${book.bookingno });">결제 취소</button></td>
</tr>	
</c:forEach>
</c:if>




</table>	
<br>
	

</div> <!-- 전체를 감싸는 div -->

<!-- float 막는 clear -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>