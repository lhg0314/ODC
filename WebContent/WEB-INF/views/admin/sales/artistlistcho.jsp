<!-- 이인주 20200621 -->
<!-- 사업자 월 선택 후 페이지 -->

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

#serchbox{
	width: 250px;
	margin: 0 auto;
	text-align: left;
	float: left;
}
</style>

<h4 >&nbsp;<a href="/admin/artsales/list" class="aTagStyleNone">수익관리</a></h4>
<hr>
<h5>&nbsp;<a href="/admin/artsales/list" class="aTagStyleNone">사업자 수익관리</a></h5>

<!-- 사업자 아이디 검색 -->
<div id="serchbox" >
<form action="/admin/artsales/search" method="post">

<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="사업자 아이디 검색" style="width: 180px;" name="artid">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Search</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->

</form>
</div>

<div id="moncho">
<form action="/admin/artsales/list" method="post">
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

<c:set var="d" value="<%=new Date() %>" />
<fmt:formatDate value="${d }" pattern="M" var="nowformat"/>
<c:set var="nowday" value="${nowformat }"></c:set>


<!-- 사업자 수익 리스트 -->
<table class="table table-striped table-hover table-condensed textcenter" >
<c:if  var="mon" test="${empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${nowday }월 사업자 수익 리스트</h4></caption>
</c:if>
<!-- 사업자 수익 리스트 -->
<c:if  var="mon" test="${!empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${month }월 사업자 수익 리스트</h4></caption>
</c:if>

<!-- 테이블 th -->
<tr style="background: thistle;" >
	<th style="width: 10%">예약 번호</th>
	<th style="width: 10%">사업자 아이디</th>
	<th style="width: 10%">예약자 아이디</th>
	<th style="width: 10%">클래스 이름</th>
	<th style="width: 10%">결제날짜</th>
	<th style="width: 10%">예약날짜</th>
	<th style="width: 10%">예약 인원</th>
	<th style="width: 10%">총금액</th>
	<th style="width: 10%">사업자 수익금</th>
</tr>

<!-- 매출이 없을 때  -->
<c:if  var="mon" test="${empty choartsaleslist }">
<tr>
<td colspan="9" style="color: thistle; font-weight: bold;">수익 리스트가 없습니다</td>
</tr>
<!-- 사업자 매출 보이기 -->
<tr style="background: thistle;">
<th colspan="8
" style="text-align: right;">사업자 총수입</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="0" />원</th>
</tr>
</table>
</c:if>

<!--수익이 있을 때 -->
<c:if  var="mon" test="${!empty choartsaleslist }">
<!-- 값 출력 -->
<c:forEach items="${choartsaleslist }" var="cho" >
<tr >
	<td>${cho.bookingNo }</td>
	<td>${cho.artid }</td>
	<td>${cho.userid }</td>
	<td>${cho.classname }</td>
	<td><fmt:formatDate value="${cho.paymentDate }" pattern="yyyy-MM-dd"/></td>
	<td><fmt:formatDate value="${cho.bookingDate }" pattern="yyyy-MM-dd"/></td>
	<td>${cho.bookingCount }</td>
	<td><fmt:formatNumber pattern="#,###" value="${cho.totalPrice }" /></td>
	<td><fmt:formatNumber pattern="#,###" value="${(cho.totalPrice)*0.9 }" /></td>
	
</tr>
</c:forEach>

<!-- 사업자 수익 보이기 -->
<tr style="background: thistle;">
<th colspan="8" style="text-align: right;">사업자 총수익</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="${chototalsales*0.9 }" />원</th>
</tr>
</table>
<c:import url="/WEB-INF/layout/paging/artlistnowcho.jsp"></c:import>
</c:if>

<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>