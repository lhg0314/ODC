<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>

<style type="text/css">

#SnvClassPost{
	background: #ecdfec;
}

#classReviewTable th{
	text-align: center;
}
#classReviewTable tr:first-child{
	background: thistle;
}
</style>

<%-- 클래스별 후기 확인 페이지 --%>
<%-- 20200620 구동영 --%>
<h4 style="font-weight: bold;">&nbsp;클래스 관리</h4>
<hr>
<h5 style="font-weight: bold;">&nbsp;<a href="/admin/class/post">클래스 정보</a> > <a href="javascript:history.go(-1)">클래스 상세 정보</a> > 클래스 후기</h5>
<br>
<br>

<c:if test="${paging.totalCount eq 0 }">
<h3>작성된 후기 없음</h3>
<br>
</c:if>
<c:if test="${paging.totalCount ne 0 }">
<table id="classReviewTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th style="width: 60%;">내용</th>
		<th style="width: 10%;">만족도</th>
		<th>작성자</th>
		<th>작성날짜</th>
	</tr>
	<c:forEach var="info" items="${list }">
	<tr class="table-hover">
		<td>${info.reviewNo }</td>
		<td>${info.reviewContent }</td>
		<td>${info.satLevel }</td>
		<td>${info.userId }</td>
		<td>${info.reviewDate }</td>
	</tr>
	</c:forEach>

</table>
<c:import url="/WEB-INF/paging/pagingClassReview.jsp" />
 </c:if>
<div class="text-center">
<button type="button" class="btn btn-default" id="btnBack" onclick="location.href='/admin/class/view?classno=${classno }&view=post'">클래스 상세보기로</button>
</div>
<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>