<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- main header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 


<div id="main">
	<span id="boardtitle">클래스 등록</span>
	<hr>
	<br>
	
	 
	<div id="class_upload_notice">
		<span id="ctitle">&nbsp;클래스 등록을 위한 공지사항&nbsp;</span><br><br><hr><br>
			<div id="class_upload_notice_content">
				<span>ODC 클래스를 등록하기 전 꼭 숙지해주시기 바랍니다.</span><br><br>  
				<span>ODC 규정상 클래스 등록 시 개인정보 및 SNS 등은 노출이 불가능합니다.</span><br><br>
				<span>클래스 문의 및 안내 등은 ODC 문의 게시판을 통해주세요.</span><br><br>
				<span>수강생이 먼저 연락이 오지 않더라도 연락을 취하셔서 스케줄 조정을 해주세요.</span><br><br>
				<span>이상 ODC를 이용하시는데 불편이 없으시길 바랍니다.</span><br><br>
				<span>감사합니다.</span><br>
			</div>
	</div>
	
	<br>
	
	<div id="btn"><a href="/artist/class/app"><button class="class_button">+ 클래스 등록</button></a></div>

<div class="clearfix"></div>
</div> <!-- 전체를 감싸는 div -->
</section>



<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>