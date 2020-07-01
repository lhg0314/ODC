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
$(document).ready(function(){
/* 	$("#supportbtn").click(function(){

		var userno = ${userno};
		var artno = ${artistinfo.artno};
		var donPrice=donationForm.support-price.value;
		
		if(userno==''){
			alert("로그인후 이용가능합니다")
			return false;
		}
		console.log(donPrice)
		$.ajax({
			type: "POST"//요청메소드
			,url:"/user/support"
			,data:{
				userno: ${userno}
				,artno:${artistinfo.artno}
				,price:donPrice
			}
			
			,success:function(res){
				alert("후원완료")
				
				//$('#myModal3').modal('hide');
			}
			,error:function(){
				
			}
		})
	
	}); */
	
})
</script>

<script> /*  예약페이지 스크롤 따라다니는 기능 */
$(function(){  
var currentPosition = parseInt($("#content-right").css("top")); 
    $(window).scroll(function() { 
            var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다. 
            $("#content-right").stop().animate({"top":position+currentPosition+"px"},300); 
    });
});
</script>


<script type="text/javascript">

 function donation(){
	
	var userno = ${userno};
	var artno = ${artistinfo.artno};
	var donPrice=donationForm.support.value;
	console.log(donPrice)
	if(!donPrice)
	{
		alert("가격을 입력하세요.");
		return false;
	}else{	
		var param="userno="+userno+"&artno="+artno+"&price="+donPrice;
			
		console.log(param);
		sendRequest("POST","/user/support",param,ajaxFromServer2);
	}
	
} 

function ajaxFromServer2(){
	if(httpRequest.readyState==4){//DONE,응답완료
		if(httpRequest.status==200){//OK
			alert("후원 완료")
			
			
		}else{
			console.log("AJAX요청/응답 에러")
		}
	}
}



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
			
		
		sendRequest("POST","/add/ask",param,ajaxFromServer);
	}
}

function ajaxFromServer(){
	if(httpRequest.readyState==4){//DONE,응답완료
		if(httpRequest.status==200){//OK
			
			document.location.reload(); // 상세보기 창 새로고침 댓글 새로고침
			document.getElementById("ask")[0].click();
			
		}else{
			console.log("AJAX요청/응답 에러")
		}
	}
}





var date='${classinfo.recruitEnddate }';

$(function() {
    $( "#testDatepicker" ).datepicker({
    	//dateFormat: 'yyyy-mm-dd',
    	 minDate: new Date('${classinfo.recruitStartdate }'),
    	 maxDate:new Date('${classinfo.recruitEnddate }')
    
    });
});




$(document).ready(function() {
	
	var userno = ${userno};
	var artno = ${artistinfo.artno};
	var classno=${classinfo.classNo};
	
	var quantity = parseInt($('#quantity').val(), 10) + 1;
	var price = ${classinfo.classPrice}
	
	console.log(quantity)
	
	

	
	
	
	$("#num-add").off('click').on('click', function(){				
		quantity = parseInt($('#quantity').val(), 10) + 1;
		price = ${classinfo.classPrice}
		console.log(quantity)
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
		console.log(userno)
		if(!$("#testDatepicker").val()){
			alert("날짜를 정하세요");
			return false;
		}
	
		if(quantity==0){
			alert("인원을 정하세요");
			return false;
		}
		if(quantity>5){
			alert("최대 예약인원은 5명입니다");
			return false;
		}
	
		
		var param="userno="+userno+"&count="+quantity+"&totalPrice="+(price * quantity)+"&classno="+classno+"&wishdate="+$("#testDatepicker").val();
		
		
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
				
			}
		}
	}
	
	$("#bookinglist").click(function(){//예약하기를 눌렀을때
		var param="userno="+userno+"&count="+quantity+"&totalPrice="+(price * quantity)+"&classno="+classno+"&wishdate="+$("#testDatepicker").val();
		location.href="/userclass/payment?"+param;
		
	})
	
})

</script>




<style>

#artInfoBox{
align-content: center;
text-align: center;
width:740px;
border:2px solid thistle;
/* background-color: thistle; */
margin-top: 20px;
height:200px;

}
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
    margin-bottom: 20px;
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

.artComm{
	background-color: #ccc;
}
.calendar{
	border-bottom: 1px solid #e4e9ef;
    padding: 10px 0 30px;
    align-content: center;
        margin-left: 67px;
}

 .row1{
margin-top: 40px;
    width: 240px;
    float: left;
    margin-right: 40px;

} 
.caption{
text-align: center;
}

.table{
width:740px;
margin-top: 20px;
}


.reviewImg{
width: 100px;
height:100px;
}

.review-wrapper{
position: relative;
width:740px;

}
.review-id{
width:100px;
position:absolute;
left:10px;
top:0;
font-size: 18px;

}
.review-date{
width:100px;
right:10px;
top:20px;
position:absolute;
font-size: 15px;
color: #ccc;
}
.review-sat{

margin-top:30px;
font-size: 15px;
color: #8878CD;
}
.review-content{
margin-top: 10px;

}
.review-img{

height:100px;
margin-top: 10px;

}

.review-wrapper > div{

}

