<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 


<div id="main">
	<span id="boardtitle">클래스 등록</span>
	<hr>
	<br>
	
	<div id="class_upload_notice">
	 
	<span>클래스 등록을 위한 공지사항</span><br><br>
	
		<span>- 등록 버튼을 누르기 전에 모든 정보가 잘 작성되었는지 확인해 주세요.</span><br>
		<span>- 클래스 소개에 클래스를 진행할 시간을 반드시 명시해 주세요.</span><br>
		<span>- 클래스 관련 공지사항이 있다면 클래스 소개에 입력해 주세요.</span><br>
		<span>- 클래스 검토는 1~2일 정도 소요될 예정이며 검수가 완료되면 바로 사이트에 게시됩니다.</span><br>
		<span>- 검토 상황은 클래스 검토 페이지에서 확인해주십시오.</span><br>
		<span>- 클래스 등록, 검토, 관리 등에 대한 문의가 있다면 관리자 SNS를 통해 문의해주시기 바랍니다.</span><br>

	</div>
	
	<br>
	
	<div id="btn"><a href="/artist/class/app"><button class="class_button">+ 클래스 등록</button></a></div>

<div class="clearfix"></div>
</div> <!-- 전체를 감싸는 div -->
</section>



<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>