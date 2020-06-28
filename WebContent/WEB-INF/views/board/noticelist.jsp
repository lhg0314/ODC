<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>
<style type="text/css">
#noticeTable th {
	text-align: center;
	background: #ecdfec;
}

#noticeBoard{
	width: 1100px;
	margin: 0 auto;
}
</style>
<div id="noticeBoard" >
<br>
<h4>게시판</h4>
<hr>
<h5>공지사항</h5><br>
<table id="noticeTable" class="table table-condensed text-center table-hover">
	<tr>
		<th style="width: 15%;">글번호</th>
		<th style="width: 55%;">제목</th>
		<th style="width: 30%;">작성일</th>
	</tr>

	<c:if test="${empty list }">
		<tr>
		<td colspan="4" style="color: thistle; font-weight: bold;">공지사항 리스트가 없습니다</td>
		</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover">
		<td>${info.noticeNo }</td>
		<td style="text-align: left;"><a href="/notice/view?noticeno=${info.noticeNo }">${info.noticeTitle }</a></td>
		<td>${info.noticeDate}</td>
	</tr>	
	
	</c:forEach>
</table>
</div>
<c:import url="/WEB-INF/paging/adminnoticepaging.jsp" />
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>