<!-- 200620 이서연 -->
<!-- 관리자페이지 > 사용자정보 > 사용자 상세정보.jsp -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>


<style type="text/css">

.container { 

	width: 960px; 
	text-align: center;
}

.table {

	display: inline-table;
	width: 850px;
	font-size: 13px;
	border: 1px solid #eee;
}

.tablehead { 

	background: #eee; 
}

#viewmore { 
	float:right; 
	text-decoration: none;
    font-size: 14px;
    margin: 10px 40px;
}

</style>



<h3 style="font-weight: bold;">&nbsp;회원 관리</h3>
<hr>
<h6 style="font-weight: bold;">&nbsp;회원 상세정보</h6>



<div class="container">

	<br>

	<table class="table table-condensed">
	
		<tr class="tablehead">
			<th style="width: 20%; text-align: center;">회원번호</th>
			<th style="width: 20%; text-align: center;">이름</th>
			<th style="width: 20%; text-align: center;">아이디</th>
			<th style="width: 20%; text-align: center;">비밀번호</th>
			<th style="width: 20%; text-align: center;">닉네임</th>
		</tr>	
		
		<tr>
			<td>${userInfo.userno }</td>
			<td>${userInfo.username }</td>
			<td>${userInfo.userid }</td>
			<td>${userInfo.userpw }</td>
			<td>${userInfo.usernick }</td>
		</tr>	
		
	</table>
	
	<table class="table table-condensed">
		
		<tr class="tablehead">	
			<th style="width: 20%; text-align: center;">등급</th>
			<th style="width: 20%; text-align: center;">연락처</th>
			<th style="width: 20%; text-align: center;">생년월일</th>
			<th style="width: 40%; text-align: center;">이메일</th>
		</tr>
		
		<tr>
			<c:if test="${userInfo.usergrade eq 1 }">
				<td>오디씨앗</td>
			</c:if>
			<c:if test="${userInfo.usergrade eq 2 }">
				<td>오디꽃</td>
			</c:if>
			<c:if test="${userInfo.usergrade eq 3 }">
			</c:if>
			<td>${userInfo.userphone }</td>
			<td>${userInfo.userbirth }</td>
			<td>${userInfo.useremail }</td>
		</tr>
	
	</table>
	
</div>


<br><br>
<h6 style="font-weight: bold;">&nbsp;회원 예약 클래스</h6>

<div class="container">

	<c:set var="b" value="book"/>
	<a href="/admin/userviewall?userno=${userInfo.userno}&cate=${b} " id="viewmore">전체보기 &raquo;</a>
	
	<table class="table table-condensed">
		
			<tr class="tablehead">
				<th style="width: 10%; text-align: center;">예약번호</th>
				<th style="width: 10%; text-align: center;">클래스번호</th>
				<th style="width: 20%; text-align: center;">클래스이름</th>
				<th style="width: 20%; text-align: center;">예약일</th>
				<th style="width: 20%; text-align: center;">결제일</th>
				<th style="width: 20%; text-align: center;">결제금액</th>
			</tr>	
			
			<c:forEach items="${booking }" var="b" begin="0" end="2">
			<tr>
				<td>${b.bookingNo }</td>
				<td>${b.classno }</td>
				<td>${b.classname }</td>
				<td>${b.bookingDate }</td>
				<td>${b.paymentDate }</td>
				<td>${b.totalPrice }</td>
			</tr>	
			</c:forEach>
			
		</table>
		
</div>




<br><br>
<h6 style="font-weight: bold;">&nbsp;회원 작성 후기</h6>

<div class="container">

	<c:set var="r" value="review"/>
	<a href="/admin/userviewall?userno=${userInfo.userno}&cate=${r} " id="viewmore">전체보기 &raquo;</a>
	
		<table class="table table-condensed">
		
			<tr class="tablehead">
				<th style="width: 10%; text-align: center;">후기번호</th>
				<th style="width: 10%; text-align: center;">클래스번호</th>
				<th style="width: 20%; text-align: center;">클래스이름</th>
				<th style="width: 40%; text-align: center;">본문</th>
				<th style="width: 10%; text-align: center;">만족도</th>
				<th style="width: 10%; text-align: center;">작성일</th>
			</tr>	
			
			<c:forEach items="${review }" var="r" begin="0" end="2">
			<tr>
				<td>${r.reviewno }</td>
				<td>${r.classno }</td>
				<td>${r.classname }</td>
				<td>${r.reviewContent }</td>
				<td>${r.sat_level }</td>
				<td>${r.reviewDate }</td>
			</tr>	
			</c:forEach>
			
		</table>
		
</div>


<br><br>
<h6 style="font-weight: bold;">&nbsp;회원 작성 문의</h6>

<div class="container">

	<c:set var="a" value="ask"/>
	<a href="/admin/userviewall?userno=${userInfo.userno}&cate=${a} " id="viewmore">전체보기 &raquo;</a>
	
	<table class="table table-condensed">
		
			<tr class="tablehead">
				<th style="width: 10%; text-align: center;">문의번호</th>
				<th style="width: 10%; text-align: center;">클래스번호</th>
				<th style="width: 20%; text-align: center;">클래스이름</th>
				<th style="width: 50%; text-align: center;">본문</th>
				<th style="width: 10%; text-align: center;">작성일</th>
			</tr>	
			
			<c:forEach items="${ask }" var="a" begin="0" end="2">
			<tr>
				<td>${a.askBoardno }</td>
				<td>${a.classno }</td>
				<td>${a.classname }</td>
				<td>${a.askContent }</td>
				<td>${a.askDate }</td>
			</tr>	
			</c:forEach>
			
		</table>
		
</div>



<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>