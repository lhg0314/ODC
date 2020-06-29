<!-- 관리자 페이지 - 작가 후원 내역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	$("#search").keydown(function(e) {
		if( e.keyCode == 13 ) {
			$("#btnSearch").click();
		}
	});
});
</script>

<style type="text/css">
#donationTable th {
	text-align: center;
	background: thistle;
}
</style>

<div>
<h4>기부 관리</h4>
<hr>
<h5>작가 후원 관리</h5><br>
<div id="searchdonation">
<form action="/admin/donation" method="get">

<div style="float: left;">
<input type="text" name="search" id="search" placeholder="작가 이름" value="${paging.search }"/>
<button type="submit" id="btnSearch">검색</button>
</div>

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
<div class="clearfix"></div>
<br>

<h4 class="text-center" style="font-weight: bold;">
<c:if test="${not empty searchedartist }">
${searchedartist }작가님&nbsp;&nbsp;
</c:if>
<c:if test="${selectedmonth ne 0 }">
${selectedmonth }월 후원 내역
</c:if>
</h4>

<table id="donationTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th>작가명</th>
		<th>후원한 사용자명</th>
		<th>후원 날짜</th>
		<th>후원 금액</th>
	</tr>

	<c:if test="${empty list }">
	<tr>
	<td colspan="5" style="color: thistle; font-weight: bold;">후원 내역이 없습니다</td>
	</tr>
	</c:if>

	<c:forEach var="info" items="${list }" varStatus="status">
	<c:set var="total" value="${total + info.donationPrice }" />

	<tr class="table-hover">
	<td>${info.rnum }</td>
	<td>${info.artName }</td>
	<td>${info.userName }</td>
	<td>${info.donationDate}</td>
	<td><fmt:formatNumber pattern="#,###" value="${info.donationPrice }" /></td>
	</tr>

	</c:forEach>
	<tr>
	<th colspan="4" style="text-align: right;">총 후원금액</th>
	<th><fmt:formatNumber pattern="#,###" value="${total }" /></th>
	</tr>
</table>
</div>

<c:import url="/WEB-INF/paging/admindonationpaging.jsp" />
<c:import url="/WEB-INF/layout/admin/footer.jsp" />