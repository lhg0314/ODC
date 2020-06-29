<!-- 20200625 이인주 -->
<!-- 마이페이지 - 장바구니 - 결제(예약) -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import> 

<!-- 아임포트 API -->
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  
 <!-- jsp css -->
<style type="text/css">
.anone{
 text-decoration: none;
 color: black;
}

.anone:hover{
	text-decoration: none; 
	color: black; 
}

#bookingbox {
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 20px;
	padding: 20px;
	height: 100%;
	margin: 0;
}

.imgsize{
	width: 100px;
	height: 100px;
}

.cap {
color: black;
font-weight: bold;
}

.cen{
text-align: center;
}
</style>

<!-- paymentchk가 체크되어야만 pay클릭 가능 -->
<script type="text/javascript">
$(document).ready(function(){
	$("#paymentchk").change(function(){
	    if( $(this).is(":checked")){
	       $("#pay").attr("disabled", false);  
	    }else {
	       $("#pay").attr("disabled", true);  
	    }
	 });
})
</script>


<!-- 아임포트  -->
<script type="text/javascript">
$(document).ready(function() {
	// iamport 변수 초기화
	var IMP = window.IMP;
	IMP.init('imp05837192');	// 가맹점 식별코드, 회원가입해서 직접 넣어야합니다

	// 결제 모듈 불러오기
	$("#pay").click(function() {
		requestPayment();
	});
});

// 결제 요청 - 결제 모듈 불러오기
function requestPayment() {
	IMP.request_pay({
	    pg : 'html5_inicis', //PG사 - 'kakao':카카오페이, 'html5_inicis':이니시스(웹표준결제), 'nice':나이스페이, 'jtnet':제이티넷, 'uplus':LG유플러스, 'danal':다날, 'payco':페이코, 'syrup':시럽페이, 'paypal':페이팔
	    pay_method : 'card', //결제방식 - 'samsung':삼성페이, 'card':신용카드, 'trans':실시간계좌이체, 'vbank':가상계좌, 'phone':휴대폰소액결제
	    merchant_uid : 'merchant_' + new Date().getTime(), //고유주문번호 - random, unique
	    name : '${classpayment.classname }', //주문명 - 선택항목, 결제정보 확인을 위한 입력, 16자 이내로 작성
	    amount : '${classpayment.wishtotalprice }', //결제금액 - 필수항목
	    buyer_email : '${classpayment.useremail }', //주문자Email - 선택항목
	    buyer_name : '${classpayment.username }', //주문자명 - 선택항목
	    buyer_tel : '${classpayment.userphone }', //주문자연락처 - 필수항목, 누락되면 PG사전송 시 오류 발생
	    
	}, function(rsp) { // callback - 결제 이후 호출됨, 이곳에서 DB에 저장하는 로직을 작성한다
	    if ( rsp.success ) { // 결제 성공 로직
	        var msg = '결제가 완료되었습니다.';
// 	        msg += '고유ID : ' + rsp.imp_uid;
// 	        msg += '상점 거래ID : ' + rsp.merchant_uid;
// 	        msg += '결제 금액 : ' + rsp.paid_amount;
// 	        msg += '카드 승인번호 : ' + rsp.apply_num;
// 	        msg += '[rsp.success]';

	        
	        // 결제 완료 처리 로직
			//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			jQuery.ajax({
				url: "/mypage/class/payment", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
				type: 'POST',
				dataType: 'json',
				data: {
					// rsp객체를 통해 전달된 데이터를 DB에 저장할 때 사용한다
					merchant_uid : 'merchant_' + new Date().getTime(), //고유주문번호 - random, unique
// 				    name : '${classpayment.classname }', //주문명 - 선택항목, 결제정보 확인을 위한 입력, 16자 이내로 작성
				    amount : '${classpayment.wishtotalprice }', //결제금액 - 필수항목
// 				    buyer_email : '${classpayment.useremail }', //주문자Email - 선택항목
// 				    buyer_name : '${classpayment.username }', //주문자명 - 선택항목
// 				    buyer_tel : '${classpayment.userphone }', //주문자연락처 - 필수항목, 누락되면 PG사전송 시 오류 발생
				    bookingdate : '${classpayment.wishdate }', //클래스 예약날짜
				    wishcount :'${classpayment.wishcount}', // 예약인원
				    classno :'${classpayment.classno}', // 클래스 번호
				    	
				}
			
			}).done(function(data) {
				//[2] 서버에서의 응답 처리
				if ( data == 'success' ) {
					var msg = '결제가 완료되었습니다.';
// 					msg += '\n고유ID : ' + rsp.imp_uid;
// 					msg += '\n상점 거래ID : ' + rsp.merchant_uid;
// 					msg += '\n결제 금액 : ' + rsp.paid_amount;
// 					msg += '\n카드 승인번호 : ' + rsp.apply_num;
// 			        msg += '\n[done]';

					alert(msg);

					location.href="/mypage/class/booking";
					
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	        
	    } else { // 결제 실패 로직
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);

	    location.href="/mypage/class/wish";
	});
	
	
}

</script>

<div id="main">

	<span id="boardtitle" ><a href="/mypage/class/wish" class="anone">결제확인</a></span>
	<hr>

<table class="table-striped table-hover table-condensed">

<caption class="cap">회원 정보</caption>

<!-- 테이블 th -->
<!-- 결제 회원정보 -->
<tr style="background: thistle;" >
	<th style="width: 15%" class="cen">이름</th>
	<th style="width: 15%" class="cen">전화번호</th>
	<th style="width: 15%" class="cen">이메일</th>
</tr>


<!-- 값 출력  -->
<!-- 결제 회원정보 -->
<tr style="text-align: center;">
	<td>${classpayment.username }</td>
	<td>${classpayment.userphone }</td>
	<td>${classpayment.useremail }</td>
</tr>	
</table>	

<br>
	
<table class="table-striped table-hover table-condensed">

<caption class="cap">클래스 정보</caption>
<!-- 테이블 th -->
<!-- 결제 클래스 정보 -->
<tr style="background: thistle;" >
	<th style="width: 15%" class="cen">대표 사진</th>
	<th style="width: 13%" class="cen">클래스 이름</th>
	<th style="width: 10%" class="cen">작가 이름</th>
	<th style="width: 25%" class="cen">공방주소</th>
	<th style="width: 15%" class="cen">예약날짜</th>
	<th style="width: 13%" class="cen">예약 인원</th>
	<th style="width: 13%" class="cen">결제금액</th>
</tr>


<!-- 값 출력  -->
<tr style="text-align: center;">
	<td><img src="/upload/${classpayment.classrenamefilename }" alt="..." class="img-rounded imgsize"></td>
	<td>${classpayment.classname }</td>
	<td>${classpayment.artid }</td>
	<td>${addr2 }&nbsp;${addr3 }</td>
	<td>${classpayment.wishdate }</td>
	<td><fmt:formatNumber pattern="#,###" value="${classpayment.wishcount }" /></td>
	<td>${classpayment.wishtotalprice }</td>
</tr>	

</table>	
<br><br>
<label for="paymentchk">결제 내용에 동의하십니까?</label>	
<input type="checkbox" required="required" name="paymentchk" id="paymentchk">
<br><br>

<button id="pay" class="btn btn-default" disabled="disabled">결제</button>
	
<br>


</div> <!-- 전체를 감싸는 div -->

<!-- float 막는 clear -->
<div class="clearfix"></div>

<!-- 메인 footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>