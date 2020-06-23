<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
<ul class="pagination">
	
	<!-- 첫 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
	<li><a href="/admin/talent?curPage=1&&search=${param.search }">&laquo;</a></li>
	</c:if>
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
	<li><a href="/admin/talent?curPage=${paging.curPage - 1 }&search=${param.search }">&lt;</a>
	</c:if>
	
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	<!-- 현재 페이지라면 강조(.active) -->
	<c:if test="${paging.curPage eq i }">
	<li class="active"><a href="/admin/talent?curPage=${i }&search=${param.search }">${i }</a></li>
	</c:if>
	
	<!-- 현재 페이지가 아니라면 평소 모습-->
	<c:if test="${paging.curPage ne i }">
	<li><a href="/admin/talent?curPage=${i }&search=${param.search }">${i }</a></li>
	</c:if>
	</c:forEach>

	<!-- 다음 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage}">
	<li><a href="/admin/talent?curPage=${paging.curPage + 1 }&search=${param.search }">&gt;</a>
	</c:if>

 	<!-- 마지막 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage }">
	<li><a href="/admin/talent?curPage=${paging.totalPage }&search=${param.search }">&raquo;</a></li>
	</c:if>
	
</ul>
</div>