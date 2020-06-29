<!-- 20200628 이인주 -->
<!-- 메인 메뉴바 - 후기게시판 - 클래스 이름 검색(사진)-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
<!-- 메인 - header -->
<c:import url="/WEB-INF/layout/common/main/header.jsp"></c:import>

<style type="text/css">
#body{
	width: 1200px;
	height: 100%;
	margin: 0;
	padding: 0;
}

#cho{
	width: 900px;
	margin: 0 auto;
	text-align: right;
	float: right;
}

#serchbox{
	width: 250px;
	margin: 0 auto;
	text-align: left;
	float: left;
}

.anone{
text-decoration: none;
color: black;
}

.anone:hover{
text-decoration: none;
color: black;
}

.imgst{
width: 300px;
height: 400px;
}

.boxstyle{width: 300px;}

#minilist{
list-style: none;
 font-weight: bold;
 white-space:nowrap;
 width:900px;
}

#minilist > li{
	float:left;
	color:gray;
}

#photoreview{
/* 	border: 1px solid gold;  */
 	height:400px ; 
	float: left; 
	width: 30%; 
	padding:10px;"
}

.contentwrap {
word-wrap: break-word;
}
</style>

<div class="container">
<div id="body" >
<br>
<div style="text-align: center;">
<a href="/review/board" class="anone"><h3 style="color: thistle; font-weight: bold; ">&nbsp;후기게시판</h3></a>
<small>${classname }클래스를 수강한 오디분들이 작성해주신 포토 후기 게시판입니다.</small>
</div>
<hr>

<!--  클래스 이름 검색 -->
<div id="serchbox" >
<form action="/review/board/search/pho" method="post">

<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="클래스 이름 검색" style="width: 180px; " name="classname">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Search</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->

</form>
</div>

<div id="cho">
<ul id="minilist">
	<li><a href="/review/board/search/pho?classname=${classname }" class="aNone">&nbsp;${classname }포토후기 모아보기&nbsp;|</a></li>
	<li><a href="/review/board/search/content?classname=${classname }" class="aNone">&nbsp;${classname } 글 후기 모아보기&nbsp;|</a></li>
	<li><a href="/review/board" class="aNone">&nbsp;전체 포토후기 모아보기&nbsp;|</a></li>
	<li><a href="/review/board/content" class="aNone">&nbsp;전체 글 후기 모아보기</a></li>
</ul>
</div>


<!-- float 막는 clear -->
<div class="clearfix"></div>
<br>


<!-- 후기가 없을 때  -->
<c:if  var="searchpho" test="${empty searchreviewboardpho }">
<div style="height: 350px;">
<h4 style="color: thistle; font-weight: bold; text-align: center;">후기가 없습니다</h4>
</div>
</c:if>

 <!-- 사진이 있는 경우 -->
<!--후기가 있을 때 -->
<c:if  var="searchpho" test="${!empty searchreviewboardpho }">
<!-- 값 출력 -->
<c:forEach items="${searchreviewboardpho }" var="searchpho" >

<div id="photoreview">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail boxstyle"> 
     <img src="/upload/${searchpho.reviewrename }" alt="포토후기 사진" class="imgst">
      <div class="caption">
        <h4 class="contentwrap">${searchpho.reviewtitle }</h4>
        <h5 >${searchpho.satlevel }</h5>
        <small>${searchpho.usernick }</small>&nbsp;<small>${searchpho.usergrade }</small>&nbsp;<small>${searchpho.reviewdate }</small>
        <p class="contentwrap">${searchpho.reviewcontent }</p>
        <hr>
        <small>[${searchpho.artnick }]</small>&nbsp;<small class="contentwrap">${searchpho.classname }</small>
        
      </div>
      
    </div>
  </div>
</div>

</c:forEach>
</c:if>

				



</div>
</div>

<!-- float 막는 clear -->
<div class="clearfix"></div>
<!-- 페이징 -->
<c:import url="/WEB-INF/paging/reviewboardsearchphoto.jsp"></c:import>
<br>

<!-- 메인 - footer -->
<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>