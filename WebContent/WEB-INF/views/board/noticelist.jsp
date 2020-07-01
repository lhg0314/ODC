<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>
<style type="text/css">
#body{
	width: 1200px;
	margin: 0 auto;
}

#noticeHead{
	margin-top: 30px;
}


#noticeTable th {
	text-align: center;
	background: #ecdfec;
}

#noticeTable td {
	text-align: center;
}

#noticeTable td a:hover {

	text-decoration: none;
	color: black;
}

#noticeBoard{
	width: 1100px;
	margin: 0 auto;
}

#noticeTable{
	width: 1000px;
	margin: 0 auto;
}



</style>


<div id="body">

<div align="center" id="noticeHead">
<h3 style="color: thistle; font-weight: bold; ">&nbsp;공지사항</h3>
<small>사이트 이용에 관한 공지사항을 확인하세요</small>
</div>

<hr>

<table id="noticeTable" class="table text-center table-hover">
	<tr >
		<th style="width: 20%;">No.</th>
		<th style="width: 60%;">제목</th>
		<th style="width: 20%;">작성일</th>
	</tr>

	<c:if test="${empty list }">
		<tr>
		<td colspan="4" style="color: thistle; font-weight: bold;">공지사항 리스트가 없습니다</td>
		</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover" >
		<td>${info.noticeNo }</td>
		<td style="text-align: left; "><a href="/notice/view?noticeno=${info.noticeNo }">${info.noticeTitle }</a></td>
		<td>${info.noticeDate}</td>
	</tr>	
	
	</c:forEach>
</table>

</div>

<c:import url="/WEB-INF/paging/usernoticepaging.jsp" />
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>