<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<script type="text/javascript" src="/resources/js/httpRequest.js" ></script>
 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  

<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<script type="text/javascript">
function writeCmt()
{
	var form = document.getElementById("writeCommentForm");
	
	var userno = ${userno};
	var artno = ${artistinfo.artno};
	var classno=${classinfo.classNo};
	var content = writeCommentForm.comment.value;
	console.log(userno+","+artno+","+classno+","+content)
	
	if(!content)
	{
		alert("내용을 입력하세요.");
		return false;
	}
	else
	{	
		var param="userno="+userno+"&artno="+artno+"&comment="+content+"&classno="+classno;
			
		console.log(param);
		sendRequest("POST","/add/ask",param,ajaxFromServer);
	}
}

function ajaxFromServer(){
	if(httpRequest.readyState==4){//DONE,응답완료
		if(httpRequest.status==200){//OK
			console.log("정상응답")
			console.log("응답: "+httpRequest.responseText);
			document.location.reload(); // 상세보기 창 새로고침 댓글 새로고침
			document.getElementById("ask")[0].click();
			
		}else{
			console.log("AJAX요청/응답 에러")
		}
	}
}

var date='${classinfo.recruitEnddate }';
console.log(date)
$(function() {
    $( "#testDatepicker" ).datepicker({
    	//dateFormat: 'yyyy-mm-dd',
    	minDate: new Date(),
    	 maxDate:new Date('${classinfo.recruitEnddate }')
    
    });
});




$(document).ready(function() {
	
	var userno = ${userno};
	var artno = ${artistinfo.artno};
	var classno=${classinfo.classNo};
	
	var quantity = parseInt($('#quantity').val(), 10) + 1;
	var price = ${classinfo.classPrice}
	
	
	
	
	
	

	
	
	
	$("#num-add").off('click').on('click', function(){				
		quantity = parseInt($('#quantity').val(), 10) + 1;
		price = ${classinfo.classPrice}
		
		$('#quantity').val( quantity );				
		$('#price').empty().append( (price * quantity) + ' <span> 원</span>' );				
	});
	
	$('#num-sub').off('click').on('click', function(){
		
		quantity = parseInt($('#quantity').val(), 10);
		price = ${classinfo.classPrice};
		
		if(quantity > 1){
			quantity = 	quantity - 1;
		}
		
		$('#quantity').val( quantity );				
		$('#price').empty().append( (price * quantity) + ' <span> 원</span>' );
	});
	
	$("#wishlist").click(function(){//장바구니를 눌렀을때
		var param="userno="+userno+"&count="+quantity+"&totalPrice="+(price * quantity)+"&classno="+classno+"&wishdate="+$("#testDatepicker").val();
		
		console.log(param);
		sendRequest("POST","/insert/wishlist",param,ajaxFromServer1);
		
	})
	
	function ajaxFromServer1(){
		if(httpRequest.readyState==4){//DONE,응답완료
			if(httpRequest.status==200){//OK
				var resultText = httpRequest.responseText;
			
				if(resultText == 0){
					alert("장바구니 넣기 실패");
					
				} 
				else if(resultText == 1){ //이메일 전송 완료
					alert("장바구니 추가")
				}
				document.location.reload(); // 상세보기 창 새로고침 댓글 새로고침
				
			}else{
				console.log("AJAX요청/응답 에러")
			}
		}
	}
	
	
	
})

</script>




<style>
.show{
	position: relative;
}
.showRight{
	position: absolute;
	right: 0;
	font-size: 11px;
}
#content{
	position: relative;
    width: 1200px;
    margin: 0 auto;
    padding-top: 30px;
    height:auto;
    
}

#content-left{
	width: 740px;
     min-height: 1000px; 
     max-height: 100%;
     height:auto;
     margin-bottom: 50px;
}
 div {
 	display: block;
} 

#class-imgs{
	position: relative;
    border-radius: 10px 10px 0 0;
    overflow: hidden;
    height: 408px;
    
    background-color: #ebebeb;
}

#class-main-title{
	position: relative;
    border-radius: 0 0 10px 10px;
    border: 1px solid #d5dadf;
    border-top: 0 none;
    padding: 25px 30px 40px;
}

#main-text{
	word-break: keep-all;
    font-size: 24px;
    font-weight: bold;
    display: inline-block;
    white-space: nowrap;
    overflow: hidden;
    white-space: normal;
    line-height: 1.2;
    text-align: left;
    word-wrap: break-word;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    width: 90%;
}

#content-right{
    width: 436px;
    position: absolute;
    top: 30px;
    right: 0;
    border: 1px solid #d5dadf;
}

#class-confirm{
	border: 1px solid #e4e9ef;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    padding: 0;
}

#class-bookin1{
	padding: 25px;
    border-bottom: 1px solid #e4e9ef;
}

#class-bookin2{

}

