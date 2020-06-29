<!-- 20200627 이인주 -->
<!-- 마이페이지 - 클래스 - 수강 클래스 전체 조회 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

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

.center{text-align: center;}

</style>

<div id="main">
	<span id="boardtitle" ><a href="/mypage/class/signup" class="anone">수강 클래스</a></span>
	<hr>


<table class="table-striped table-hover table-condensed">

<!-- 테이블 th -->
<tr style="background: thistle;" >
<!-- 	<th style="width: 20%">주문번호</th> -->
	<th style="width: 15%" class="center">대표 사진</th>
	<th style="width: 15%" class="center">클래스이름</th>
	<th style="width: 10%" class="center">작가이름</th>
	<th style="width: 15%" class="center">결제날짜</th>
	<th style="width: 15%" class="center">예약날짜</th>
	<th style="width: 10%" class="center">예약인원</th>
	<th style="width: 15%" class="center">금액</th>
	<th style="width: 15%" class="center">후기작성</th>
</tr>
	
<!-- 수강 클래스가 없을 때  -->
<c:if  var="signup" test="${empty usersignup }">
<tr>
<td colspan="8" style="color: thistle; font-weight: bold; text-align: center;">수강 클래스가 없습니다</td>
</tr>
</c:if>


<!--수강 클래스가 있을 때 -->
<c:if  var="signup" test="${!empty usersignup }">
<!-- 값 출력 -->
<c:forEach items="${usersignup }" var="signup" >

<tr style="text-align: center;">
	<!-- 사진을 누르면  classno 을 쿼리스트링 값으로 전달하여 페이지를 바꾼다 -->
	<td><a href="#?classno=${signup.classno }"><img src="/upload/${signup.classrenamefilename }" alt="..." class="img-rounded imgsize"></a></td>
	<td>${signup.classname }</td>
	<td>${signup.artid }</td>
	<td>${signup.paymentDate }</td>
	<td>${signup.bookingDate }</td>
	<td>${signup.bookingCount }</td>
	<td><fmt:formatNumber pattern="#,###" value="${signup.totalPrice }" /></td>
	<td><a href="/mypage/class/review/insert?classno=${signup.classno }&bookingno=${signup.bookingno}" class="anone"><button class="btn btn-default">후기작성</button></a></td>
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