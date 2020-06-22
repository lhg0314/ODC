<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/donation?search="+$("#search").val();
	});
});
</script>

<div>
<h4>기부 관리</h4>
<hr>
<h5>작가 후원 관리</h5><br>
<input type="text" id="search" placeholder="작가 이름" value="${paging.search }"/>
<button type="button" id="btnSearch">검색</button><br><br>

<table id="classTable" class="table table-striped table-condensed">
	<tr class="danger">
		<th>작가명</th>
		<th>후원한 사용자명</th>
		<th>후원 금액</th>
		<th>후원 날짜</th>
	</tr>
	<c:forEach var="info" items="${list }" varStatus="status">
	<tr class="table-hover">
		<td>${info.artName }</td>
		<td>${info.userName }</td>
		<td>${info.donationPrice }</td>
		<td>${info.donationDate}</td>
	</tr>
	</c:forEach>
</table>
</div>

<c:import url="/WEB-INF/layout/paging/paging.jsp" />
<c:import url="/WEB-INF/layout/admin/footer.jsp" />