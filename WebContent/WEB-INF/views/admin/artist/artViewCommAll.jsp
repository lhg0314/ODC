<!-- 200621 이서연 -->
<!-- 관리자페이지 > 사업자정보 > 사업자 상세정보 > 사업자 문의답변 전체보기.jsp -->

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
<h6 style="font-weight: bold;">&nbsp;작가 문의 답변 전체</h6>

	<br><br>
		
		<c:forEach items="${askCommList }" var="cm">
		
			<table class="table table-condensed">
			
				<tr class="tablehead">
					<th style="width: 10%; text-align: center;">문의번호</th>
					<th style="width: 15%; text-align: center;">문의사용자번호</th>
					<th style="width: 15%; text-align: center;">클래스이름</th>
					<th style="width: 40%; text-align: center;">문의내용</th>
					<th style="width: 20%; text-align: center;">등록일</th>
				</tr>	
				<tr>
					<td>${cm.askBoardNo }</td>
					<td>${cm.userNo }</td>
					<td>${cm.classname }</td>
					<td>${cm.askContent }</td>
					<td>${cm.askDate }</td>
				</tr>	
				
				<tr class="tablehead">
					<th style="width: 10%; text-align: right;"></th>
					<th style="width: 10%; text-align: right;"></th>
				 	<th style="width: 10%; text-align: center;">답변번호</th>
					<th style="width: 50%; text-align: center;">답변내용</th>
					<th style="width: 20%; text-align: center;">등록일</th>
				</tr>	
				<tr>
					<td></td>
					<td></td>
					<td>${cm.askCommNo }</td>
					<td>${cm.commContent }</td>
					<td>${cm.commDate }</td>
				</tr>	
			
			</table>
			
			<br><br>
			
		</c:forEach>
		
</div>
