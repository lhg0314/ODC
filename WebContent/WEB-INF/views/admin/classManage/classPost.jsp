<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
	
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/class/post?search="+$("#search").val();
	});
});


</script>

<style type="text/css">

#SnvClassPost{
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
<h5>&nbsp;클래스 정보</h5>
<h6>&nbsp;&nbsp;클래스 게시 상태를 변경할 수 있고 예약 현황을 확인할 수 있다.</h6>
<br>

<input type="text" id="search" placeholder="클래스명" value="${paging.search }"/>
<button type="button" id="btnSearch">검색</button><br>
<br>
<table id="classTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th style="width: 23%;">클래스명</th>
		<th>사업자 아이디</th>
		<th>카테고리</th>
		<th>지역</th>
		<th>게시 날짜</th>
		<th>게시 상태</th>
		<th>상세 정보</th>
		<th>예약 현황</th>
	</tr>
	<c:forEach var="info" items="${list }">
	<tr class="table-hover">
		<td>${info.classNo }</td>
		<td>${info.className }</td>
		<td>${info.artId }</td>
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
		<td>
		<c:if test="${info.postStatus eq 1}">게시</c:if>
		<c:if test="${info.postStatus eq 0}">삭제</c:if>
		</td>
		<td><button type="button" onclick="location.href='/admin/class/view?classno=${info.classNo }&view=post'">상세 정보</button></td>
		<td><button type="button" onclick="location.href='/admin/class/book?classno=${info.classNo }'">예약 현황</button></td>
	</tr>
	</c:forEach>

</table>
<c:import url="/WEB-INF/paging/pagingClassPost.jsp" />
 
<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>