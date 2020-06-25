<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/talent?search="+$("#search").val();
	});
	
	$("#search").keydown(function(e) {
		if( e.keyCode == 13 ) {
			$("#btnSearch").click();
		}
	});
});
</script>
<style type="text/css">
#talentTable th {
	text-align: center;
	background: #ecdfec;
}
</style>
<div>
<h4>기부 관리</h4>
<hr>
<h5>재능기부 클래스</h5><br>

<input type="text" id="search" placeholder="클래스명" value="${paging.search }"/>
<button type="button" id="btnSearch">검색</button><br><br>

<table id="talentTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th style="width: 23%;">클래스명</th>
		<th>사업자 아이디</th>
		<th>카테고리</th>
		<th>지역</th>
		<th>신청 날짜</th>
		<th>상세 정보</th>
		<th>진행 상황</th>
	</tr>

	<c:if test="${empty list }">
		<tr>
		<td colspan="8" style="color: thistle; font-weight: bold;">기부 클래스 리스트가 없습니다</td>
		</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover">
	<td>${info.classNo }</td>
	<td>${info.className }</td>
	<td>${info.artId}</td>
	<td>
	<c:if test="${info.category eq 1}">플라워</c:if>
	<c:if test="${info.category eq 2}">음악</c:if>
	<c:if test="${info.category eq 3}">수공예</c:if>
	<c:if test="${info.category eq 4}">요리</c:if>
	<c:if test="${info.category eq 5}">뷰티</c:if>
	<c:if test="${info.category eq 6}">미술</c:if>
	<c:if test="${info.category eq 7}">기타</c:if>
	</td>
	<td>
	<c:if test="${info.location eq 1}">서울</c:if>
	<c:if test="${info.location eq 2}">경기</c:if>
	<c:if test="${info.location eq 3}">강원</c:if>
	<c:if test="${info.location eq 4}">충청</c:if>
	<c:if test="${info.location eq 5}">경상</c:if>
	<c:if test="${info.location eq 6}">전라</c:if>
	<c:if test="${info.location eq 7}">제주</c:if>
	</td>
	<td>${info.postDate }</td>
	<td><button type="button" onclick="location.href='/admin/class/view?classno=${info.classNo }&view=post'">상세 정보</button></td>
	<td>
	<c:if test="${info.classCheck eq 0}">검토 신청</c:if>
	<c:if test="${info.classCheck eq 1}">검토 완료</c:if>
	<c:if test="${info.classCheck eq 2}">검토 중</c:if>
	<c:if test="${info.classCheck eq 3}">반려</c:if>
	</td>
	</tr>	
	
	</c:forEach>
</table>
</div>
<c:import url="/WEB-INF/paging/admintalentpaging.jsp" />
<c:import url="/WEB-INF/layout/admin/footer.jsp" />