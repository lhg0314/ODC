<!-- 마이페이지 후기리스트 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 

<script type="text/javascript">
$(document).ready(function(){
	//검색 버튼 클릭
	$("#btnrSearch").click(function() {
		location.href="/mypage/reviewlist?search="+$("#rsearch").val();
	});
	
	$("#rsearch").keydown(function(e) {
		if( e.keyCode == 13 ) {
			$("#btnrSearch").click();
		}
	});
});
</script>

<style type="text/css">
#reviewTable th {
	text-align: center;
	background: #ecdfec;
}
</style>

<div id="main">
<a href="/mypage/reviewlist" class="aTagStyleNone"><span id="boardtitle">활동 정보</span></a>
<hr>
<a href="/mypage/reviewlist" class="aTagStyleNone"><span id="boardtitle">클래스 수강 후기</span></a>
<br>

<div>
<input type="text" id="rsearch" placeholder="클래스명" value="${paging.search }"/>
<button type="button" id="btnrSearch">검색</button><br><br>
</div>

<table id="reviewTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th style="width: 30%;">클래스명</th>
		<th style="width: 40%;">제목</th>
		<th>게시 날짜</th>
	</tr>

	<c:if test="${empty list }">
	<tr>
		<td colspan="4" style="color: thistle; font-weight: bold;">후기게시판 리스트가 없습니다</td>
	</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover">
		<td>${info.reviewNo }</td>
		<td style="text-align: left;"><a href="/class/view?classno=${info.classNo }">${info.className}</a></td>
		<td style="text-align: left;"><a href="/review/view?reviewno=${info.reviewNo }">${info.reviewTitle }</a></td>
		<td>${info.reviewDate }</td>
	</tr>	
	
	</c:forEach>
</table>
</div>

<c:import url="/WEB-INF/paging/mypagereviewpaging.jsp" />

<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>