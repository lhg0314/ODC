<!-- 200621 이서연 -->
<!-- 관리자페이지 > 작가정보 > 작가 상세정보.jsp -->


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
	float:right; 
	text-decoration: none;
    font-size: 14px;
    margin: 10px 40px;
}

</style>




<h3 style="font-weight: bold;">&nbsp;사업자 관리</h3>
<hr>
<h6 style="font-weight: bold;">&nbsp;사업자 상세정보</h6>



<div class="container">

	<br>

	<table class="table table-condensed">
	
		<tr class="tablehead">
			<th style="width: 25%; text-align: center;">사업자번호</th>
			<th style="width: 25%; text-align: center;">이름</th>
			<th style="width: 25%; text-align: center;">아이디</th>
			<th style="width: 25%; text-align: center;">비밀번호</th>
		</tr>	
		
		<tr>
			<td>${artistInfo.artno }</td>
			<td>${artistInfo.artName }</td>
			<td>${artistInfo.artid }</td>
			<td>${artistInfo.artpw }</td>
		</tr>	
		
	</table>
	
	<table class="table table-condensed">
		
		<tr class="tablehead">	
			<th style="width: 20%; text-align: center;">닉네임</th>
			<th style="width: 20%; text-align: center;">생년월일</th>
			<th style="width: 40%; text-align: center;">이메일</th>
			<th style="width: 20%; text-align: center;">사업자등록번호</th>
		</tr>
		
		<tr>
			<td>${artistInfo.artNick }</td>
			<td>${artistInfo.artBirth }</td>
			<td>${artistInfo.artEmail }</td>
			<td>${artistInfo.artCode }</td>
		</tr>
		
	</table>
		
	<table class="table table-condensed">
		
		<tr class="tablehead">	
			
			<th style="width: 20%; text-align: center;">휴대폰번호</th>
			<th style="width: 20%; text-align: center;">공방전화번호</th>
			<th style="width: 60%; text-align: center;">공방주소</th>
		</tr>
		
		<tr>
			<td>${artistInfo.artPhone }</td>
			<td>${artistInfo.artTel }</td>
			<td>${artistInfo.artAddr }</td>
		</tr>
	
	</table>
	
	<table class="table table-condensed">
		
		<tr class="tablehead">	
			<th style="width: 100%; text-align: center;">작가소개글</th>
		</tr>
		
		<tr>
			<td>${artistInfo.artContent }</td>
		</tr>
	
	</table>
	
</div>



<br><br>
<h6 style="font-weight: bold;">&nbsp;작가 개설 클래스</h6>

<div class="container">

	<c:set var="c" value="class"/>
	<a href="/admin/artviewall?artno=${artistInfo.artno}&cate=${c}" id="viewmore">전체보기 &raquo;</a>
	
	<table class="table table-condensed">
		
			<tr class="tablehead">
				<th style="width: 10%; text-align: center;">클래스번호</th>
				<th style="width: 30%; text-align: center;">클래스명</th>
				<th style="width: 15%; text-align: center;">지역</th>
				<th style="width: 15%; text-align: center;">카테고리</th>
				<th style="width: 15%; text-align: center;">금액</th>
				<th style="width: 15%; text-align: center;">등록일</th>
			</tr>	
			
			<c:forEach items="${classList }" var="cl" begin="0" end="2">
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


<br><br>
<h6 style="font-weight: bold;">&nbsp;작가 문의 답변</h6>

<div class="container">

	<c:set var="comm" value="comm"/>
	<a href="/admin/artviewall?artno=${artistInfo.artno}&cate=${comm}" id="viewmore">전체보기 &raquo;</a>
	
	
		<c:forEach items="${askCommList }" var="cm" begin="0" end="2">
		
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









<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>