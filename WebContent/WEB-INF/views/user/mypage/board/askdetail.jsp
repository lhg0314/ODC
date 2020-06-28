<!-- 마이페이지 - 문의내역 상세 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 

<style type="text/css">
#askViewTable th {
	text-align: center;
	background: thistle;
}
</style>

<div id="main">
<a href="/mypage/asklist" class="aTagStyleNone"><span id="boardtitle">활동 정보</span></a>
<hr>
<a href="/mypage/asklist" class="aTagStyleNone"><span id="boardtitle">클래스 문의 내역</span></a>
<br><br>

<table id="askViewTable" class="table table-condensed">
<thead>
	<tr>
		<th style="width: 10%;">제목</th>
		<td>${askdetail.askTitle }</td>
		<th style="width: 10%;">작성일</th>
		<td>${askdetail.askDate }</td>
	</tr>
	<tr>
		<th style="width: 10%;">클래스명</th>
		<td>${askdetail.className }</td>
		<th style="width: 10%;">작가명</th>
		<td>${askdetail.artName }</td>
	</tr>
</thead>
	<tr>
		<td colspan="4">${askdetail.askContent }</td>
	</tr>
</table>

<!-- 댓글 처리 -->
<div>

<hr>

<!-- 댓글 리스트 -->
<c:if test="${empty commlist }"></c:if>
<c:if test="${not empty commlist }">
<table class="table table-condensed">
<thead>
<tr>
	<th style="width: 5%;">번호</th>
	<th style="text-align: center;">답변</th>
	<th style="width: 20%;">작성일</th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commlist }" var="comment">
<tr>
	<td>${comment.askCommno }</td>
	<td>${comment.commContent }</td>
	<td>${comment.commDate }</td>
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->
</c:if>

</div>	<!-- 댓글 처리 end -->

</div>

<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>