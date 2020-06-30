<!-- 관리자 후기리스트 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	//검색 버튼 클릭
	$("#btnSearch").click(function() {
		location.href="/admin/reviewlist?search="+$("#search").val();
	});
	
	$("#search").keydown(function(e) {
		if( e.keyCode == 13 ) {
			$("#btnSearch").click();
		}
	});
});
</script>

<script type="text/javascript">
$(document).ready(function() {
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");

		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/admin/rlistdelete")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
});

//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}
</script>

<style type="text/css">
#reviewTable th {
	text-align: center;
	background: thistle;
}
</style>
<div>
<h4>게시판 관리</h4>
<hr>
<h5>후기게시판 관리</h5><br>

<div>
<input type="text" id="search" placeholder="클래스명" value="${paging.search }"/>
<button type="button" id="btnSearch">검색</button><br><br>
</div>

<table id="reviewTable" class="table table-condensed text-center table-hover">
	<tr>
		<th><input type="checkbox" id="checkAll" onclick="checkAll();" /></th>
		<th>번호</th>
		<th>작성자 아이디</th>
		<th style="width: 20%;">클래스명</th>
		<th style="width: 40%;">제목</th>
		<th>게시 날짜</th>
	</tr>

	<c:if test="${empty list }">
	<tr>
		<td colspan="6" style="color: thistle; font-weight: bold;">후기게시판 리스트가 없습니다</td>
	</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover">
		<td><input type="checkbox" name="checkRow" value="${info.reviewNo }" /></td>
		<td>${info.reviewNo }</td>
		<td>${info.userId }</td>
		<td style="text-align: left;">${info.className}</td>
		<td style="text-align: left;"><a href="/admin/reviewdetail?reviewno=${info.reviewNo }">${info.reviewTitle }</a></td>
		<td>${info.reviewDate }</td>
	</tr>	
	
	</c:forEach>
</table>
<div id="btnBox" style="text-align: right;">
<button id="btnDelete" class="btn btn-warning">삭제</button>
</div>
<c:import url="/WEB-INF/paging/adminreviewpaging.jsp" />
</div>
<c:import url="/WEB-INF/layout/admin/footer.jsp" />