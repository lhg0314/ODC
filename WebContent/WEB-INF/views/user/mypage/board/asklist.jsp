<!-- 마이페이지 문의리스트 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 

<script type="text/javascript">
$(document).ready(function(){
	//검색 버튼 클릭
	$("#btnaSearch").click(function() {
		location.href="/mypage/asklist?search="+$("#asearch").val();
	});
	
	$("#asearch").keydown(function(e) {
		if( e.keyCode == 13 ) {
			$("#btnaSearch").click();
		}
	});
});
</script>

<style type="text/css">
#askTable th {
	text-align: center;
	background: #ecdfec;
}
</style>
<div>
<h4>활동정보</h4>
<hr>
<h5>클래스 문의 내역</h5><br>

<div>
<input type="text" id="asearch" placeholder="클래스명" value="${paging.search }"/>
<button type="button" id="btnaSearch">검색</button><br><br>
</div>

<table id="askTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th>작가명</th>
		<th style="width: 30%;">클래스명</th>
		<th style="width: 30%;">제목</th>
		<th>게시 날짜</th>
	</tr>

	<c:if test="${empty list }">
	<tr>
		<td colspan="6" style="color: thistle; font-weight: bold;">문의 내역이 없습니다</td>
	</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover">
		<td>${info.askNo }</td>
		<td>${info.artName }</td>
		<td style="text-align: left;"><a href="/class/view?classno=${info.classNo }">${info.className}</a></td>
		<td style="text-align: left;"><a href="/ask/view?askno=${info.askNo }">${info.askTitle }</a></td>
		<td>${info.askDate }</td>
	</tr>	
	
	</c:forEach>
</table>
<div id="btnBox" style="text-align: right;">
<button id="btnDelete" class="btn btn-warning">삭제</button>
</div>
</div>
<c:import url="/WEB-INF/paging/mypageaskpaging.jsp" />

<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>