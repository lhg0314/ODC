<!-- 이인주 20200621 -->
<!-- 사업자 선택하고 사업자 아이디 검색했을 때 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
<ul class="pagination">
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
	<li><a href="/admin/artsales/search?curPage=${paging.curPage - 1 }&artid=${artid }">&lt;</a>
	</c:if>
	
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	
	<!-- 현재 페이지라면 강조(.active) -->
	<c:if test="${paging.curPage eq i }">
	<li class="active"><a href="/admin/artsales/search?curPage=${i }&artid=${artid }">${i }</a></li>
	</c:if>
	
	<!-- 현재 페이지가 아니라면 평소 모습-->
	<c:if test="${paging.curPage ne i }">
	<li><a href="/admin/artsales/search?curPage=${i }&artid=${artid }">${i }</a></li>
	</c:if>

	</c:forEach>

	<!-- 다음 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage}">
	<li><a href="/admin/artsales/search?curPage=${paging.curPage + 1 }&artid=${artid }">&gt;</a>
	</c:if>
	
</ul>
</div>