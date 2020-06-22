<!-- 200621 이서연 -->
<!-- 관리자페이지 > 사용자정보 > 사용자 상세정보 > 사옹자 예약클래스 전체보기.jsp -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

   
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
/* 	float:right;  */
	text-decoration: none;
    font-size: 14px;
    margin: 10px 40px;
}

</style>



<h3 style="font-weight: bold;">&nbsp;회원 관리</h3>
<hr>
<h6 style="font-weight: bold;">&nbsp;회원 상세정보</h6>



<div class="container">
	
	<br><br><br>
	<h6 style="font-weight: bold;">&nbsp;회원 예약 클래스 전체</h6>
	
	
	<br>
	
	<table class="table table-condensed">
			
		<tr class="tablehead">
			<th style="width: 10%; text-align: center;">예약번호</th>
			<th style="width: 10%; text-align: center;">클래스번호</th>
			<th style="width: 20%; text-align: center;">클래스이름</th>
			<th style="width: 20%; text-align: center;">예약일</th>
			<th style="width: 20%; text-align: center;">결제일</th>
			<th style="width: 20%; text-align: center;">결제금액</th>
		</tr>	
		
		<c:forEach items="${booking }" var="b">
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


<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>