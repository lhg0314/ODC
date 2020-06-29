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

#noticeTable{
	width: 1000px;
	margin: 0 auto;
}
</style>
<div id="noticeBoard" >
<br>
<h4>게시판</h4>
<hr>
<h5>공지사항</h5><br>
<table id="noticeTable" class="table table-condensed">
	<tr>
		<th style="width: 10%;">제목</th>
		<td>${noticeBoard.noticeTitle }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${noticeBoard.noticeDate }</td>
	</tr>
	<tr>
		<th>본문</th>
		<td>${noticeBoard.noticeContent }</td>
	</tr>
</table>
<br>
<div class="text-center">
<button id="btnDelete" class="btn btn-default" onclick="history.go(-1)">목록</button>
</div>
</div>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>