<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<script type="text/javascript"
 src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
 
<script type="text/javascript">
$(document).ready(function() {
	//페이지 첫 접속 시 입력창으로 포커스 이동
	$("input").eq(0).focus();
	
	//경고문구 태그
	var $id="영어, 숫자만 가능합니다";
	var $pw="영어, 숫자만 가능합니다";
	var $checkpw="비밀번호가 다릅니다";
	
	
	$("#myform").submit(function(){
		
		console.log(document.getElementById("emailAuth").value)
		
		var uidReg = /^[A-Za-z0-9]{3,19}$/;//아이디는 대소문자 숫자만 가능
		var upwReg = /^[A-Za-z0-9]{3,19}$/;//비밀번호는 대소문자 숫자만 가능
		var uphoneReg= /^[0-9]{10,11}$/;//전화번호는 숫자만 가능
		 
        if( !uidReg.test( $("#userid").val() ) ) {//아이디 체크
        	alert($id)
        	$("#userid").focus()
            return false
        }
		
        if( !uidReg.test( $("#userpw").val() ) ) {//비밀번호 체크
        	alert($id)
        	$("#userpw").focus()
            return false
        }
        
        if($("#userpw").val() != $("#userpwchk").val()){//비밀번호 확인 체크
        	alert($checkpw)
        	$("#userpwchk").focus()
        	return false
        }
        
        if(!uphoneReg.test( $("#userphone").val() )){//전화번호 체크
        	alert("전화번호는 10-11자리 숫자여야 합니다")
        	$("#userphone").focus()
        	return false;
        }
        
        if($("#idDuplication").val() != "idCheck"){ //아이디 중복체크 확인
        	alert("아이디 중복체크를 해주세요")
        	return false;
        }
        if($("#emailAuth").val() != "emailCheck"){
        	alert("이메일을 인증해 주세요")
        	return false;
        }
			
		
	})
	
	
	//닉네임 입력 창에서 엔터 입력 시 form submit
	$("input").eq(2).keydown(function(key) {
		if(key.keyCode == 13) {
			$(this).parents("form").submit();
		}
	})


	
	//취소 버튼 누르면 뒤로가기
	$("#btnCancel").click(function() {
		history.go(-1);
	})
});
</script>

<script type="text/javascript">

function IdChk(){
	window.open("/resources/form/IdCheckForm.jsp","ichkForm","width=500,height=300,resizable=no,scrollbars=no")
}

function emailChk(){
	
	window.open("/resources/form/emailCheckForm.jsp","echkForm","width=500,height=300,resizable=no,scrollbars=no")
}

//아이디 입력창에 값입력시 idUncheck세팅
//아이디를 새로입력하면 다시 중복체크를 한다


function inputIdChk(){
	document.getElementById("idDuplication").value="idUncheck";
}
function inputEmailChk(){
	document.getElementById("emailAuth").value="EmailUncheck";
}

</script>

<style type="text/css">
form {
	width: 400px;
	margin: 0 auto;
	

}

#idDupl{
	position:absolute;
	top: 32px;
	right: -83px;
}
#idDiv{
position:relative;
}
#emailDiv{
position:relative;
}
#emailCheck{
position:absolute;
	top: 32px;
	right: -105px;
}
</style>


<br>
	
   <h3 align="center">회원가입</h3>
