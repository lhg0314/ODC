<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- main header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 


<script type="text/javascript" 
  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>




<style type="text/css">

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
	width: 250px;
}

#btn { text-align: center; }

.btn {
  
  display: inline-block;
  padding: 13px 30px;
  text-align: center;
  
  background-color: #8c7599;
  color: white;
  font-size: 17px;
  font-weight: bolder;
  text-decoration: none;
  
  cursor: pointer;
}

</style>




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

		
	
        if( $("#userpw").val() != "" && !upwReg.test( $("#userpw").val() ) ) {//비밀번호 체크
        	alert($pw)
        	$("#userpw").focus()
            return false;
        }
        
        if($("#userpw").val() != $("#userpwchk").val()){//비밀번호 확인 체크
        	alert($checkpw)
        	$("#userpwchk").focus()
        	return false;
        }
	
        if(!uphoneReg.test( $("#userphone").val() )){//전화번호 체크
        	alert("전화번호는 10-11자리 숫자여야 합니다")
        	$("#userphone").focus()
        	return false;
        }
		
		//form submit 수행
		$("form").submit();
		
	})
	
})

</script>



<div id="main">

<span id="boardtitle">회원 정보 수정</span>
<hr>

	
	<form action="/user/info" method="post">
	
	
		<table class="infotable">
			
			<tr>
				<th>이름</th>
				<td><input type="text" id="username" name="username" value="${uinfo.username }"/></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${userid }</td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" id="userpw" name="userpw"/></td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td><input type="password" id="userpwchk" name="userpwchk"/></td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td><input type="tel" id="userphone" name="userphone" value="${uinfo.userphone }"/></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" id="userbirth" name="userbirth" value="${uinfo.userbirth }"/></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" id="usernick" name="usernick" value="${uinfo.usernick }"/></td>
			</tr>
			
		</table>
		
	
	</form>
		
	<br><br>
	<div id="btn"><button class="btn" id="btnUpdate">회원정보 수정</button></div>
	<br><br>	
	
	
	
</div>


<div class="clearfix"></div>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>
