<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<!-- mypage header -->    
<c:import url="/WEB-INF/layout/user/mypageheader.jsp"></c:import>    


<div id="main">
<!-- 	<hr> -->
	<span id="boardtitle">클래스</span>
	<hr>
	<br>

	<span id="boardtitle">최근 수강 클래스</span>
	<a href="#" id="viewmore">더보기 &raquo;</a>
	<br>
		    
	<div class="row">
	
	    <div class="col-xs-5 col-xs-4">
	        <div class="thumbnail">
		        <img src="/resources/img/mini.jpg" alt="미니언즈">
			        <div class="caption">
				        <h3 id="classtitle">Class Title</h3>
				        <p>클래스설명클래스설명</p>
			        </div>
	        </div>
	    </div>
	    
	    <div class="col-xs-5 col-xs-4">
	        <div class="thumbnail">
		        <img src="/resources/img/mini.jpg" alt="미니언즈">
			        <div class="caption">
				        <h3 id="classtitle">Class Title</h3>
				        <p>클래스설명클래스설명</p>
			        </div>
	        </div>
	    </div>
	    
	    <div class="col-xs-5 col-xs-4">
	        <div class="thumbnail">
		        <img src="/resources/img/mini.jpg" alt="미니언즈">
			        <div class="caption">
				        <h3 id="classtitle">Class Title</h3>
				        <p>클래스설명클래스설명</p>
			        </div>
	        </div>
	    </div>
	    
   </div>
	
	
	<br><br><br>
	

	<span id="boardtitle">클래스 장바구니</span>
	<a href="#" id="viewmore">더보기 &raquo;</a>
	<br>
	
		<div class="row">
	
	    <div class="col-xs-5 col-xs-4">
	        <div class="thumbnail">
		        <img src="/resources/img/mini.jpg" alt="미니언즈">
			        <div class="caption">
				        <h3 id="classtitle">Class Title</h3>
				        <p>클래스설명클래스설명</p>
			        </div>
	        </div>
	    </div>
	    
	    <div class="col-xs-5 col-xs-4">
	        <div class="thumbnail">
		        <img src="/resources/img/mini.jpg" alt="미니언즈">
			        <div class="caption">
				        <h3 id="classtitle">Class Title</h3>
				        <p>클래스설명클래스설명</p>
			        </div>
	        </div>
	    </div>
	    
	    <div class="col-xs-5 col-xs-4">
	        <div class="thumbnail">
		        <img src="/resources/img/mini.jpg" alt="미니언즈">
			        <div class="caption">
				        <h3 id="classtitle">Class Title</h3>
				        <p>클래스설명클래스설명</p>
			        </div>
	        </div>
	    </div>
	    
   </div>
	
	
	<br><br><br>
	
	
	<span id="boardtitle">클래스 수강 후기</span>
	<a href="#" id="viewmore">더보기 &raquo;</a>
	<br>
	
	<div>
		<table id="table" class="table">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Value</th>
			</tr>
			
			<tr class="table_content">
				<td>1</td>
				<td>가나다</td>
				<td>ABC</td>
			</tr>
			<tr class="table_content">
				<td>2</td>
				<td>가나다</td>
				<td>ABC</td>
			</tr>
			<tr class="table_content">
				<td>3</td>
				<td>가나다</td>
				<td>ABC</td>
			</tr>
		</table>
	</div>
	
	
	<br><br><br>
	
	
	<span id="boardtitle">클래스 문의 내용</span>
	<a href="#" id="viewmore">더보기 &raquo;</a>
	<br>
	
	<div>
		<table id="table" class="table">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Value</th>
			</tr>
			
			<tr class="table_content">
				<td>1</td>
				<td>가나다</td>
				<td>ABC</td>
			</tr>
			<tr class="table_content">
				<td>2</td>
				<td>가나다</td>
				<td>ABC</td>
			</tr>
			<tr class="table_content">
				<td>3</td>
				<td>가나다</td>
				<td>ABC</td>
			</tr>
		</table>
	</div>
	
</div>

</div> <!-- 전체를 감싸는 div -->




<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>