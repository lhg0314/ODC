<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<script type="text/javascript">
$(document).ready(function(){
	
	$("#maxPeople").focus(function(){
		if($("#minPeople").val() == "" ){
			alert("최소 인원 수를 먼저 입력해주세요.")
			$("#minPeople").focus();
		}
		
	})
	
	$("#maxPeople").blur(function(){
		
		if($(this).val() < $("#minPeople").val()){
			alert("최대 인원 수는 최소 인원 수보다 많아야 합니다");
			$("#maxPeople").val("");
		}
	})
	
	$("#classFile").change(function(){
		
		var file = this.files[0];
		console.log(file);
		
		/* 파일리더 객체 생성 */
		var reader = new FileReader();
		
		/* 리더 시작 시 함수 구현 */
		reader.onload = function(e){
			
			var url = e.target.result;
			
			$("#fileView").html($("<img src=" + url + ">").css("height","95%"));
		}
		
		reader.readAsDataURL(file);		
	});
	
})
</script>
<style>

#classContentInfo{
	font-size: 12px;
	margin: 3px;
}

#minPeople, #maxPeople{
	display: inline-block;
	width: 100px;
}
#classStartDate, #classEndDate, #recruitStartDate, #recruitEndDate{
	display: inline-block;
	width: 200px;
}

#fileView{
	height: 200px;
	border: 3px solid #ccc;
	border-radius: 10px;
	width: 100%;
}


</style>

<div id="main">
	<span id="boardtitle">클래스 등록</span>
	<hr>
	<br>
	
	<form action="/artist/class/app" method="post" encType="multipart/form-data">
	
	<div class="form-group">
    	<label for="className">클래스 이름</label>
    	<input type="text" class="form-control" id="className" name="className" required="required" />
    </div>

	<div class="form-group">
    	<label for="category">카테고리</label>
		<select class="form-control" id="category" name="category" required="required" >
			<option value="1">플라워</option>
			<option value="2">음악</option>
			<option value="3">수공예</option>
			<option value="4">요리</option>
			<option value="5">뷰티</option>
			<option value="6">미술</option>
			<option value="7">기타</option>
		</select>    	
    </div>
	
	<div class="form-group">
    	<label for="minPeople">인원 수</label><br>
    	<input type="number" min="1" class="form-control" id="minPeople" name="minPeople" required="required" />&nbsp;~&nbsp;
    	<input type="number" min="1" class="form-control" id="maxPeople" name="maxPeople" required="required" />
    </div>
    
	<div class="form-group">
    	<label for="classStartDate">클래스 진행기간</label><br>
    	<input type="date" class="form-control" id="classStartDate" name="classStartDate" required="required" />&nbsp;~&nbsp;
    	<input type="date" class="form-control" id="classEndDate" name="classEndDate" required="required" />
    </div>

	<div class="form-group">
    	<label for="recruitStartDate">클래스 모집기간</label><br>
    	<input type="date" class="form-control" id="recruitStartDate" name="recruitStartDate" disabled="disabled" value="${date }" required="required" />&nbsp;~&nbsp;
    	<input type="date" class="form-control" id="recruitEndDate" name="recruitEndDate" disabled="disabled" required="required" />
    </div>
    
    
	
	<div class="form-group">
	<label for="classContent">클래스 소개</label><br>
	<div id="classContentInfo" >
	- 클래스 소개를 입력해주십시오.<br>
	- <span style="color: red;">클래스를 진행할 시간을 반드시 입력하셔야 합니다.</span>
	</div>
	<textarea class="form-control" rows="10" id="classContent" name="classContent" required="required" ></textarea>
	</div>
	
	
	<div class="form-group">
    	<label for="addr">공방 위치</label><br>
		<input type="text" class="form-control" id="addr" disabled="disabled" value="${artInfo.artAddr }">
    </div>
	
	<div class="form-group">
    	<label for="classFile">사진 첨부</label>
    	<input type="file" accept="image/*" id="classFile" name="classFile" />
    	<br>
	<div id="fileView">
	</div>
    </div>
	
	</form>
	<div id="btn"><a href="#"><button class="class_button">클래스 등록</button></a></div>
	
</div>
	
</div> <!-- 전체를 감싸는 div -->
<div class="clearfix"></div>

</section>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>