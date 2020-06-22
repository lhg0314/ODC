<!-- 200620 이서연 -->
<!-- 관리자페이지 > 사용자정보 > 사용자 상세정보.jsp -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>


<script type="text/javascript" 
  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<style type="text/css">

.container { 

	width: 960px; 
	text-align: center;
}

.table {

	display: inline-table;
	width: 850px;
	font-size: 14px;
}

.searchBtn {

	margin: 30px 60px;
	float: right;
}

.tablehead { background: thistle; }

</style>



<script type="text/javascript">
$(document).ready(function() {
	
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/userlist?search="+$("#search").val();
	})
	
})
</script>





<h3 style="font-weight: bold;">&nbsp;회원 관리</h3> 
<hr>
<h6 style="font-weight: bold;">&nbsp;회원 정보</h6>




<div class="searchBtn form-inline">
	<input type="text" id="search" placeholder="아이디 입력"/>
	<button id="btnSearch">검색</button>
</div>


<div class="container">
	

	<br>
	
	<table class="table table-hover table-condensed">
	
		<tr class="tablehead">
			<th style="width: 10%; text-align: center;">회원번호</th>
			<th style="width: 15%; text-align: center;">이름</th>
			<th style="width: 15%; text-align: center;">아이디</th>
			<th style="width: 25%; text-align: center;">이메일</th>
			<th style="width: 10%; text-align: center;">등급</th>
			<th style="width: 15%; text-align: center;">닉네임</th>
			<th style="width: 10%; text-align: center;">회원상세</th>
		</tr>
		
		<c:forEach items="${userList }" var="u">
		<tr>
			<td>${u.userno }</td>
			<td>${u.username }</td>
			<td>${u.userid }</td>
			<td>${u.useremail }</td>
			<c:if test="${u.usergrade eq 1 }">
				<td>오디씨앗</td>
			</c:if>
			<c:if test="${u.usergrade eq 2 }">
				<td>오디꽃</td>
			</c:if>
			<c:if test="${u.usergrade eq 3 }">
				<td>오디나무</td>
			</c:if>
			<td>${u.usernick }</td>
			<td><a href="/admin/userview?userno=${u.userno }"><button>상세정보</button></a></td>
		</tr>
		</c:forEach>
	
	</table>
	
	<c:import url="/WEB-INF/paging/pagingUser.jsp"/>

</div>



<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>