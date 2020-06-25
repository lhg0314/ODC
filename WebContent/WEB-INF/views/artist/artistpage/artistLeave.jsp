<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 


<script type="text/javascript" 
  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>



<style type="text/css">

#pwdiv {
	
	margin: 50px auto;
	text-align: center;
	width: 500px;	
	border: 1px solid #aaa;
	border-radius: 12px;
	padding: 50px;
}
	
#pw { font-weight: bold; }

span { margin: 0 12px; }

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




<!-- 회원탈퇴 submit -->
<script type="text/javascript">
$(document).ready(function() {
	
	//탈퇴버튼 동작
	$("#btnLeave").click(function() {
		
		//form submit 수행
		$("form").submit();
		
	})
})
</script>





<div id="main">

<span id="boardtitle">회원 탈퇴</span>
<hr>

	<div id="pwdiv">
	
		<h4 id="pw">정말로 탈퇴 하시겠습니까?</h4><br>
		<h5 id="pw">탈퇴 이후에는 계정 복구가 불가능합니다</h5>
		<h5 id="pw">회원 탈퇴를 위하여 비밀번호를 입력해주세요 </h5><br>
		
		<form action="/artist/leave" method="post">
			<span>비밀번호</span><input type="password" name="pwcheck"/>	
		</form>
		
	</div>
	
	
	<div id="btn"><button class="btn" id="btnLeave">회원 탈퇴</button></div>
	<br><br>	
	
	
</div>


<div class="clearfix"></div>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>	