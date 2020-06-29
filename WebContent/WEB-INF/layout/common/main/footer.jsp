<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

#info1 {text-align: center;}
#info3 {text-align: left; font-size: small; }
#info4 {text-align: left; font-size: small; }
#info5 {font-size: 35px; color: black; }

#wrap {
	border:  1px solid #ccc;
	

	width: 1200px;
 	
	/* 외부정렬 */
 	margin: 0 auto; 

	/* <table>처럼 레이아웃 설정됨 */
	display: table;
	
	/* 내용물(table-cell)의 크기가 일정하도록 설정 */
	table-layout: fixed;
	
	border-right:none;

	border-left:none;
	
	border-top:none;

	border-bottom:none;
	
}

#wrap > div {
	width: 25%; /* 4개 */
	
	height: 130px;
	
	/* 테이블의 내용물(tabl-cell ,td, th)처럼 레이아웃 설정됨 */
	display: table-cell;
	
	/* table-cell, inline에서 사용 가능  */
	
	/* 수직 정렬 : 중앙 */
	vertical-align: middle;
	
	/* 내부 정렬 : 가운데 */
	text-align: center;  
}

.aTagNone {
	text-decoration: none;
	color: black;
}

.aTagNone:visit{
   text-decoration: none;
   color: black;
}

.aTagNone:hover{
   text-decoration: none;
   color: black;
}

.left{
	text-align: left;
}

#info1 a {
	text-decoration: none;
	color: black;
}

</style>

<script type="text/javascript">
function openService(){
	window.open("/footer/termsofservice","serviceForm","width=400,height=500,screenX=-300")
}
function openPolicy(){
	window.open("/fooer/privacypolicy","serviceForm","width=400,height=500,screenX=-300")
}


</script>
 
<div class="wrappermain">
<br>
<hr>
      


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">서비스 이용약관</h4>
      </div>
      <div class="modal-body">
        <c:import url="/WEB-INF/views/main/footer/termsofservice.jsp"></c:import> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">개인정보 처리방침</h4>
      </div>
      <div class="modal-body">
        <c:import url="/WEB-INF/views/main/footer/privacypolicy.jsp"></c:import> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>



<div id="info1" >	
<a class="btn" data-toggle="modal" data-target="#myModal">서비스 이용약관</a>&nbsp;&nbsp;
<a class="btn" data-toggle="modal" data-target="#myModal2">개인정보 처리방침</a>&nbsp;&nbsp;
<a href="/footer/memberIntroduce" class="aTagNone btn" >제작자 소개</a>&nbsp;&nbsp;
<a href="/footer/siteIntroduce" class="aTagNone btn">사이트 소개</a>&nbsp;&nbsp;
<a href="/footer/askToAdmin" class="aTagNone btn">문의사항</a>&nbsp;&nbsp;


</div>

<br>

<div id="wrap" >

<div id="info2" >
<img src="/resources/img/logo2.png" width="200px;" height="200px;">
</div>

<div id="info3" >
(주) 오디씨<br><br>
전화 010-1234-5789<br><br>
주소 서울 강남 KH빌딩<br><br>
사업자 번호 012 - 3456 - 7890
</div>

<div id="info4" >
고객센터   월-금 ( 9:00- 18:00)<br><br>
카카오톡 플러스 친구  오디씨<br><br>
메일  abc12345@gamil.com
</div>


</div>
</div>
</body>
</html>