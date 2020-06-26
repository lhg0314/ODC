<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<script type="text/javascript">
$(document).ready(function(){
	
	/* 재능기부 클래스여부는 변경할 수 없도록 처리 */
	var talentDona = "<c:out value='${info.talentDonation }'/>" * 1;
	
	if( talentDona == 0){
		$("#talentDonation").attr("disabled", "disabled");
	}else{
		$("#talentDonation").attr("checked", "checked");
		$("#talentDonation").attr("disabled", "disabled");
		$("#classPrice").attr("readOnly", "readOnly");
	}
	
	$("#btnX").click(function(){
		$("#fileView").html("");
		$("#originFile").css("display", "none");
		$("#classFile").attr("type", "file");		
	})
	
	
	/* 첨부파일 이미지 미리보기 */
	$("#classFile").change(function(){
		
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
	
	/* 클래스 모집기간 자동 처리 */
	$("#classEndDate").blur(function(){
		$("#recruitEndDate").val($(this).val());
	});
	
	/* 재능기부클래스 체크하면 금액 비활성화 */
	$("#talentDonation").change(function(){
		if( $(this).is(":checked")){
			$("#classPrice").val("");
			$("#classPrice").attr("readOnly", "readOnly");
		}else{
			$("#classPrice").removeAttr("readOnly");			
		}
	})
	

	/* submit 되기 전 유효성 검사 */
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
		
		$("#talentDonation").removeAttr("disabled");
		$("#category").removeAttr("disabled");
		
	});
	
})
</script>
<style>
#appContent{
	width: 90%;
	margin: 0 auto;
	font-size: 14px;
}


#SvnclassManage{
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

#fileView{
	height: 200px;
	width: 200px;
	border: 1px solid #ccc;
	margin-top: 5px;
	padding: 10px;
}

#imgFile{
	width: 180px;
	height: 180px;
}

.line{
	display: inline-block;
}

</style>

<div id="main">
	<span id="boardtitle">클래스 관리</span>
	<hr>
	<br>
	
	<div id="appContent">
		<form action="/artist/class/update" method="post" encType="multipart/form-data" id="appForm">
		
		<input type="hidden" name="classNo" value="${info.classNo }" />
		
		<div class="form-group">
	    	<label for="className">클래스 이름</label>
	    	<input type="text" class="form-control" id="className" name="className" required="required" value="${info.className }" readonly="readonly"/>
	    </div>

		<div class="form-group line">
	    	<label for="classPrice" style="display: block;">금액</label>
	    	<input type="number" min="0" step ="1000" class="form-control" id="classPrice" name="classPrice" value="${info.classPrice }" required="required"/><span>원</span>
	    </div>

	    <div class="form-group line" id="chkbox">
		<label class="checkbox-inline">
  			<input type="checkbox" id="talentDonation" name="talentDonation" value="1"> 재능 기부
		</label>
	    </div>
		
		<br>
		 
		<div class="form-group">
	    	<label for="category">카테고리</label>
			<select class="form-control" id="category" name="category" required="required" disabled="disabled">
				<c:if test="${info.category eq 1 }"><option value="1" selected="selected">플라워</option></c:if>
				<c:if test="${info.category eq 2 }"><option value="1" selected="selected">음악</option></c:if>
				<c:if test="${info.category eq 3 }"><option value="1" selected="selected">수공예</option></c:if>
				<c:if test="${info.category eq 4 }"><option value="1" selected="selected">요리</option></c:if>
				<c:if test="${info.category eq 5 }"><option value="1" selected="selected">뷰티</option></c:if>
				<c:if test="${info.category eq 6 }"><option value="1" selected="selected">미술</option></c:if>
				<c:if test="${info.category eq 7 }"><option value="1" selected="selected">기타</option></c:if>
			</select>    	
	    </div>
	   
	    
		<div class="form-group" id="people">
	    	<label for="minPeople">인원 수</label><br>
	    	<input type="number" min="1" class="form-control" id="minPeople" name="minPeople" required="required" value="${info.minPeople }" />&nbsp;&nbsp;~&nbsp;
	    	<input type="number" min="1" class="form-control" id="maxPeople" name="maxPeople" required="required" value="${info.maxPeople }"/>
	    </div>
	    
		<div class="form-group">
	    	<label for="classStartDate">클래스 진행기간</label><br>
	    	<input type="date" class="form-control" id="classStartDate" value="${info.classStartdate }" name="classStartDate" required="required" />&nbsp;&nbsp;~&nbsp;
	    	<input type="date" class="form-control" id="classEndDate" value="${info.classEnddate }" name="classEndDate" required="required"/>
	    </div>
	    
		<div class="form-group">
	    	<label for="recruitStartDate">클래스 모집기간</label><br>
	    	<input type="date" class="form-control" id="recruitStartDate" name="recruitStartDate" readonly="readonly" value="${info.recruitStartdate }" required="required" />&nbsp;&nbsp;~&nbsp;
	    	<input type="date" class="form-control" id="recruitEndDate" name="recruitEndDate" readonly="readonly" value="${info.recruitEnddate }" required="required" />
	    </div>
	    
	    <div class="form-group">
		<label for="classContent">클래스 소개</label><br>
		<div id="classContentInfo" >
		- 클래스 소개를 입력해주십시오.<br>
		- <span style="color: red;">클래스를 진행할 시간을 반드시 입력하셔야 합니다.</span>
		</div>
		<textarea class="form-control" rows="10" id="classContent" name="classContent" required="required" >${info.classContent }</textarea>
		</div>
		
		<div class="form-group">
	    	<label for="classFile">사진 첨부</label><br>
	    	<input type="hidden" accept="image/*" id="classFile" name="classFile" required="required"/>
	    	<div id="originFile">
	    	<span >${info.classOriginFilename } </span><button type="button" id="btnX" class="btn btn-default btn-xs">X</button>
			</div>
			<div id="fileView">
			<img id="imgFile" src="/upload/${info.classRenameFilename }" />
			</div>
	    </div>
		
		<div class="text-center"><button class="class_button">클래스 수정</button></div>
		</form>
	
	
	</div>
	
</div>
	
</div> <!-- 전체를 감싸는 div -->
<div class="clearfix"></div>

</section>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>