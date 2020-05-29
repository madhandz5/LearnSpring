<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="/servletBM/resources/css/mypage.css" />
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/myFloatDiv.jsp" %>
<div class="content">
	<div class="Menu">
		<div class="MenuBox">

		</div>
	</div>
	<br>
	<h1>최근 대출 목록</h1>
	<hr>
	<div class="search-box">
  	   <table class="noticelist">
       <caption></caption>
       <thead>
           <tr>
               <th style="width: 10%; height:20%;"><span>대출번호</span></th>
               <th style="width: 50%;"><span>대출건 제목</span></th>
               <th style="width: 10%;"><span>대출일</span></th>
               <th style="width: 10%;"><span>반납여부</span></th>
                <th style="width: 10%;"><span>연장하기</span></th>
               <th style="width: 10%;"><span>반납하기</span></th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${data.rentList}" var="res">
           <tr>
               <td class="num">
                   <strong class="warning">${res.rm_idx }</strong>
               </td>
               <td class="subject">
               <a href="/servletBM/use/rentbookdetail.do?b_bno=${res.b_bno}&rb_idx=${res.rb_idx}">
               	${res.rm_title }</a></td>
               <td class="date">${res.rm_regdate}</td>
               <td class="date">${res.rm_return_yn}</td>
               <td class="date">
               <a href="/servletBM/use/extendbook.do?rm_idx=${res.rm_idx}&rb_idx=${res.rb_idx}">연장하기</a>
               </td>
               <td class="date">
               <a href="/servletBM/use/returnbook.do?rm_idx=${res.rm_idx}&rb_idx=${res.rb_idx}">반납하기</a>
               </td>
           </tr>
        </c:forEach>
       </tbody>
       </table>
       <div class="paging"><!-- section pagination -->
                    <a href="/servletBM/mypage/mypage.do?cPage=${data.paging.blockStart+1}" class="nav first"><i class="fas fa-angle-double-left"></i></a>
                  	<c:choose>
		        	<c:when test="${data.paging.blockStart > 1 }">
		         		<a href="/servletBM/mypage/mypage.do?cPage=${data.paging.blockStart-1}" class="nav prev"><i class="fas fa-angle-left"></i></a>
		        	</c:when>
		        	<c:otherwise>
		        		<a href="/servletBM/mypage/mypage.do?cPage=${data.paging.blockStart}" class="nav prev"><i class="fas fa-angle-left"></i></a>
		        	</c:otherwise>
		        	</c:choose>
                  
                    <c:forEach begin="${data.paging.blockStart}" end="${data.paging.blockEnd}" var="page">
                    	<a href="/servletBM/mypage/mypage.do?cPage=${page}" class="num active"><span>${page}</span></a>
                    </c:forEach>

                    <c:choose>
		        	<c:when test="${data.paging.blockEnd > data.paging.lastPage }">
        				<a href="/servletBM/mypage/mypage.do?cPage=${data.paging.lastPage}" class="nav last"><i class="fas fa-angle-double-right"></i></a>
		        	</c:when>
		        	<c:otherwise>
			            <a href="/servletBM/mypage/mypage.do?cPage=${data.paging.blockEnd+1}" class="nav next"><i class="fas fa-angle-right"></i></a>
		        	</c:otherwise>
		        	</c:choose>
    </div><!-- // section pagination -->
</div>
</div>
</body>
</html>