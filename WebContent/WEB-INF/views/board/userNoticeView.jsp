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
    vertical-align: middle;
}

#noticeTable td {
    vertical-align: middle;
    padding: 0 30px;
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

<table id="noticeTable" class="table table-condensed">
	<tr>
		<th style="width: 10%;">제목</th>
		<td style="height: 40px;">${noticeBoard.noticeTitle }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td style="height: 40px;">${noticeBoard.noticeDate }</td>
	</tr>
	<tr>
		<th>본문</th>
		<td style="height: 300px;">${noticeBoard.noticeContent }</td>
	</tr>
</table>

<br>

<div class="text-center">
<button id="btnDelete" class="btn btn-default" onclick="history.go(-1)">목록</button>
</div>

</div>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>