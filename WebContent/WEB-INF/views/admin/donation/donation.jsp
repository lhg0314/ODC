<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/donation?search="+$("#search").val();
	});
	
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
	background: #ecdfec;
}
</style>

<div>
<h4>기부 관리</h4>
<hr>
<h5>작가 후원 관리</h5><br>
<div id="searchdonation">
<div style="float: left;"><input type="text" id="search" placeholder="작가 이름" value="${paging.search }"/>
<button type="button" id="btnSearch">검색</button></div>
<div style="float: right;">
<form action="/admin/donation" method="post">
	<select id='month' name='month' onchange="this.form.submit();">
	  <option selected="selected">-- 월 선택 --</option>
	  <option value='01'  >1월</option>
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
	 </select>
</form>
</div>
</div><!-- searchdonation -->
<div class="clearfix"></div>
<br>

<c:if test="${not empty selectedmonth }">
<h5 class="text-center">${selectedmonth }월 후원 내역</h5>
</c:if>
<table id="donationTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>작가명</th>
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
	<td>${info.artName }</td>
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

<c:import url="/WEB-INF/paging/admindonationpaging.jsp" />
<c:import url="/WEB-INF/layout/admin/footer.jsp" />