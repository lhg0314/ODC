<!-- 이인주 20200621 -->
<!-- 관리자 선택하자마자 이번달 수익 페이지 -->

<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
        
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>

<style type="text/css">
.textcenter{text-align: center;}

.totalsalesbox{
	width: 960px;
	margin: 0 auto;
	text-align: center;
	padding: 0;
}

#moncho{
	width: 960px;
	margin: 0 auto;
	text-align: right;
}
</style>

<h4 >&nbsp;<a href="/admin/adminsales/list" class="aTagStyleNone">수익관리</a></h4>
<hr>
<h5>&nbsp;<a href="/admin/adminsales/list" class="aTagStyleNone">관리자 수익관리</a></h5>

<div id="moncho">
<form action="/admin/adminsales/list" method="post">
	<select id='month' name='month' onchange="this.form.submit();">
	  <option value='0' selected>-- 월 선택 --</option>
	  <option value='1'>1월</option>
	  <option value='2'>2월</option>
	  <option value='3'>3월</option>
	  <option value='4'>4월</option>
	  <option value='5'>5월</option>
	  <option value='6'>6월</option>
	  <option value='7'>7월</option>
	  <option value='8'>8월</option>
	  <option value='9'>9월</option>
	  <option value='10'>10월</option>
	  <option value='11'>11월</option>
	  <option value='12'>12월</option>
	 </select>
	 
</form>
</div>

<!-- 현재 날짜 -->
<c:set var="d" value="<%=new Date() %>" />
<fmt:formatDate value="${d }" pattern="M" var="nowformat"/>
<c:set var="nowday" value="${nowformat }"></c:set>


<!-- 관리자 매출 리스트 -->
<table class="table table-striped table-hover table-condensed textcenter" >
<c:if  var="mon" test="${empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${nowday }월 관리자 수익 리스트</h4></caption>
</c:if>
<!-- 관리자 매출 리스트 -->
<c:if  var="mon" test="${!empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${month }월 관리자 수익 리스트</h4></caption>
</c:if>
<!-- 테이블 th -->
<tr style="background: thistle;" >
	<th style="width: 10%">예약 번호</th>
	<th style="width: 10%">예약자 아이디</th>
	<th style="width: 15%">클래스 이름</th>
	<th style="width: 10%">결제날짜</th>
	<th style="width: 10%">예약날짜</th>
	<th style="width: 10%">예약 인원</th>
	<th style="width: 10%">총금액</th>
	<th style="width: 10%">관리자 수익금</th>
</tr>

<!-- 값 출력 -->
<c:forEach items="${nowadminsaleslist }" var="now" >
<tr >
	<td>${now.bookingNo }</td>
	<td>${now.userid }</td>
	<td>${now.classname }</td>
	<td><fmt:formatDate value="${now.paymentDate }" pattern="yyyy-MM-dd"/></td>
	<td><fmt:formatDate value="${now.bookingDate }" pattern="yyyy-MM-dd"/></td>
	<td>${now.bookingCount }</td>
	<td><fmt:formatNumber pattern="#,###" value="${now.totalPrice }" /></td>
	<td><fmt:formatNumber pattern="#,###" value="${(now.totalPrice)*0.1 }" /></td>
	
</tr>
</c:forEach>


<!-- 관리자 수익 보이기 -->
<tr style="background: thistle;">
<th colspan="7" style="text-align: right;">관리자 총수익</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="${nowtotalsales*0.1 }" />원</th>
</tr>
</table>



<c:import url="/WEB-INF/layout/paging/adminsalespaging.jsp"></c:import>

<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>