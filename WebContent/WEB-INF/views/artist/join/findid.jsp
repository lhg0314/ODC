<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- w3schools css 라이브러리 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


	<style type="text/css">
	
		#title{
			text-align :center;
		}
	
		#wrap {
			width: 400px;
			/* text-align :center;  */
			margin: 0 auto 0 auto;
		}
		
		#chk{
			/* //text-align :center; */
		}
		
		#cancelBtn{
			visibility:visible;
		}
		
		#useBtn{
			 visibility:hidden;
		}
		
		.emailWrapper{
			position:relative;
		}
		.emailBtn1{
		
			margin-right: 50px;
		}
		
		.emailBtn2{
		
			position:absolute;
			top: 32px;
			right: -118px;
		}
		#btnposition{
			width:500px;
			position: absolute;
			left: 20%;
			
		}
		
		

	</style>
	<script type="text/javascript" src="/resources/js/httpRequest.js" ></script>
		<script type="text/javascript">
	



		function emailSend(){
			
			
			var userEmail = document.getElementById("email").value;//작가 아이디 가져옴
			var userName=document.getElementById("name").value;//작가 이름 가져옴
			
			var param="email="+userEmail+"&name="+userName;
			
			console.log("param: "+param)
			sendRequest("POST","/find/artid",param,ajaxFromServer);
			
			
		}
		
		function ajaxFromServer(){
			if(httpRequest.readyState==4){//DONE,응답완료
				if(httpRequest.status==200){//OK
					var resultText = httpRequest.responseText;
					if(resultText == 0){//입력한 회원정보가 없을때
						alert("입력한 회원정보가 없습니다");

					} 
					else if(resultText != 0){ //입력한 회원정보가 있을때
						location.href="/show/artistid?id="+resultText;
					}
					
				}
			}
		}
		

		
		// 사용하기 클릭 시 부모창으로 값 전달 
		function sendCheckValue(){
			location.href="/member/login";
		}	
	</script>
</head>
<body>
<div id="wrap">
	<br>
	<b id="title"><font size="4" color="gray" >작가 아이디 찾기</font></b>
	<hr size="1" width="460">
	<br>
	<div id="chk">
		<form id="checkForm">
		<div class="form-group">		
		<label for="name" >이름</label>
		<input type="text" id="name" name="name" class="form-control" required="required"/>
		</div>
		
		<div class="form-group emailWrapper"  >
		<label for="email" class="control-label">이메일</label>
		<input type="text" name="email" id="email" class="form-control">
		<br><br>
		
		<div id="btnposition">
		<input type="button" value="아이디 찾기" onclick="emailSend()" class="emailBtn1">
		<input id="cancelBtn" type="button" value="로그인" onclick="sendCheckValue()"><br>
		</div>
		</div>
		
		
		</form>

	</div>
</div>
</body>
</html>