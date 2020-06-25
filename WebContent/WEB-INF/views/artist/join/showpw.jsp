<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


	<script type="text/javascript" src="/resources/js/httpRequest.js" ></script>
		<script type="text/javascript">
	


		
		// 사용하기 클릭 시 부모창으로 값 전달 
		function sendCheckValue(){
			location.href="/member/login";
		}	
	</script>

	<style type="text/css">
		#wrap {
			width: 490px;
			text-align :center;
			margin: 100px auto 0 auto;
			border: 2px solid gray;
		}
		
		#chk{
			text-align :center;
		}
		
		#cancelBtn{
			visibility:visible;
		}
		
		#useBtn{
			 visibility:hidden;
		}

	</style>
</head>
<body>

<div id="wrap">
	<br>
	<b id="title"><font size="4" color="gray" >비밀번호 찾기 결과</font></b>
	<hr size="1" width="460">
	<br>
	<div id="chk">


		
		<h3>비밀번호: ${pw }</h3>
		<br><br>
		
		<div id="btnposition">
		<input id="cancelBtn" type="button" value="로그인" onclick="sendCheckValue()"><br><br><br>
		</div>
		
		

	</div>
</div>

</body>
</html>