<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/admin/header.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/notice/write";
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
			.attr("action", "/admin/nlistdelete")
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
#SnvNotice{
	background: #ecdfec;
}


#noticeTable th {
	text-align: center;
	background: thistle;
}
</style>
<div>
<h4>게시판 관리</h4>
<hr>
<h5>공지사항 관리</h5><br>

<table id="noticeTable" class="table table-condensed text-center table-hover">
	<tr>
		<th><input type="checkbox" id="checkAll" onclick="checkAll();" /></th>
		<th style="width: 15%;">글번호</th>
		<th style="width: 55%;">제목</th>
		<th style="width: 30%;">작성일</th>
	</tr>

	<c:if test="${empty list }">
		<tr>
		<td colspan="4" style="color: thistle; font-weight: bold;">공지사항 리스트가 없습니다</td>
		</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	
	<tr class="table-hover">
		<td><input type="checkbox" name="checkRow" value="${info.noticeNo }" /></td>
		<td>${info.noticeNo }</td>
		<td style="text-align: left;"><a href="/admin/notice/view?noticeno=${info.noticeNo }">${info.noticeTitle }</a></td>
		<td>${info.noticeDate}</td>
	</tr>	
	
	</c:forEach>
</table>
<div id="btnBox" style="text-align: right;">
<button id="btnDelete" class="btn btn-warning">삭제</button>
<button id="btnWrite" class="btn btn-primary" onclick="location.href='/notice/write'">글쓰기</button>
</div>
<c:import url="/WEB-INF/paging/adminnoticepaging.jsp" />
</div>
<c:import url="/WEB-INF/layout/admin/footer.jsp" />