<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnList").click(function(){
		history.go(-1);
		
	});
});
</script>

<style type="text/css">

#SnvClassPost{
	background: #ecdfec;
}

#classTable th{
	text-align: center;
}
#classTable tr:first-child{
	background: #ecdfec;
}
</style>

<%-- 클래스 예약 현황페이지 --%>
<%-- 20200621 구동영 --%>
<h4 >&nbsp;클래스 관리</h4>
<hr>
<h5>&nbsp;클래스 정보 > 클래스 예약 현황</h5>
<br>

<c:if test="${paging.totalCount eq 0 }">
<br>
<h3>예약 현황 없음</h3>
</c:if>
<c:if test="${paging.totalCount ne 0 }">
<table id="classTable" class="table table-striped table-condensed text-center">
	<tr>
		<th>예약 번호</th>
		<th>클래스명</th>
		<th>결제 날짜</th>
		<th>신청자</th>
		<th>신청 인원</th>
		<th>예약 날짜</th>
		<th>총 금액</th>
	</tr>
	<c:forEach var="info" items="${list }" >
	<tr class="table-hover">
		<td>${info.bookingNo }</td>
		<td>${info.className }</td>
		<td>${info.paymentDate }</td>
		<td>${info.userId }</td>
		<td>${info.bookingCount }</td>
		<td>${info.bookingDate }</td>
		<td>${info.totalPrice}</td>
	</tr>
	</c:forEach>

</table>

<c:import url="/WEB-INF/paging/pagingClassBooking.jsp" />
</c:if>


<div class="text-center">
<button type="button" class="btn btn-default" id="btnList">목록</button>
</div> 
<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>