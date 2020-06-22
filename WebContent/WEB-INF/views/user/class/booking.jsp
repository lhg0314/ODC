<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<style type="text/css">
.booking_left {
   margin: 0 auto;
   float: left;
   width: 65%;   
}

.booking_right {
   margin: 0 auto;
   float: right;
   width: 30%;
   background: thistle;
   padding: 10px;
}

.bookingtable {
   width: 95%;
   margin: 0 auto;
}

#btnDiv {
   margin: 15px 0;
   padding: 0;
}

.classinfo {
   margin: 15px 20px;
}

</style>

</head>
<body>
<br><br><br>
<div class="wrappermain container">


<div class="booking_left text-center">

   <div><img alt="classimg" src="/resources/img/mini.jpg" width="95%" height="300px;" class="img-rounded"/></div>
   <div class="classinfo" style="text-align: left;"><h3>클래스명</h3></div>
   <div class="classinfo" style="text-align: left;">
      <p>&nbsp;<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>&nbsp;간단한 장소</p>
      <p>&nbsp;<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp;간단한 장소</p>
      <p>&nbsp;<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;수강인원 최소~최대</p>
   </div>
   
   <div role="tabpanel">
     <!-- tabs -->
     <ul class="nav nav-tabs nav-justified" role="tablist" style="margin-left: 15px;">
       <li role="presentation" class="active"><a href="#" role="tab" data-toggle="tab">클래스 소개</a></li>
       <li role="presentation"><a href="#" role="tab" data-toggle="tab">위치</a></li>
       <li role="presentation"><a href="#" role="tab" data-toggle="tab">후기</a></li>
       <li role="presentation"><a href="#" role="tab" data-toggle="tab">문의</a></li>
       <li role="presentation"><a href="#" role="tab" data-toggle="tab">작가 후원하기</a></li>
     </ul>
     <!-- AJAX 결과값 출력할 div -->
     <div class="tab-content" id="classcontent" style="width: 770px; height: 400px; border: 1px solid red;"></div>
   </div><!-- tabpanel end -->
   
</div><!-- bookint_left div end -->


<div class="booking_right w3-round-xlarge">

<form method="post" action="#">
<table class="bookingtable w3-table w3-bordered">
<tr>
   <td colspan="1"><img src="/resources/img/mini.jpg" width="50px" height="50px" class="img-circle"/></td>
   <td colspan="3"><p><strong>작가이름</strong><br>작가설명작가설명작가설명</p></td>
</tr>
<tr>
   <td colspan="4"><p><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
   &nbsp;&nbsp;<strong>날짜 선택</strong><br>
   캘린더 삽입</p></td>
</tr>
<tr>
   <td colspan="4"><p><span class="glyphicon glyphicon-time" aria-hidden="true"></span>
   &nbsp;&nbsp;<strong>시간 선택</strong></p>
   <p><select name="timeselect" id="timeselect" class="form-control">
   <%--    <c:forEach items=""></c:forEach> //포이치문으로 시간 가져오기--%>
      <option value="0">오전 11:00</option>
      <option value="1">오후 1:00</option>
      <option value="2">오후 3:00</option>
   </select></p></td>
</tr>
<tr>
   <td colspan="4"><p><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
   &nbsp;&nbsp;<strong>인원 선택</strong></p>
   <p><select name="bookingcount" id="bookingcount" class="form-control">
      <option value="1">1 명</option>
      <option value="2">2 명</option>
      <option value="3">3 명</option>
      <option value="4">4 명</option>
   </select></p></td>
</tr>
<tr>
   <td colspan="2" style="text-align: left;"><span><strong>총 금액</strong></span></td>
   <td colspan="2" style="text-align: right;"><strong>불러온 값</strong></td>
</tr>
</table>

<!-- jquery onclick 사용해서 버튼 동작 수행 -->
<div class="text-center" id="btnDiv">
   <button type="button" class="w3-button w3-black w3-hover-indigo w3-round-xlarge">&nbsp;예약하기&nbsp;</button>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <button type="button" class="w3-button w3-black w3-hover-indigo w3-round-xlarge">&nbsp;장바구니&nbsp;</button>
</div><!-- btnDiv end -->

</form>

</div><!-- booking_right div end -->


</div><!-- booking div end -->


<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>

