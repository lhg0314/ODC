<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>



<style type="text/css">
.container { 
	width: 960px; 
	text-align: center;
}
.table {
	display: inline-table;
	width: 850px;
	font-size: 13px;
	border: 1px solid #eee;
}
.tablehead { 
	background: #eee; 
}
</style>



<h3 style="font-weight: bold;">&nbsp;회원 관리</h3>
<hr>
<h6 style="font-weight: bold;">&nbsp;회원 상세정보</h6>



<div class="container">

	<br>
	
	<table class="table table-condensed">
	
		<tr class="tablehead">
			<th style="width: 20%; text-align: center;">회원번호</th>
			<th style="width: 20%; text-align: center;">이름</th>
			<th style="width: 20%; text-align: center;">아이디</th>
			<th style="width: 20%; text-align: center;">비밀번호</th>
			<th style="width: 20%; text-align: center;">닉네임</th>
		</tr>	
		
		<tr>
			<td>${userInfo.userno }</td>
			<td>${userInfo.username }</td>
			<td>${userInfo.userid }</td>
			<td>${userInfo.userpw }</td>
			<td>${userInfo.usernick }</td>
		</tr>	
		
	</table>
	
	<table class="table table-condensed">
		
		<tr class="tablehead">	
			<th style="width: 20%; text-align: center;">등급</th>
			<th style="width: 20%; text-align: center;">연락처</th>
			<th style="width: 20%; text-align: center;">생년월일</th>
			<th style="width: 30%; text-align: center;">이메일</th>
			<th style="width: 10%; text-align: center;">이메일인증</th>
		</tr>
		
		<tr>
			<c:if test="${userInfo.usergrade eq 1 }">
				<td>오디씨앗</td>
			</c:if>
			<c:if test="${userInfo.usergrade eq 2 }">
				<td>오디꽃</td>
			</c:if>
			<c:if test="${userInfo.usergrade eq 3 }">
			</c:if>
			<td>${userInfo.userphone }</td>
			<td>${userInfo.userbirth }</td>
			<td>${userInfo.useremail }</td>
			<c:if test="${userInfo.userEmailAuth eq 0 }">
				<td>X</td>
			</c:if>
			<c:if test="${userInfo.userEmailAuth eq 1 }">
				<td>O</td>
			</c:if>
		</tr>
	
	</table>
	
</div>


<br><br><br>
<h6 style="font-weight: bold;">&nbsp;회원 예약 클래스</h6>

<div class="container">
</div>




<br><br><br>
<h6 style="font-weight: bold;">&nbsp;회원 작성 게시글</h6>

<div class="container">
</div>


<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>