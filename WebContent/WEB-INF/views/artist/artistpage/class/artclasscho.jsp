<!-- 이인주 20200623 -->
<!-- 사업자 매출에서 달 선택 -->

<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

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

#moncho{
	width: 960px;
	margin: 0 auto;
	text-align: right;
}

#serchbox{
	width: 230px;
	margin: 0 auto;
	text-align: left;
	float: left;
}

.aTagStyleNone{
color: black;
text-decoration: none;
}

.aTagStyleNone:hover{
color: black;
text-decoration: none;
}

</style>

<div id="main">
<a href="/artistpage/class/sales" class="aTagStyleNone"><span id="boardtitle">클래스 매출 현황</span></a>
<hr>

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

<div id="moncho">
<form action="/artistpage/class/sales" method="post">
	<select id='month' name='month' onchange="this.form.submit();">
	  <option value='0' selected>-- 월 선택 --</option>
	  <option value='1'>1월</option>
	  <option value='2'>2월</option>
	  <option value='3'>3월</option>
	  <option value='4'>4월</option>
	  <option value='5'>5월</option>
	  <option value='6'>6월</option>
	  <option value='7'>7월</option>
	  <option value='8'>8월</option>
	  <option value='9'>9월</option>
	  <option value='10'>10월</option>
	  <option value='11'>11월</option>
	  <option value='12'>12월</option>
	 </select>
	 
</form>
</div>

<!-- 현재 날짜 -->
<c:set var="d" value="<%=new Date() %>" />
<fmt:formatDate value="${d }" pattern="M" var="nowformat"/>
<c:set var="nowday" value="${nowformat }"></c:set>

<!-- 사업자 매출 리스트 -->
<table class="table table-striped table-hover table-condensed textcenter" >
<c:if  var="mon" test="${empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${nowday }월 수익 리스트</h4></caption>
</c:if>

<!-- 사업자 매출 리스트 -->
<c:if  var="mon" test="${!empty month }">
<caption  class="totalsalesbox"><h4 style="font-weight: bold;">${month }월 수익 리스트</h4></caption>
</c:if>

<!-- 테이블 th -->
<tr style="background: thistle;" >
	<th style="width: 10%">예약 번호</th>
	<th style="width: 10%">예약자 아이디</th>
	<th style="width: 15%">클래스 이름</th>
	<th style="width: 10%">결제날짜</th>
	<th style="width: 10%">예약날짜</th>
	<th style="width: 10%">예약 인원</th>
	<th style="width: 10%">총금액</th>
	<th style="width: 10%">수익금</th>
</tr>

<!-- 매출이 없을 때  -->
<c:if  var="mon" test="${empty choartsales }">
<tr>
<td colspan="8" style="color: thistle; font-weight: bold;">수익 리스트가 없습니다</td>
</tr>
<!-- 사업자 매출 보이기 -->
<tr style="background: thistle;">
<th colspan="7" style="text-align: right;">사업자 총수입</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="0" />원</th>
</tr>
</table>
</c:if>

<!--수익이 있을 때 -->
<c:if  var="mon" test="${!empty choartsales }">
<!-- 값 출력 -->
<c:forEach items="${choartsales }" var="cho" >
<tr >
	<td>${cho.bookingNo }</td>
	<td>${cho.userid }</td>
	<td>${cho.classname }</td>
	<td><fmt:formatDate value="${cho.paymentDate }" pattern="yyyy-MM-dd"/></td>
	<td><fmt:formatDate value="${cho.bookingDate }" pattern="yyyy-MM-dd"/></td>
	<td>${cho.bookingCount }</td>
	<td><fmt:formatNumber pattern="#,###" value="${cho.totalPrice }" /></td>
	<td><fmt:formatNumber pattern="#,###" value="${(cho.totalPrice)*0.9 }" /></td>
</tr>
</c:forEach>


<!-- 메소드 만들어야함 -->
<!-- 사업자 수익 보이기 -->
<tr style="background: thistle;">
<th colspan="7" style="text-align: right;">사업자 총수익</th>
<th class="textcenter"><fmt:formatNumber pattern="#,###" value="${choartsalestot*0.9 }" />원</th>
</tr>
</table>
<!--페이징  -->
<c:import url="/WEB-INF/layout/paging/artclasssaleschopaging.jsp"></c:import>
</c:if>


</div> <!-- 전체를 감싸는 div -->


<!-- float 막기 -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>