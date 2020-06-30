<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 


<script type="text/javascript" 
  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>




<style type="text/css">
#SvnArtInfo{
	color: #e7717d;
}


.infotable {
	
	width: 837.5px;
 	margin: 40px 0 0; 
}

.infotable tr {

	border-top: 1px solid #eee; 
	border-bottom: 1px solid #eee; 
}

.infotable th {

	width: 25%;
	background: #eee;
	padding: 15px;
	font-size: 14px;
	border: 1px solid white;
}

.infotable td {

	padding: 15px 10px;
}

input { 

	border: 1px solid #aaa; 
	width: 150px;
}

textarea { 
	border: 1px solid #aaa;
	width: 100%;
	height: 100px;
}

#btn { text-align: center; }

#btnUpdate {
  background-color: #b798b7; 
  color: white;
  border: none;
  
  text-align: center;
  text-decoration: none;
  font-size: 17px;
  font-weight: bold;
  
  display: inline-block;
  margin: 4px 2px;
  padding: 16px 32px;
  cursor: pointer;
  
}

#btnUpdate:hover {
  background-color: #8c7599;
  color: white;
}

#prev { width: 150px; }

#preview { 

	width: 150px;
	height: 150px;
	border: 1px solid #aaa;
}

#fimg {

	width: 150px;
	height: 150px;
}

#upfile { width: 250px; }

#f { vertical-align: bottom; }

</style>



<!-- 다음 우편번호 api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
    
</script>



<!-- 이미지 미리보기 -->
<script type="text/javascript">

$(document).ready(function(){
	
	
	$("#upfile").change(function( e ){
		
		
		var files = e.target.files[0] //FileList 객체
		
		
		//FileReader 객체 생성
		var reader = new FileReader()
				 
		
		
		//File 객체의 정보(내용물)를 모두 읽어서 메모리에
		//적재(load)한 이후 동작되도록 이벤트 리스너 작성
		reader.onload = function( ev ){
			
			
			//이미지가 한장만 유지됨
				$("#preview").html(
						$("<img>").attr({
							"src": ev.target.result,
							"width": 150,
							"height": 150
						})
				)
		}
		
		
		//FileReader 객체를 이용한 File 객체 정보 읽기
		reader.readAsDataURL(files) //Blob 또는 File 형식으로 읽기
			
	})
	
})

</script>



<!-- 회원정보수정 submit -->
<script type="text/javascript">
$(document).ready(function() {
	
	//경고문구 태그
	var $pw="영어, 숫자만 가능합니다";
	var $checkpw="비밀번호가 다릅니다";
	
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		
		var upwReg = /^[A-Za-z0-9]{3,19}$/;//비밀번호는 대소문자 숫자만 가능
		var uphoneReg= /^[0-9]{10,11}$/;//전화번호는 숫자만 가능

		
        if( $("#artpw").val() != "" && !uidReg.test( $("#artpw").val() ) ) {//비밀번호 체크
        	alert($pw)
        	$("#artpw").focus()
            return false
        }
        
        if($("#artpw").val() != $("#artpwchk").val()){//비밀번호 확인 체크
        	alert($checkpw)
        	$("#artpwchk").focus()
        	return false
        }
        
        if(!uphoneReg.test( $("#artphone").val() )){//전화번호 체크
        	alert("전화번호는 10-11자리 숫자여야 합니다")
        	$("#artphone").focus()
        	return false;
        }
        
        alert("회원정보가 수정되었습니다")
        
		//form submit 수행
		$("form").submit();
		
	})
		
	
})

</script>





<div id="main">

<span id="boardtitle">작가 정보 수정</span>
<hr>

	
	<form action="/artist/info" method="post" >
	
	
		<table class="infotable">
			
			<tr>
				<th>이름</th>
				<td><input type="text" id="artname" name="artname" value="${ainfo.artName }" required="required"/></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${artid }</td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" id="artpw" name="artpw"/></td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td><input type="password" id="artpwchk" name="artpwchk" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${ainfo.artEmail }</td>
			</tr>
			<tr>
				<th>사업자등록번호</th>
				<td>${ainfo.artCode }</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td><input type="tel" id="artphone" name="artphone" value="${ainfo.artPhone }" required="required"/></td>
			</tr>
			<tr>
				<th>공방전화번호</th>
				<td><input type="tel" id="arttelephone" name="arttelephone" value="${ainfo.artTel }" required="required"/></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" id="artbirth" name="artbirth" value="${ainfo.artBirth }" required="required"/></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" id="artnick" name="artnick" value="${ainfo.artNick }" required="required"/></td>
			</tr>
			<tr>
				<th>공방주소</th>
				<td>
					<input type="text" name="addr1" id="sample6_postcode" placeholder="우편번호" readonly="readonly" style="width: 250px;" value="${addr1 }" required="required"/>
					<input type="button" id="addrbtn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" style="width: 110px;"><br><br>
					<input type="text" name="addr2" id="sample6_address" placeholder="주소" style="width: 500px;"  value="${addr2 }" required="required"><br><br>
					<input type="text" name="addr3" id="sample6_detailAddress" placeholder="상세주소" style="width: 500px;"  value="${addr3 }">
					<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
				</td>
			</tr>
			
		</table>
	
	
		<table class="infotable">
		
			<tr>
				<th>작가소개글</th>
				<td><textarea id="artdetail" name="artdetail">${ainfo.artContent }</textarea></td>
			</tr>
			
		</table>
	
	</form>
	
	<br><br><br>
	<div id="btn"><button id="btnUpdate">회원정보 수정</button></div>
	<br><br><br><br>	
	
</div>


<div class="clearfix"></div>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>