#class-bookin3{
	overflow: hidden;
    padding: 30px 30px 30px;
}

#class-bookin4{

	padding-bottom: 24px;
}

#class-tab{
	position: relative;
    height: 44px;
    margin-top: 20px;
    display:table;
}

.swiper-container {
	width:740px;
	height: 407px;
}
.swiper-slide {
	text-align:center;
	display:flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
	align-items:center; /* 위아래 기준 중앙정렬 */
	justify-content:center; /* 좌우 기준 중앙정렬 */
}
.swiper-slide img {
	width:740px;
	height:420px;
	
	float: left;
}

.swiper-button-next{
}
.tab_content {
    padding: 25px 0 24px;
}

.class_info {
    padding: 0 0 30px;
    display: block;
    height:2000px;
     white-space: nowrap;
}

* {
/*     box-sizing: border-box;
    -webkit-tap-highlight-color: rgba(0, 0, 0, 0); */
}

.classFile{
	width:100px;
	margin: 0;
}

#classText{
	position: relative;
    left: 20px;
    margin-bottom: 50px;
}
#cassinfotext{
	position:absolute;
	left:100px;
}

#class-confirm{
    border: 1px solid #e4e9ef;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    padding: 0;
    margin-top: 18px;
}

.text01 {
    font-size: 18px;
    font-weight: bold;
}

.text02 {
    font-size: 12px;
    color: #9faab7;
}

#class-bookin1{

}
#class-bookin2{

}
#class-bookin3{

}
#class-bookin4{

}


.calendar{
	border-bottom: 1px solid #e4e9ef;
    padding: 10px 0 30px;
    align-content: center;
        margin-left: 67px;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$(".review").click(function(){//탭의 리뷰를 눌렀을때
			
			$.ajax({
				url: "/review/show",
                type: "GET",
                data: {
                    classno: '${classinfo.classNo}'
          
                },
                success: function (res) {
                	console.log("가져왔음")
                	
                },
			})
			
		})
		
		
		
	})
</script>

