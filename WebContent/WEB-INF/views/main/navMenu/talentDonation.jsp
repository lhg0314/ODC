<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<script type="text/javascript">
$(document).ready(function(){
	var category = '<c:out value="${category }"/>'
	
	if( category == 0){
		$("#select option").eq(0).attr("selected","selected");
	}else if( category == 1){
		$("#select option").eq(1).attr("selected","selected");
	}else if( category == 2){
		$("#select option").eq(2).attr("selected","selected");
	}else if( category == 3){
		$("#select option").eq(3).attr("selected","selected");
	}else if( category == 4){
		$("#select option").eq(4).attr("selected","selected");
	}else if( category == 5){
		$("#select option").eq(5).attr("selected","selected");
	}else if( category == 6){
		$("#select option").eq(6).attr("selected","selected");
	}else if( category == 7){
		$("#select option").eq(7).attr("selected","selected");
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

#main > form > select { 

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

#talentDonation {

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

.CateLoc{

    margin: 5px;
    font-size: 15px;
    color: #999;
}


#classname { 
/*    width: 200px; */
   height: 40px;
    
    font-size: 18px; 
    color: black; 
    
    /* 제목 길때 ...으로 생략하기 */
   overflow: hidden;
    white-space: nowrap; 
    text-overflow: ellipsis; 
} 

.aNone{
	text-decoration: none;
}

</style>




<div id="main">

   
   <div id="title">재능기부 클래스</div>
   <div style="color: #666;">무료로 다양한 클래스를 만나보세요</div><br>
   <hr>
   
   <form action="/talentDonation" method="post" id="cateForm">
   <select name="category" onchange="this.form.submit();" id="select">
      <option value="0">카테고리</option>
      <option value="1">플라워</option>
      <option value="2">음악</option>
      <option value="3">수공예</option>
      <option value="4">요리</option>
      <option value="5">뷰티</option>
      <option value="6">미술</option>
      <option value="7">기타</option>
   </select>
   </form>
   
   <c:if test="${empty list }">
        <div style="font-size: 20px; color: #999;  text-align: center;">개설된 클래스가 없습니다...</div>
    </c:if>

	<c:if test="${not empty list }">
   
   <section id="section">
   
      <ul id="talentDonation"><!-- 클래스 목록 한줄 -->
   
      <c:forEach items="${list }" var="c" >
      
         <li id="li">
         <a href="/userclass/detail?classno=${c.classNo }" class="aNone">
        	<div id="eachClass">
	            <div id="img"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
	               <img src="/upload/${c.filename }" alt="썸네일" width="200px;" height="200px;">
	            </div>
	            <div class="sort CateLoc">
	                 <div align="center" class="CateLoc">${c.location } | ${c.category }</div>
	            </div>
	            <div id="classname"><!-- 링크 누르면 클래스 상세 페이지로 이동 -->
	               <span>${c.className }</span>
	            </div>
	        </div>
	        </a>
         </li>
      
      </c:forEach>
      
      </ul>
   
   </section>
	</c:if>

</div><!-- end main -->

</body><!-- end body (header에서 옴) -->
<div class="clearfix"></div>

<c:if test="${not empty list }">
<c:import url="/WEB-INF/paging/pagingTalent.jsp" />
 </c:if>

<div id="totop">
   <a href="#"><img alt="up" src="/resources/img/totop.png" width="40px" height="35px"/></a>
</div>


<br>
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>