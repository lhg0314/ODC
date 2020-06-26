<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<script type="text/javascript">
$(document).ready(function(){

	$("#classFile1").change(function(){
	
		$("#fileView1").html("");
		var file = this.files[0];
		console.log(file);
	
		/* 파일리더 객체 생성 */
		var reader = new FileReader();
	
		/* 리더 시작 시 함수 구현 */
		reader.onload = function(e){
		
			var url = e.target.result;
		
			$("#fileView1").html($("<img src=" + url + ">").css({"height" : "180px", "width" : "180px"}));
		}

		reader.readAsDataURL(file);		
	});
		
	$("#classFile2").change(function(){
	
		$("#fileView2").html("");
		var file = this.files[0];
		console.log(file);
		
		/* 파일리더 객체 생성 */
		var reader = new FileReader();
		
		/* 리더 시작 시 함수 구현 */
		reader.onload = function(e){
		
			var url = e.target.result;
			
			$("#fileView2").html($("<img src=" + url + ">").css({"height" : "180px", "width" : "180px"}));
		}
	
		reader.readAsDataURL(file);		
	});
	
		
	$("#classEndDate").blur(function(){
		$("#recruitEndDate").val($(this).val());
	});
	
	$("#talentDonation").change(function(){
		if( $(this).is(":checked")){
			$("#classPrice").val("100");
			$("#classPrice").attr("readOnly", "readOnly");
		}else{
			$("#classPrice").val("");
			$("#classPrice").removeAttr("readOnly");			
		}
	})
	
	
	$("#appForm").submit(function(){
		if($("#category").val() == 0 ){
			alert("카테고리를 선택하세요");
			$("#category").focus();
			return false;
		}else if($("#maxPeople").val() < $("#minPeople").val()){
			alert("최대 인원 수는 최소 인원 수보다 많아야 합니다");
			$("#minPeople").val("");
			$("#maxPeople").val("");
			$("#minPeople").focus();
			return false;
		}else if($("#classStartDate").val() > $("#classEndDate").val()){
			alert("클래스 종료 날짜는 시작 날짜 이후여야 합니다.");
			$("#classStartDate").val("");
			$("#classEndDate").val("");
			$("#classStartDate").focus();
			return false;
		}
		
	});
	
})
</script>
<style>
#appContent{
	width: 90%;
	margin: 0 auto;
	font-size: 14px;
}


#SvnclassApp{
	color: #e7717d;
}

#category, #location{
	width: 150px;
}

#classContentInfo{
	font-size: 12px;
	margin: 3px;
}

#classPrice{
	width: 250px;
	text-align: right;
	display: inline-block;
}

#chkbox{
	margin-left: 10px;
}

#minPeople, #maxPeople{
	display: inline-block;
	width: 100px;
	text-align: right;
}

#classStartDate, #classEndDate, #recruitStartDate, #recruitEndDate{
	display: inline-block;
	width: 180px;
}

#fileView1, #fileView2{
	height: 200px;
	width: 200px;
	border: 1px solid #ccc;
	margin-top: 5px;
	padding: 10px;
}

.line{
	display: inline-block;
}

</style>

<div id="main">
	<span id="boardtitle">클래스 등록</span>
	<hr>
	<br>
	
	<div id="appContent">
		<form action="/artist/class/app" method="post" encType="multipart/form-data" id="appForm">
		
		<div class="form-group">
	    	<label for="className">클래스 이름</label>
	    	<input type="text" class="form-control" id="className" name="className" required="required" />
	    </div>

		<div class="form-group line">
	    	<label for="classPrice" style="display: block;">금액</label>
	    	<input type="number" min="0" step ="1000" class="form-control" id="classPrice" name="classPrice" required="required"/><span>원</span>
	    </div>

	    <div class="form-group line" id="chkbox">
		<label class="checkbox-inline">
  			<input type="checkbox" id="talentDonation" name="talentDonation" value="1"> 재능 기부
		</label>
	    </div>
		
		<br>
		 
		<div class="form-group">
	    	<label for="category">카테고리</label>
			<select class="form-control" id="category" name="category" required="required" >
				<option value="0" selected="selected">--선택--</option>
				<option value="1">플라워</option>
				<option value="2">음악</option>
				<option value="3">수공예</option>
				<option value="4">요리</option>
				<option value="5">뷰티</option>
				<option value="6">미술</option>
				<option value="7">기타</option>
			</select>    	
	    </div>
	    
		<div class="form-group" id="people">
	    	<label for="minPeople">인원 수</label><br>
	    	<input type="number" min="1" class="form-control" id="minPeople" name="minPeople" required="required" />&nbsp;&nbsp;~&nbsp;
	    	<input type="number" min="1" class="form-control" id="maxPeople" name="maxPeople" required="required" />
	    </div>
	    
		<div class="form-group">
	    	<label for="classStartDate">클래스 진행기간</label><br>
	    	<input type="date" min="${today }" class="form-control" id="classStartDate" name="classStartDate" required="required" />&nbsp;&nbsp;~&nbsp;
	    	<input type="date" min="${today }" class="form-control" id="classEndDate" name="classEndDate" required="required" />
	    </div>
	    
		<div class="form-group">
	    	<label for="recruitStartDate">클래스 모집기간</label><br>
	    	<input type="date" class="form-control" id="recruitStartDate" name="recruitStartDate" readonly="readonly" value="${today }" required="required" />&nbsp;&nbsp;~&nbsp;
	    	<input type="date" class="form-control" id="recruitEndDate" name="recruitEndDate" readonly="readonly" required="required" />
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
	    	<label for="classFile1">사진 첨부 - 메인 소개 사진</label>
	    	<input type="file" accept="image/*" id="classFile1" name="mainFile" required="required"/>
			<div id="fileView1">
			</div>
	    </div>
		
		<div class="form-group">
	    	<label for="classFile2">사진 첨부 - 상세 사진</label>
	    	<input type="file" accept="image/*" id="classFile2" name="detailFile" required="required"/>
			<div id="fileView2">
			</div>
	    </div>
	    
		<div class="text-center"><button class="class_button">클래스 등록</button></div>
		</form>
	
	
	</div>
	
</div>
	
</div> <!-- 전체를 감싸는 div -->
<div class="clearfix"></div>

</section>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>