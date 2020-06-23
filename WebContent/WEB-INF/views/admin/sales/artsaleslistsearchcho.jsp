<!-- 이인주 20200621 -->
<!-- 사업자 선택하고 사업자 아이디 검색하고 월 선택했을 때 페이지 -->

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
	width: 400px;
	margin: 0 auto;
	text-align: right;
	float: right;
}

</style>


<h4 >&nbsp;<a href="/admin/artsales/list" class="aTagStyleNone">수익관리</a></h4>
<hr>
<h5>&nbsp;<a href="/admin/artsales/list" class="aTagStyleNone">사업자 수익관리</a></h5>


<div id="moncho">
<form action="/admin/artsalessistserach/cho" method="post">
	<select id='month' name='month' onchange="this.form.submit();">
	  <option value='0' selected >-- 월 선택 --</option>
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

<div class="clearfix"></div>

<!-- 현재 날짜 -->
<c:set var="d" value="<%=new Date() %>" />
<fmt:formatDate value="${d }" pattern="M" var="nowformat"/>
<c:set var="nowday" value="${nowformat }"></c:set>

<% HttpSession searchartid = request.getSession(); %>
<% String artid = (String)searchartid.getAttribute("artid");%>

<!-- 사업자 수익 리스트 -->
<table class="table table-striped table-hover table-condensed textcenter" >

<c:if  var="mon" test="${empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${nowday }월  <%=artid %>사업자 수익 리스트</h4></caption>
</c:if>

<!-- 사업자 수익 리스트 -->
<c:if  var="mon" test="${!empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${month }월  <%=artid %>사업자 수익 리스트</h4></caption>
</c:if>


<!-- 테이블 th -->
<tr style="background: thistle;" >
	<th style="width: 10%">예약 번호</th>
	<th style="width: 10%">예약자 아이디</th>
	<th style="width: 10%">클래스 이름</th>
	<th style="width: 10%">결제날짜</th>
	<th style="width: 10%">예약날짜</th>
	<th style="width: 10%">예약 인원</th>
	<th style="width: 10%">총금액</th>
	<th style="width: 10%">사업자 수익금</th>
</tr>

<!-- 수익이 없을 때  -->
<c:if  var="mon" test="${empty choartsearchlist }">
<tr>
<td colspan="8" style="color: thistle; font-weight: bold;">수익 리스트가 없습니다</td>
</tr>
<!-- 사업자 수익 보이기 -->
<tr style="background: thistle;">
<th colspan="7" style="text-align: right;">사업자 총수입</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="0" />원</th>
</tr>
</table>
</c:if>

<!--수익이 있을 때 -->
<c:if  var="mon" test="${!empty choartsearchlist }">
<!-- 값 출력 -->
<c:forEach items="${choartsearchlist }" var="chosearch" >
<tr >
	<td>${chosearch.bookingNo }</td>
	<td>${chosearch.userid }</td>
	<td>${chosearch.classname }</td>
	<td><fmt:formatDate value="${chosearch.paymentDate }" pattern="yyyy-MM-dd"/></td>
	<td><fmt:formatDate value="${chosearch.bookingDate }" pattern="yyyy-MM-dd"/></td>
	<td>${chosearch.bookingCount }</td>
	<td><fmt:formatNumber pattern="#,###" value="${chosearch.totalPrice }" /></td>
	<td><fmt:formatNumber pattern="#,###" value="${(chosearch.totalPrice)*0.9 }" /></td>
	
</tr>
</c:forEach>

<!-- 사업자 수익 보이기 -->
<tr style="background: thistle;">
<th colspan="7" style="text-align: right;">사업자 총수익</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="${chosearchtotal*0.9 }" />원</th>
</tr>
</table>
<c:import url="/WEB-INF/layout/paging/artsalessearchpaging.jsp"></c:import>
</c:if>



<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>


