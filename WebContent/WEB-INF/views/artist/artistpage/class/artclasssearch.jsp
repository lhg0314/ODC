<!-- 이인주 20200623 -->
<!-- 사업자 클래스이름 검색 결과 -->

<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<style type="text/css">
.textcenter{text-align: center;}

.totalsalesbox{
	width: 960px;
	margin: 0 auto;
	text-align: center;
	padding: 0;
}

#serchbox{
	width: 250px;
	margin: 0 auto;
	text-align: left;
	float: left;
}

</style>

<div id="main">
<a href="/artistpage/class/sales" class="aTagStyleNone"><span id="boardtitle">클래스</span></a>
<hr>
<a href="/artistpage/class/sales" class="aTagStyleNone"><span id="boardtitle">클래스 매출 현황</span></a>
<br>

<!-- 사업자 클래스 이름 검색 -->
<div id="serchbox" >
<form action="/artist/classsales/search" method="post">

<div class="row">
  <div class="col-lg-6" style="padding: 0;">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="클래스 제목 검색" style="width: 180px; " name="classname">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Search</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->

</form>
</div>

<!-- 사업자 매출 리스트 -->
<table class="table table-striped table-hover table-condensed textcenter" >
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${classname } 수익 리스트</h4></caption>

<!-- 테이블 th -->
<tr style="background: thistle;" >
	<th style="width: 10%">예약 번호</th>
	<th style="width: 10%">예약자 아이디</th>
	<th style="width: 10%">결제날짜</th>
	<th style="width: 10%">예약날짜</th>
	<th style="width: 10%">예약 인원</th>
	<th style="width: 10%">총금액</th>
	<th style="width: 10%">수익금</th>
</tr>

<!-- 매출이 없을 때  -->
<c:if  var="mon" test="${empty choartsalessearch }">
<tr>
<td colspan="7" style="color: thistle; font-weight: bold;">수익 리스트가 없습니다</td>
</tr>
<!-- 사업자 매출 보이기 -->
<tr style="background: thistle;">
<th colspan="6" style="text-align: right;">사업자 총수입</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="0" />원</th>
</tr>
</table>
</c:if>

<!--수익이 있을 때 -->
<c:if  var="mon" test="${!empty choartsalessearch }">
<!-- 값 출력 -->
<c:forEach items="${choartsalessearch }" var="search" >
<tr >
	<td>${search.bookingNo }</td>
	<td>${search.userid }</td>
	<td><fmt:formatDate value="${search.paymentDate }" pattern="yyyy-MM-dd"/></td>
	<td><fmt:formatDate value="${search.bookingDate }" pattern="yyyy-MM-dd"/></td>
	<td>${search.bookingCount }</td>
	<td><fmt:formatNumber pattern="#,###" value="${search.totalPrice }" /></td>
	<td><fmt:formatNumber pattern="#,###" value="${(search.totalPrice)*0.9 }" /></td>
</tr>
</c:forEach>


<!-- 메소드 만들어야함 -->
<!-- 사업자 수익 보이기 -->
<tr style="background: thistle;">
<th colspan="6" style="text-align: right;">사업자 총수익</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="${0 }" />원</th>
</tr>
</table>
<!--페이징  -->
<%-- <c:import url="/WEB-INF/layout/paging/artclasssalesnowpaging.jsp"></c:import> --%>
</c:if>



</div> <!-- 전체를 감싸는 div -->


<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>