<!-- 관리자 후기상세 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />

<style type="text/css">
#reviewViewTable th {
	text-align: center;
	background: thistle;
}
</style>

<div id="main">
<a href="/mypage/reviewlist" class="aTagStyleNone"><span id="boardtitle">활동 정보</span></a>
<hr>
<a href="/mypage/reviewlist" class="aTagStyleNone"><span id="boardtitle">클래스 후기</span></a>
<br><br>

<table id="reviewViewTable" class="table table-condensed">
<thead>
	<tr>
		<th style="width: 10%;">제목</th>
		<td>${reviewdetail.reviewTitle }</td>
		<th style="width: 10%;">작성일</th>
		<td>${reviewdetail.reviewDate }</td>
	</tr>
	<tr>
		<th style="width: 10%;">클래스명</th>
		<td>${reviewdetail.className }</td>
		<th style="width: 10%;">작가명</th>
		<td>${reviewdetail.artName }</td>
	</tr>
	<tr><th>만족도</th><td>${reviewdetail.satLevel }</td></tr>
</thead>
	<c:if test="${not empty reviewdetail.filename }">
		<tr><td><img src="/upload/${reviewdetail.filename }"></td></tr>
	</c:if>
	<tr>
		<td colspan="4">${reviewdetail.reviewContent }</td>
	</tr>
</table>


<div class="text-center">
<button class="btn btn-default" onclick="history.go(-1)">목록</button>
</div>

</div>

<!-- float 막기 -->
<div class="clearfix"></div>

<c:import url="/WEB-INF/layout/admin/footer.jsp" />