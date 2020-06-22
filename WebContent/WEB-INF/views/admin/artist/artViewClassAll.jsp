<!-- 200621 이서연 -->
<!-- 관리자페이지 > 사업자정보 > 사업자 상세정보 > 사업자개설클래스 전체보기.jsp -->



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

 
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

#viewmore { 

	text-decoration: none;
    font-size: 14px;
    margin: 10px 40px;
}

</style>



<h3 style="font-weight: bold;">&nbsp;사업자 관리</h3>
<hr>
<h6 style="font-weight: bold;">&nbsp;사업자 상세정보</h6>



<div class="container">

<br><br><br>
<h6 style="font-weight: bold;">&nbsp;작가 개설 클래스 전체</h6>

	<br>
		
	<table class="table table-condensed">
		
			<tr class="tablehead">
				<th style="width: 10%; text-align: center;">클래스번호</th>
				<th style="width: 30%; text-align: center;">클래스명</th>
				<th style="width: 15%; text-align: center;">지역</th>
				<th style="width: 15%; text-align: center;">카테고리</th>
				<th style="width: 15%; text-align: center;">금액</th>
				<th style="width: 15%; text-align: center;">등록일</th>
			</tr>	
			
			<c:forEach items="${classList }" var="cl">
			<tr>
				<td>${cl.classno }</td>
				<td>${cl.className }</td>
				
				<c:if test="${cl.location eq 1}">
					<td>서울</td>
				</c:if>
				<c:if test="${cl.location eq 2}">
					<td>경기</td>
				</c:if>
				<c:if test="${cl.location eq 3}">
					<td>강원</td>
				</c:if>
				<c:if test="${cl.location eq 4}">
					<td>충청</td>
				</c:if>
				<c:if test="${cl.location eq 5}">
					<td>경상</td>
				</c:if>
				<c:if test="${cl.location eq 6}">
					<td>전라</td>
				</c:if>
				<c:if test="${cl.location eq 7}">
					<td>제주</td>
				</c:if>
				
				<c:if test="${cl.category eq 1}">
					<td>플라워</td>
				</c:if>
				<c:if test="${cl.category eq 2}">
					<td>음악</td>
				</c:if>
				<c:if test="${cl.category eq 3}">
					<td>수공예</td>
				</c:if>
				<c:if test="${cl.category eq 4}">
					<td>요리</td>
				</c:if>
				<c:if test="${cl.category eq 5}">
					<td>뷰티</td>
				</c:if>
				<c:if test="${cl.category eq 6}">
					<td>미술</td>
				</c:if>
				<c:if test="${cl.category eq 7}">
					<td>기타</td>
				</c:if>
				
				<td>${cl.classprice }</td>
				<td>${cl.postdate }</td>
			</tr>	
			</c:forEach>
			
		</table>
		
</div>