<hr>
<form action="/user/join" method="post" class="form-horizontal" id="myform">
	<div class="form-group" id="idDiv">
		<label for="userid" class="control-label">아이디</label>
		<input type="text" id="userid" name="userid" class="form-control" required="required" onkeydown="inputIdChk()"/> 
		<input type="button" value="중복확인" onclick="IdChk()" id="idDupl">
		<input type="hidden" id="idDuplication" name="idDuplication" value="idUncheck">
	</div>
	<div class="form-group">
		<label for="userpw" class="control-label">비밀번호</label>
		<input type="password" id="userpw" name="userpw" class="form-control" required="required"/>
	</div>
	<div class="form-group">
		<label for="userpwchk" class="control-label">비밀번호 확인</label>
		<input type="password" id="userpwchk" name="userpwchk" class="form-control" required="required"/>
	</div>
	
	<div class="form-group">
		<label for="username" class="control-label">이름</label>
		<input type="text" id="username" name="username" class="form-control" required="required"/>
	</div>
	
	<div class="form-group">
		<label for="userphone" class="control-label">휴대전화</label>
		<input type="tel" id="userphone" name="userphone" class="form-control" required="required"/>
	</div>	
	
	<div class="form-group" id="emailDiv">
		<label for="useremail" class="control-label">이메일</label>
		<input type="email" id="useremail" name="useremail" class="form-control" required="required" onkeydown="inputEmailChk()"/>
		<input type="button" value="이메일 인증" onclick="emailChk()" id="emailCheck">
		<input type="hidden" id="emailAuth" name="emailAuth" value="emailUncheck">
	</div>	
	
	<div class="form-group">
		<label for="userbirth" class="control-label">생년월일</label>
		<input type="Date" id="userbirth" name="userbirth" class="form-control" required="required"/>
	</div>	
	
	<div class="form-group">
		<label for="usernick" class="control-label">닉네임</label>
		<input type="text" id="usernick" name="usernick" class="form-control"/>
	</div>
	
	<div class="form-group">
		<p>[필수] 이용약관 동의</p>
		<div style="border: 1px solid #ccc;">아니한 목숨을 사는가 싶이 살았으며 그들의 그림자는 천고에 사라지지 않는 것이다 이것은 현저하게 일월과 같은 예가
			만천하의 대중을 품에 안고 그들에게 밝은 길을 찾아 주며 그들을 행복스럽고 평화스러운 곳으로 인도하겠다는 커다란 이상을 품었기 때문이다 그러므로 그들은 길지 아니한 목숨을 사는가 싶이 살았으며 그들의 그림자는 천고에 사라지지 않는 것이다 이것은 현저하게 일월과 같은 예가 되려니와 그와 같지 못하다 할지라도
			든 칼이다 청춘의 끓는 피가 아니더면 인간이 얼마나 쓸쓸하랴? 얼음에 싸인 만물은 얼음이 있을 뿐이다 그들에게 생명을 불어 넣는 것은 따뜻한 봄바람이다 풀밭에 속잎나고 가지에 싹이 트고 꽃</p>
		</div>
		<label for="useragreechk1" class="control-label">이용약관에 동의하십니까?</label>
		<input type="checkbox" id="useragreechk1" name="useragreechk1"  required="required"/>
	</div>
	<br>
	<div class="form-group">
		<p>[필수]개인정보 수집 및 이용 동의</p>
		<div>
		<div style="border: 1px solid #ccc;">아니한 목숨을 사는가 싶이 살았으며 그들의 그림자는 천고에 사라지지 않는 것이다 이것은 현저하게 일월과 같은 예가
			만천하의 대중을 품에 안고 그들에게 밝은 길을 찾아 주며 그들을 행복스럽고 평화스러운 곳으로 인도하겠다는 커다란 이상을 품었기 때문이다 그러므로 그들은 길지 아니한 목숨을 사는가 싶이 살았으며 그들의 그림자는 천고에 사라지지 않는 것이다 이것은 현저하게 일월과 같은 예가 되려니와 그와 같지 못하다 할지라도
			든 칼이다 청춘의 끓는 피가 아니더면 인간이 얼마나 쓸쓸하랴? 얼음에 싸인 만물은 얼음이 있을 뿐이다 그들에게 생명을 불어 넣는 것은 따뜻한 봄바람이다 풀밭에 속잎나고 가지에 싹이 트고 꽃
		</div>
		</div>
		<label for="useragreechk2" class="control-label">개인정보 수집 및 이용에 동의하십니까?</label>
		<input type="checkbox" id="useragreechk2" name="useragreechk2" required="required"/>
	</div>
	<br>
	<div class="text-center">
		<input type="submit" class="btn btn-primary" value="회원가입">
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
	</div>
</form>



<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>
