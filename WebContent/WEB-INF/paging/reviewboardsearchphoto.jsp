<!-- 이인주 20200628 -->
<!-- 후기게시판 - 클래스 이름 검색 - 포토 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
<ul class="pagination">
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
	<li><a href="/review/board/search/pho?curPage=${paging.curPage - 1 }&classname=${classname }">&lt;</a>
	</c:if>
	
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	
	<!-- 현재 페이지라면 강조(.active) -->
	<c:if test="${paging.curPage eq i }">
	<li class="active"><a href="/review/board/search/pho?curPage=${i }&classname=${classname }">${i }</a></li>
	</c:if>
	
	<!-- 현재 페이지가 아니라면 평소 모습-->
	<c:if test="${paging.curPage ne i }">
	<li><a href="/review/board/search/pho?curPage=${i }&classname=${classname }">${i }</a></li>
	</c:if>

	</c:forEach>


	<!-- 다음 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage}">
	<li><a href="/review/board/search/pho?curPage=${paging.curPage + 1 }&classname=${classname }">&gt;</a>
	</c:if>
	
</ul>
</div>