<div id="wrapper"><!-- 전체 감싸기  -->
	<div id="content"><!-- 내용물 감싸기  -->
		<div id="content-left"><!--클래스 상세내용  -->
			<div id="class-imgs"><!-- 클래스 메인 사진  -->

				<div class="swiper-container">
					<div class="swiper-wrapper">
					<c:forEach var="i" begin="0" end="${classDetail.size()-1 }">
						<div class="swiper-slide classFile">
							<img src="/upload/${classDetail[i].classRenameFilename}"/>
						</div>
					</c:forEach>
						
					</div>

					<!-- 네비게이션 버튼 -->
					<div class="swiper-button-next"></div>
					<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
					<div class="swiper-button-prev"></div>
					<!-- 이전 버튼 -->

					<!-- 페이징 -->
					<div class="swiper-pagination"></div>
				</div>
				

			</div>
			
			<div id="class-main-title"><!-- 클래스 타이틀  -->
				<div id="main-text">${classinfo.className }</div>
			</div>
			
			<div id="class-tab"><!-- 클래스 탭  -->

					<div role="tabpanel">

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#home"
								aria-controls="home" role="tab" data-toggle="tab">상세정보</a></li>
							<li role="presentation" class="review"><a href="#profile"
								aria-controls="profile" role="tab" data-toggle="tab">후기</a></li>
							<li role="presentation" class="ask" id="ask"><a href="#messages"
								aria-controls="messages" role="tab" data-toggle="tab">Q&A</a></li>
							<li role="presentation"><a href="#settings"
								aria-controls="settings" role="tab" data-toggle="tab">작가 정보</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active class-info" id="home"><!-- 상세정보  -->
								<h3>
									<b>&nbsp;&nbsp;상세설명</b>
								</h3>
								<br>
							<div id="classText">
								<p id="cassinfotext">${classinfo.classContent }</p>
							</div>
							<div id="detailImg-wrapper">
							<h3><b>&nbsp;&nbsp;클래스 사진</b></h3><br>
							
							<c:forEach var="i" begin="0" end="${classDetail.size()-1 }">
								<div class="swiper-slide">
									<img class="classFile"
										src="/upload/${classDetail[i].classRenameFilename}" />
								</div>
							</c:forEach>
							</div>
							<br><br><br>
							<h3><b>&nbsp;&nbsp;클래스 장소</b></h3><br>
							
							
							<div id="map" style="width: 100%; height: 350px;"></div>


							<script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78d749f240f49d7001ae30cc94cd9aa1&libraries=services"></script>
							<script>
							
							
	
								var container = document.getElementById('map'), options = {
									center : new kakao.maps.LatLng(33.450701,
											126.570667),
									level : 3
								};
								var map = new kakao.maps.Map(container, options);

								container.style.width = '600px';
								container.style.height = '350px';

								map.relayout();
								var mapContainer = document
										.getElementById('map'), // 지도를 표시할 div 
								mapOption = {
									center : new kakao.maps.LatLng(33.450701,
											126.570667), // 지도의 중심좌표
									level : 3
								// 지도의 확대 레벨
								};

								// 지도를 생성합니다    
								var map = new kakao.maps.Map(mapContainer,
										mapOption);
								
								map.setZoomable(false);
								map.setDraggable(false);  
								

								// 주소-좌표 변환 객체를 생성합니다
								var geocoder = new kakao.maps.services.Geocoder();

								// 주소로 좌표를 검색합니다
								geocoder
										.addressSearch(
												'${classaddr}',
												function(result, status) {

													// 정상적으로 검색이 완료됐으면 
													if (status === kakao.maps.services.Status.OK) {

														var coords = new kakao.maps.LatLng(
																result[0].y,
																result[0].x);

														// 결과값으로 받은 위치를 마커로 표시합니다
														var marker = new kakao.maps.Marker(
																{
																	map : map,
																	position : coords
																});

														// 인포윈도우로 장소에 대한 설명을 표시합니다
														var infowindow = new kakao.maps.InfoWindow(
																{
																	content : '<div style="font-size:10px;width:150px;text-align:center;padding:6px 0;">${artistinfo.artAddr}</div>'
																});
														infowindow.open(map,
																marker);

														// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
														map.setCenter(coords);
													}
												});
							</script>


						</div>
							<div role="tabpanel" class="tab-pane" id="profile"><!-- 리뷰  -->
							
								<div id="review-wrap"><!-- 리뷰 전체 감싸기 -->
									<div>     </div><!-- 리뷰 타이틀  -->
									
								
								</div>
							
							</div>
							<div role="tabpanel" class="tab-pane" id="messages"><!-- 문의  -->
								<div>
								문의 댓글창
								<c:if test="${userid !=null}">
									
										<form id="writeCommentForm">
												<div>${sessionScope.userid}</div>
											<!-- 본문 작성-->
												<div>
													<textarea name="comment" rows="4" cols="70"></textarea>
												</div>
											<!-- 댓글 등록 버튼 -->
												<div id="btn" style="text-align: center;">
													<p>
														<a href="#" onclick="writeCmt()">[댓글등록]</a>
													</p>
												</div>
										</form>
										
										
									
								</c:if>
								<c:if test="${askboard ne null }">
								<table class="table">
								<c:forEach var="i" begin="0" end="${askboard.size()-1 }">
									<tr>
										<td>${askboard[i].userid }</td>
										<td>${askboard[i].askContent }</td>
										<td>${askboard[i].askDate }</td>
									</tr>
									<c:if test="${askboard[i].commContent ne null }">
									<tr>
										<td>${askboard[i].artid }</td>
										<td>${askboard[i].commContent }</td>
										<td>${askboard[i].commDate }</td>
									</tr>
									</c:if>
								</c:forEach>
								
								</table>

								</c:if>
							</div>
							
								<div id="ask-wrap"><!-- 리뷰 전체 감싸기 -->
									<div>     </div><!-- 리뷰 타이틀  -->
									
								
								</div>
							
							</div>
							<div role="tabpanel" class="tab-pane" id="settings"><!-- 작가정보  -->
							

						</div>
						</div>

					</div>
				</div>
			<div id="content-right"><!--오른쪽   -->
				<div id="class-confirm"><!-- 결제창  -->

					<div id="class-bookin1">
						<div class="text01">
							클래스 예약
						</div>
						<div class="text02">예약일자, 신청 인원수 선택 후 신청하기 버튼을 눌러주세요.</div>

					</div>
					<div id="class-bookin2">
					<div class="text01">
							날짜 선택
						</div>
						<div class="calendar" id="scheduleCalendar">
						

							<input type="text" id="testDatepicker">
						</div>
					</div>
					<div id="class-bookin3">
						<div class="text01">
							예약인원
						</div>
						<div class="c03-count">
		                        <a class="btn"  id="num-sub">-</a>
		                        <input type="text" id="quantity" value="1" class="only-number"/>
		                        <a class="btn" id="num-add">+</a>
		                    </div>
		                    <span><h4>총인원:</h4></span><div class="c03-charge" id="price"></div>
					</div>
					<div id="class-bookin4">
					
						
					</div>
				
			 <input class="btn btn-default" type="button" id="wishlist" value="장바구니" style="margin-right:20px;margin-top:20px;">
			 <input class="btn btn-default" type="button" value="예약하기" style="margin-right:20px;margin-top:20px;">
				</div>
			</div>
		</div>
		
	
	</div>
</div>

</div>
<script>

new Swiper('.swiper-container', {
	pagination : { // 페이징 설정
		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
	navigation : { // 네비게이션 설정
		nextEl : '.swiper-button-next', // 다음 버튼 클래스명
		prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
	},
});

</script>

<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>