<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<div class="content">	
	<div class="Menu">
		<div class="MenuBox">
		
		</div>
	</div>
	<div class="notice">
	  <h2><span>*공지사항</span></h2>
	</div> 
	<form action="" onSubmit="return pwCheck()" method="POST">
 	<div class="notice-detail">
      <div class="notice-title">
          <h4 class="reset">${notice.noticeTitle}</h4>
      </div>
      <div class="info">
      	  <span name="noticeNo" value="${notice.noticeNo}">게시글번호 : ${notice.noticeNo}</span>
          <span>등록일 : ${notice.noticeDate}</span>
          <span>작성자 : ${notice.noticeWriter}</span>
      </div>
      <div class="text">
           ${notice.noticeContent}
   	  </div>
   	  <div class="section-button">
       	<button ><span>목록</span></button>
   	  </div>
   	  <div class="section-button">
       	<button ><span>삭제</span></button>
   	  </div>
   	  <!-- <div class="section-button">
       	<button ><span>수정</span></button>
   	  </div> -->
   	  <input type="hidden" name="pwVal" id="pwVal"/>
   </div>
   </form>
</div>

<script type="text/javascript">

function pwCheck(){
	var pass = prompt('password를 입력하세요.');
	
	if(pass != null){
		document.querySelector('#pwVal').value = pass;
		return true;
	}else{
		alert("password를 입력하세요");
		return false;
	}
}
</script>


</body>
</html>