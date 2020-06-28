<!-- 작가페이지 - 후기 상세 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!-- main header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<style type="text/css">
#askViewTable th {
	text-align: center;
	background: thistle;
}
</style>

<div id="main">
<span id="boardtitle">게시판</span>
<hr>
<span id="boardtitle">후기 게시판</span>
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
		<th style="width: 10%;">작성자</th>
		<td>${reviewdetail.userName }</td>
	</tr>
</thead>
	<tr><td><img src="/upload/${reviewdetail.filename }"></td></tr>
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

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>