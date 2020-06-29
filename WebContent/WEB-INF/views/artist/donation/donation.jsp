<!-- 작가페이지 - 후원내역 리스트 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
        
<!-- main header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<style type="text/css">
#donationTable th {
	text-align: center;
	background: thistle;
}
</style>

<div id="main">
<span id="boardtitle">후원</span>
<hr>
<span id="boardtitle">후원 받은 내역</span>
<br>

<div id="searchdonation">
<form action="/artist/donation" method="get">
<div style="float: right;">
	<select id='month' name='month' onchange="this.form.submit();">
		<c:if test="${selectedmonth eq 0 }">
			<option value='00' selected="selected">-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 1 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01' selected="selected">1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 2 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02' selected="selected">2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 3 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03' selected="selected">3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 4 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04' selected="selected">4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 5 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05' selected="selected">5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 6 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06' selected="selected">6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 7 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07' selected="selected">7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 8 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08' selected="selected">8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 9 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09' selected="selected">9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 10 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10' selected="selected">10월</option>
			<option value='11'>11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 11 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11' selected="selected">11월</option>
			<option value='12'>12월</option>
		</c:if>
		<c:if test="${selectedmonth eq 12 }">
			<option value='00'>-- 월 선택 --</option>
			<option value='01'>1월</option>
			<option value='02'>2월</option>
			<option value='03'>3월</option>
			<option value='04'>4월</option>
			<option value='05'>5월</option>
			<option value='06'>6월</option>
			<option value='07'>7월</option>
			<option value='08'>8월</option>
			<option value='09'>9월</option>
			<option value='10'>10월</option>
			<option value='11'>11월</option>
			<option value='12' selected="selected">12월</option>
		</c:if>
	</select>
</div>
</form>
</div><!-- searchdonation -->

<br>
<div id="donationContent">
<h4 style="font-weight: bold;" class="text-center">
<c:if test="${selectedmonth ne 0 }">
${selectedmonth }월 후원 내역
</c:if>
</h4>

<table id="donationTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th>후원한 사용자명</th>
		<th>후원 날짜</th>
		<th>후원 금액</th>
	</tr>

	<c:if test="${empty list }">
	<tr>
	<td colspan="4" style="color: thistle; font-weight: bold;">후원 내역이 없습니다</td>
	</tr>
	</c:if>

	<c:forEach var="info" items="${list }" varStatus="status">
	<c:set var="total" value="${total + info.donationPrice }" />

	<tr class="table-hover">
	<td>${info.rnum }</td>
	<td>${info.userName }</td>
	<td>${info.donationDate}</td>
	<td><fmt:formatNumber pattern="#,###" value="${info.donationPrice }" /></td>
	</tr>

	</c:forEach>
	<tr>
	<th colspan="3" style="text-align: right;">총 후원금액</th>
	<th><fmt:formatNumber pattern="#,###" value="${total }" /></th>
	</tr>
</table>
</div>

</div>
<c:import url="/WEB-INF/paging/artpagedonationpaging.jsp" />
<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>