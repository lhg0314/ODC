<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import>    


<style type="text/css">
#class_upload_notice {
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 20px;
	padding: 20px;
}

.class_button {
  background-color: #b798b7; 
  color: white;
  border: none;
  
  text-align: center;
  text-decoration: none;
  font-size: 17px;
  font-weight: bold;
  
  display: inline-block;
  margin: 4px 2px;
  padding: 16px 32px;
  cursor: pointer;
  
}

.class_button:hover {
  background-color: #8c7599;
  color: white;
}


#notice_btn {

	text-align: center;
}

#class_upload_notice span:first-child {
	
	font-size: 25px;
	font-weight: bold;

}
</style>


<div id="main">

	<span id="boardtitle">공지사항</span>
	<hr>
	<br>
	
	<div id="class_upload_notice">
	
	<span>이벤트</span><br><br>
	
	<span>ODC SUMMER EVENT</span><br> 
	<span>시원한 여름 나기 이벤트가 시작되었습니다.</span><br>   
	<span>더운 여름을 시원한 공방에서 보낸 사진을 후기게시판에 올려주세요.</span><br>   
	<span>추첨을 통해 시원한 선물이 찾아갑니다.</span><br>  
	<span>자세한 사항은 공지사항을 참고해주세요.</span><br>  
	</div>
	
	<br>
	<div id="class_upload_notice">
	
	<span>버전 업데이트 알림</span><br><br>
	<span>VERSION 1.1</span><br> 
	<span>ODC는 고객의 안전과 정보 제공을 최우선으로 여기고 있습니다.</span><br>   
	<span>사이트를 통해 각 공방의 위치를 알 수 있습니다.</span><br>   
	<span>전반적인 UI 개선하였습니다.</span><br>  
	<span>문의요청을 통해 요청하신 문제들을 수정하였습니다.</span><br>   
	<span>자세한 사항은 공지사항을 참고해주세요.</span><br>  
	</div>
	
	<br><br>
	
	<div id="notice_btn"><a href="#"><button class="class_button">+ 공지사항</button></a></div>

	<br><br>

</div> <!-- 전체를 감싸는 div -->

<div class="clearfix"></div>


<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>