.thumbnail {
    display: block;
    padding: 4px;
    margin-bottom: 20px;
    line-height: 1.42857143;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px;
    -webkit-transition: border .2s ease-in-out;
    -o-transition: border .2s ease-in-out;
    transition: border .2s ease-in-out;
    height: 230px;
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
							
								<br><br><h3>
									<b>&nbsp;&nbsp;상세설명</b>
								</h3>
								<br>
							<div id="classText">
								<p id="cassinfotext">${classinfo.classContent }</p>
							</div>
							<div id="detailImg-wrapper">
							<h3><b>&nbsp;&nbsp;클래스 사진</b></h3>
							<hr>
							
							<c:forEach var="i" begin="0" end="${classDetail.size()-1 }">
								<div class="swiper-slide">
									<img class="classFile"
										src="/upload/${classDetail[i].classRenameFilename}" />
								</div>
							</c:forEach>
							</div>
							<br><br><br>
							<h3><b>&nbsp;&nbsp;클래스 장소</b></h3><br>
							<hr>
							
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
									<c:if test="${reviewList.size() ne 0 }">
									<table class="table table-striped">
										<c:forEach var="i" begin="0" end="${reviewList.size()-1 }">
										<tr>
											<td  class="review-wrapper"><div>
													<div class="review-id">${reviewList[i].userid }</div>
													<div class="review-date">${reviewList[i].reviewDate }</div> 
													<div class="review-sat">만족도 [ ${reviewList[i].sta } ]</div>
													<div class="review-content">${reviewList[i].content }</div> 
													<c:if test="${reviewList[i].filename ne null }">
													<div class="review-img"><img src="/upload/${reviewList[i].filename}" class="reviewImg"></div>
													</c:if>
												</div></td>
										</tr>
										</c:forEach>
									</table>
								</c:if>
								
								</div>
							
							</div>
							
							
							<div role="tabpanel" class="tab-pane" id="messages"><!-- 문의  -->
								<div>
								
								<c:if test="${userid !=null}">
									
										<form id="writeCommentForm">
												<br>
											<!-- 본문 작성-->
												<div>
													<textarea name="comment" rows="4" cols="80" style="resize: none;"></textarea>
												</div>
											<!-- 댓글 등록 버튼 -->
												<div id="btn" style="text-align: center;">
													<p>
														<a class="btn btn-info" onclick="writeCmt()">댓글등록</a>
													</p>
												</div>
										</form>
										
										
									
								</c:if>
								<c:if test="${askboard.size() ne 0 }">
								<table class="table">
								<c:forEach var="i" begin="0" end="${askboard.size()-1 }">
									<tr>
										<td>${askboard[i].userid }</td>
										<td>${askboard[i].askContent }</td>
										<td>${askboard[i].askDate }</td>
									</tr>
									<c:if test="${askboard[i].commContent ne null }">
									<tr class="artComm">
										<td>&nbsp;&nbsp;&nbsp;&nbsp;↳</td>
										<td>${askboard[i].artid }</td>
										<td>${askboard[i].commContent }</td>
										<td>${askboard[i].commDate }</td>
									</tr>
									</c:if>
								</c:forEach>
								
								</table>

								</c:if>
							</div>
							
								
							
							</div>
							
							
							<div role="tabpanel" class="tab-pane" id="settings"><!-- 작가정보  -->


							<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true"><!--  작가후원 모달창 -->
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">후원하기</h4>
										</div>
										<div class="modal-body">
											<form class="form-inline" id="donationForm">
											
												<div class="form-group">
													<label for="userid">후원하는 사람 : ${userid }</label> <input
														type="hidden" class="form-control" id="userid" name="userno" value="${userno }"
														placeholder="Jane Doe">
												</div>
												<br><br>
												
												<div class="form-group">
													<label for="artid">후원받는 작가님 : ${artistinfo.artid }</label> <input
														type="hidden" class="form-control" id="artid"
														placeholder="jane.doe@example.com">
												</div>
													<br><br>
													
												<div class="form-group">
													<label for="support-price">후원 금액</label> <input
														type="number" class="form-control" id="support" name="support-price"
														placeholder="후원할 금액을 입력해 주세요"><span>원</span>
												</div>
												
												<br><br>
												<a  class="btn btn-default"  onclick="donation()">후원하기</a>
												<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
											</form>
										</div>

									</div>
								</div>
							</div>

							<div id="artInfoBox" style="text-align: center;">
								<br>
								<br>
								<p style="text-align: center;">${artistinfo.artid }</p>
								<p style="text-align: center;">${artistinfo.artContent }</p>
								<c:if test="${userid ne null }"><!-- 로그인 했을때만 후원창 보임  -->
									<div id="btn" style="text-align: center;">
										<p>
											<a class="btn" data-toggle="modal" data-target="#myModal3">[후원하기]</a>&nbsp;&nbsp;
										</p>
									</div>
								</c:if>

							</div>
							<h4>작가님의 다른 클래스 </h4>
								<hr>
								<div  id="classbox-wrapper">
								<c:forEach var="i" begin="0" end="${clist.size()-1 }">
									<a href="/userclass/detail?classno=${clist[i].classno }">
										<div class="row1">

											<div class="thumbnail"><br>
												<img src="/upload/${clist[i].classfilename}" alt="..."
													style="width: 150px; height: 150px">
												<div class="caption">
													<span>${clist[i].classname }</span>


												</div>
											</div>

										</div>
									</a>
								</c:forEach>


							</div>
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
					<div class="text01"><br>
							&nbsp;&nbsp;&nbsp;&nbsp;날짜 선택
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
		                        <input type="text" id="quantity" value="0" class="only-number"/>
		                        <a class="btn" id="num-add">+</a>
		                    </div>
		                    <span><h4>총인원:</h4></span><div class="c03-charge" id="price"></div>
					</div>
					<div id="class-bookin4">
					
						
					</div>
				<div id="right-btn">
			 <a class="btn btn-default"  id="wishlist"  style="margin-right:20px;margin-top:20px;margin-left:30%;background: #ccc;">
			 	<img src="/resources/img/classbutton/wishlist_btnimg.png">
			 </a>
			 <a class="btn btn-default" id="bookinglist"  style="margin-right:20px;margin-top:20px;background: thistle;">
			 	<img src="/resources/img/classbutton/reservation_btnimg.png">
			 </a>
			 <br><br>
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
