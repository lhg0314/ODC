<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>


<script type="text/javascript">
$(document).ready(function(){
	
	var category = '<c:out value="${category }"/>'
	
	if( category == 0){
		$("#cateSel option").eq(0).attr("selected","selected");
	}else if( category == 1){
		$("#cateSel option").eq(1).attr("selected","selected");
	}else if( category == 2){
		$("#cateSel option").eq(2).attr("selected","selected");
	}else if( category == 3){
		$("#cateSel option").eq(3).attr("selected","selected");
	}else if( category == 4){
		$("#cateSel option").eq(4).attr("selected","selected");
	}else if( category == 5){
		$("#cateSel option").eq(5).attr("selected","selected");
	}else if( category == 6){
		$("#cateSel option").eq(6).attr("selected","selected");
	}else if( category == 7){
		$("#cateSel option").eq(7).attr("selected","selected");
	}
	
})
</script>

<!-- 레이아웃 -->
<style type="text/css">

#main {

   width: 1200px;
    height: 100%;
     margin: 100px auto; 
    text-align: center;
}

#title {

   color: #845f84;
   font-size: 35px;
   font-weight: bold;
   margin: 10px;
}

#cateSel { 

   float: left;
   margin: 0 40px; 
}

#section {

   width: 1100px;
   height: 100%;
   margin: 0 auto;
}

#totop {

   width: 50px;
   height: 50px;
   padding: 4px 0;
   
   position: fixed;
   bottom: 30px;
   right: 30px;
}

</style>



<!-- 클래스들 -->
<style type="text/css">

#newClass {

   margin: 100px 0;
}

#li { 

   list-style: none; 
   width: 200px;
    height: 320px;
   margin: 0 30px 50px;
   float: left;
   display: inline-block;
}

#eachClass {

   color: black;
   border: 1px solid #eee;
}

#eachClass #img {
   
   width: 100%;
   height: 200px;
   overflow: hidden;
}

#eachClass #img:hover img {

   /* 커서 올렸을때 살짝 확대되게 하기 */
   width: 205px;
   height: 205px;
}

#eachClass a:hover { 

   text-decoration: none; 
   color: black;
} 

#sort { 
   
    margin: 5px;
    font-size: 15px;
    color: #999;
} 

#classname { 
   
   height: 40px;
    
    font-size: 16px;
    color: black; 
    
    /* 제목 길때 ...으로 생략하기 */
   overflow: hidden;
    white-space: nowrap; 
    text-overflow: ellipsis; 
} 

</style>




<div id="main">

   
   <div id="title">인기 클래스</div>
   <div style="color: #666;">많은 분들이 사랑해주신 클래스입니다</div><br>
   <hr>
   
   <form action="/hotclass" method="post" id="cateForm">
   <select name="cateSel" id="cateSel" onchange="this.form.submit();">
      <option value="0" selected>카테고리</option>
      <option value="1">플라워</option>
      <option value="2">음악</option>
      <option value="3">수공예</option>
      <option value="4">요리</option>
      <option value="5">뷰티</option>
      <option value="6">미술</option>
      <option value="7">기타</option>
   </select>
   </form>
   
   
   <section id="section">
   
      <ul id="newClass">
   
   
      <c:if test="${empty cinfo }">
         <div style="font-size: 20px; color: #999;">개설된 클래스가 없습니다...</div>
      </c:if>
   
   
      <c:forEach items="${cinfo }" var="c" >
         <li id="li">
         <div id="eachClass">
            <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
               <a href="userclass/detail?classno=${c.classno }"><img src="/upload/${c.filename }" alt="썸네일" width="200px;" height="200px;"></a>
<!--    테스트용      <a href="#"><img src="/resources/img/Tulips.jpg" alt="썸네일" width="200px;" height="200px;"></a> -->
            </div>
            <div id="sort">
               <span>${c.location }</span> | <span>${c.category }</span>
            </div>
            <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
               <a href="/userclass/detail?classno=${c.classno }"><span>${c.className }</span></a>
            </div>
         </div>
         </li>
      </c:forEach>
      
      </ul>
   
   </section>


</div><!-- end main -->

</body><!-- end body (header에서 옴) -->

<div class="clearfix"></div>

<c:if test="${not empty cinfo }">
	<c:import url="/WEB-INF/paging/pagingHotclass.jsp" />
</c:if>


<div id="totop">
   <a href="#"><img alt="up" src="/resources/img/totop.png" width="40px" height="35px"/></a>
</div>

<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>