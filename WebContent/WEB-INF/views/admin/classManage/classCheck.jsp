<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
	
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/class/check?search="+$("#search").val();
	});
});


</script>

<style type="text/css">

#SnvClassCheck{
	background: #ecdfec;
}
#classTable th{
	text-align: center;
}
#classTable tr:first-child{
	background: #ecdfec;
}
</style>

<%-- 클래스 게시/삭제 페이지 --%>
<%-- 20200620 구동영 --%>
<h4 >&nbsp;클래스 관리</h4>
<hr>
<h5>&nbsp;클래스 검토</h5>
<h6>&nbsp;&nbsp;검토 신청을 한 클래스의 계획서를 확인하고 검토 상태를 변경하거나 사이트에 등록할 수 있다.</h6>
<br>
<input type="text" id="search" placeholder="클래스명" value="${paging.search }"/>
<button type="button" id="btnSearch">검색</button><br>
<br>
<table id="classTable" class="table table-striped table-condensed text-center">
	<tr>
		<th>번호</th>
		<th>클래스명</th>
		<th>사업자 아이디</th>
		<th>카테고리</th>
		<th>지역</th>
		<th>신청 날짜</th>
		<th>클래스 계획서</th>
		<th>진행 상황</th>
	</tr>
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
		<td><button type="button" onclick="location.href='/admin/class/view?classno=${info.classNo }&view=check'">상세정보</button></td>
		<td>
		<c:if test="${info.classCheck eq 0}">검토 신청</c:if>
		<c:if test="${info.classCheck eq 2}">검토 중</c:if>
		<c:if test="${info.classCheck eq 3}">반려</c:if>
		</td>
	</tr>
	</c:forEach>

</table>
<c:import url="/WEB-INF/paging/pagingClassCheck.jsp" />
 
<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>