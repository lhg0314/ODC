<!-- 20200627 이인주 -->
<!-- 마이페이지 - 클래스 - 수강클래스 - 후기 작성 -->


<!-- 20200627 이인주 -->
<!-- 마이페이지 - 클래스 - 수강 클래스 전체 조회 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 

<style type="text/css">
#fileView{
	height: 200px;
	width: 200px;
	border: 1px solid #ccc;
	margin-top: 5px;
	padding: 10px;
}

#satlevel{
width: 200px;
}

#appContent{
	width: 90%;
	margin: 0 auto;
	font-size: 14px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){

	$("#ReviewFile").change(function(){
		
		$("#fileView").html("");
		var file = this.files[0];
		console.log(file);
		
		/* 파일리더 객체 생성 */
		var reader = new FileReader();
		
		/* 리더 시작 시 함수 구현 */
		reader.onload = function(e){
			
			var url = e.target.result;
			
			$("#fileView").html($("<img src=" + url + ">").css({"height" : "180px", "width" : "180px"}));
		}
		
		reader.readAsDataURL(file);		
	});
	
})
</script>


<div id="main">
	<span id="boardtitle" ><a href="/mypage/class/review/insert" class="anone">후기작성</a></span>
	<hr>


	<div id="appContent">
	<form action="/mypage/class/review/insert" method="post" encType="multipart/form-data" id="appForm">
		
		<div class="form-group">
	    	<label for="reviewtitle">제목</label>
	    	<input type="text" class="form-control" id="reviewtitle" name="reviewtitle" required="required" />
	    </div>
		
		<br>
		<div class="form-group line">
	    	<label for="satlevel">만족도</label>
			<select class="form-control" id="satlevel" name="satlevel" required="required" >
				<option value="오디씨 마음을 알 수 없습니다" selected="selected">--선택--</option>
				<option value="매우불만족">매우불만족</option>
				<option value="불만족">불만족</option>
				<option value="보통">보통</option>
				<option value="만족">만족</option>
				<option value="매우만족">매우만족</option>
			</select>    	
	    </div>
	    
	    <br>
	    
	    <div class="form-group">
		<label for="reviewcontent">후기내용 작성</label><br>
		<div id="classContentInfo" >
		- <span style="color: red;">2000자를 넘길 수 없습니다.</span>
		</div>
		<textarea class="form-control" rows="10" id="reviewcontent" name="reviewcontent" required="required" ></textarea>
		</div>
		
	    <br>
	    
	    <div class="form-group" >
	    	<label for="ReviewFile">사진 첨부</label>
	    	<input type="file" accept="image/*" id="ReviewFile" name="ReviewFile"/>
			<div id="fileView">
			</div>
	    </div>
	    
	     <br>
	     
		<div class="text-center"><button class="class_button">후기 등록</button></div>
	</form>
	 </div>

	

</div> <!-- 전체를 감싸는 div -->

<!-- float 막는 clear -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>