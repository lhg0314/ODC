<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnList").click(function(){
		history.go(-1);
	})
	
	$("#btnPostUpdate").click(function(){
		$("#postAjax").html("");
		
		$.ajax({
			type: "post"// 요청 메소드
			, url: "/admin/class/post"
			, data: {
				"classno" : $("#classno").text()
				, "postStatus" : $("#postStatus").val()
			}
			, dataType: "html"
			, success: function(res){
				console.log("성공")
				
				var message = JSON.parse(res);
								
				
				$("#postAjax").html(message.mes);
			}
			, error: function(){
				console.log("실패")
			}
		})
		
	})
	
});
</script>

<style type="text/css">
#classInfoTable{
	font-size: 14px;
}
#SnvClassPost{
	background: #ecdfec;
}
#classInfoTable th{
	background: thistle;
}
#postAjax{
	color: green;
	width: 150px;
	display: inline-block;
}
#classFile{
	width: 70%;
}


</style>

<%-- 클래스 상세 페이지 --%>
<%-- 20200620 구동영 --%>
<h4 style="font-weight: bold;">&nbsp;클래스 관리</h4>
<hr>
<h5 style="font-weight: bold;">&nbsp;클래스 정보 > 클래스 상세 정보</h5>
<br>
<div>

<table class="table table-bordered" id="classInfoTable">
<tr>
	<th style="width: 15%;">클래스 이름</th>
	<td>${info.className }</td>
	<th style="width: 15%;">클래스 번호</th>
	<td id="classno">${info.classNo }</td>
</tr>
<tr>
	<th>카테고리</th>
	<td>
		<c:if test="${info.category eq 1}">플라워</c:if>
		<c:if test="${info.category eq 2}">음악</c:if>
		<c:if test="${info.category eq 3}">수공예</c:if>
		<c:if test="${info.category eq 4}">요리</c:if>
		<c:if test="${info.category eq 5}">뷰티</c:if>
		<c:if test="${info.category eq 6}">미술</c:if>
		<c:if test="${info.category eq 7}">기타</c:if>
	</td>
	<th>지역</th>
	<td>
		<c:if test="${info.location eq 1}">서울</c:if>
		<c:if test="${info.location eq 2}">경기</c:if>
		<c:if test="${info.location eq 3}">강원</c:if>
		<c:if test="${info.location eq 4}">충청</c:if>
		<c:if test="${info.location eq 5}">경상</c:if>
		<c:if test="${info.location eq 6}">전라</c:if>
		<c:if test="${info.location eq 7}">제주</c:if>
	</td>
</tr>
<tr>
	<th>가격</th>
	<td>${info.classPrice } 원</td>
	<th>재능기부</th>
	<td>
		<c:if test="${info.talentDonation eq 0 }" >N</c:if>
		<c:if test="${info.talentDonation eq 1 }" >Y</c:if>
	</td>
</tr>
<tr>
	<th>모집일자</th>
	<td>${info.recruitStartdate} ~ ${info.recruitEnddate }</td>
	<th>클래스 진행 일자</th>
	<td>${info.classStartdate} ~ ${info.classEnddate }</td>
</tr>
<tr>
	<th>모집 인원</th>
	<td>${info.minPeople } ~ ${info.maxPeople} 명</td>
	<th>게시 상태 변경</th>
	<td>
		<select name="postStatus" id="postStatus">
		<c:choose>
		<c:when test="${info.postStatus eq 0 }">
			<option value="1">게시</option>
			<option value="0" selected="selected">삭제</option>
		</c:when>
		<c:when test="${info.postStatus eq 1 }">
			<option value="1" selected="selected">게시</option>
			<option value="0">삭제</option>
		</c:when>
		</c:choose>
		</select>
	<button type="button" id="btnPostUpdate">저장</button>
	<div id="postAjax"></div>
	</td>
</tr>
<tr>
	<th colspan="4">클래스 상세 설명</th>
</tr>
<tr>
	<td colspan="4">${info.classContent }</td>
</tr>
<tr>
	<th colspan="4">첨부 파일</th>
</tr>
<tr>
	<td colspan="4" style="text-align: center;"><img id="classFile" src="/upload/${info.classRenameFilename }"/></td>
</tr>
<tr>
	<th colspan="4"><a href="/admin/class/review?classno=${info.classNo }">&raquo; 클래스 후기보기</a></th>
</tr>
</table>
<div class="text-center">
<button type="button" class="btn btn-default" id="btnList">목록</button>
</div>

</div>

<c:import url="/WEB-INF/layout/admin/footer.jsp"></c:import>