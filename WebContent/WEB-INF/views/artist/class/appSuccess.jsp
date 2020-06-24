<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 

<style type="text/css">
#SvnclassApp{
	color: #e7717d;
}

#classAppSuccess{
	margin: 0 auto;
}

#classAppSuccess p{
	margin: 71px auto;
}

#classAppSuccess p span{
	font-size: 20px;
	font-weight: bold;
	color: thistle;
}
#classAppSuccess{
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 20px;
	padding: 20px;
	
	width: 400px;
	height: 300px;
}
</style>

<div id="main">
	<span id="boardtitle">클래스 등록</span>
	<hr>
	<br>
	 
	<div id="classAppSuccess" class="text-center">
	
	
	<p><span>클래스가 등록되었습니다</span><br><br><br>
	클래스 검수 확인 페이지에서 검수 상황과 결과를<br> 확인할 수 있습니다.</p>
	
	</div>
<div class="clearfix"></div>
</div> <!-- 전체를 감싸는 div -->
</section>



<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>