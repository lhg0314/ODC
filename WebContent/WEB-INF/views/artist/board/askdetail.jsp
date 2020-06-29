<!-- 작가페이지 - 문의내역 상세 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!-- main header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 


<script type="text/javascript">
$(document).ready(function() {
	// 댓글 입력
	$("#btnCommInsert").click(function() {
		$form = $("<form>").attr({
			action: "/askcomm/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"askno",
				value:"${askdetail.askNo }"
			})
		).append(
			$("<textarea>")
				.attr("name", "content")
				.css("display", "none")
				.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
		
	});
	
});

//댓글 삭제
function deleteComment(commentNo) {
	$.ajax({
		type: "post"
		, url: "/artist/cdelete"
		, dataType: "json"
		, data: {
			commentNo: commentNo
		}
		, success: function(data){
			if(data.success) {
				
				$("[data-commentno='"+commentNo+"']").remove();
				
			} else {
				alert("댓글 삭제 실패");
			}
		}
		, error: function() {
			console.log("error");
		}
	});
}
</script>

<style type="text/css">
#askViewTable th {
	text-align: center;
	background: thistle;
}
</style>

<div id="main">
<span id="boardtitle">게시판</span>
<hr>
<span id="boardtitle">고객 문의 내역</span>
<br><br>

<table id="askViewTable" class="table table-condensed">
<thead>
	<tr>
		<th style="width: 10%;">제목</th>
		<td>${askdetail.askTitle }</td>
		<th style="width: 10%;">작성일</th>
		<td>${askdetail.askDate }</td>
	</tr>
	<tr>
		<th style="width: 10%;">클래스명</th>
		<td>${askdetail.className }</td>
		<th style="width: 10%;">작가명</th>
		<td>${askdetail.artName }</td>
	</tr>
</thead>
	<tr>
		<td colspan="4">${askdetail.askContent }</td>
	</tr>
</table>
<br><br>

<!-- 댓글 처리 -->
<div>
<hr>

<!-- 댓글 리스트 -->
<c:if test="${empty commlist }"></c:if>
<c:if test="${not empty commlist }">
<table class="table table-condensed">
<thead>
<tr>
	<th style="width: 5%;">번호</th>
	<th style="text-align: center;">답변</th>
	<th style="width: 20%;">작성일</th>
	<th style="width: 10%;">&nbsp;</th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commlist }" var="comment">
<tr data-commentno="${comment.askCommno }">
	<td>${comment.askCommno }</td>
	<td>${comment.commContent }</td>
	<td>${comment.commDate }</td>
	<td><button class="btn btn-xs w3-button w3-black"
			onclick="deleteComment(${comment.askCommno });">답변 삭제</button></td>
</tr>
</c:forEach>
</tbody>	
</table>	<!-- 댓글 리스트 end -->
</c:if>

<br>
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<textarea rows="2" cols="100" class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn w3-button" style="height: 54px; background: thistle;">답변 달기</button>
</div>	<!-- 댓글 입력 end -->

</div>	<!-- 댓글 처리 end -->
<br>
<div class="text-center">
<button class="btn btn-default" onclick="location.href='/artist/asklist'">목록</button>
</div>

</div>

<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>