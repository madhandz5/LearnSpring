<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<div class="Menu">
	<div class="MenuBox">
	
	</div>
</div>
<div class="notice">
	  <h2><span>*게시판</span></h2>
      
	</div> 
	<div class="search-box">
  	   <table class="noticelist">
       <caption></caption>
       <thead>
           <tr>
               <th style="width: 10%; height:20%;"><span>번호</span></th>
               <th style="width: 80%;"><span>제목</span></th>
               <th style="width: 10%;"><span>등록일</span></th>
           </tr>
       </thead>
       <tbody>
       	<c:forEach items="${mnlist}" var="notice">
           <tr>
               <td class="num">${notice.noticeNo}</td>
               <td class="subject"><a href="/<%= request.getContextPath() %>/notice/noticedetail.do?noticeNo=${notice.noticeNo}">${notice.noticeTitle}</a></td>
               <td class="date">${notice.noticeDate}</td>
           </tr>
        </c:forEach>
       </tbody>
       </table>
       <div class="paging"><!-- section pagination -->
         <a href="<%= request.getContextPath() %>/notice/noticelist.do" class="nav first"><i class="fas fa-angle-double-left"></i></a>
        <c:choose>
        	<c:when test="${paging.blockStart > 1 }">
         		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockStart-1}" class="nav prev"><i class="fas fa-angle-left"></i></a>
        	</c:when>
        	<c:otherwise>
        		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockStart}" class="nav prev"><i class="fas fa-angle-left"></i></a>
        	</c:otherwise>
        </c:choose>
        <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
         <a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${page}" class="num active"><span>${page}</span></a>
        </c:forEach> 
        
        <c:choose>
        	<c:when test="${paging.blockEnd+1 > paging.lastPage }">
         		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockEnd}" class="nav next"><i class="fas fa-angle-right"></i></a>
        	</c:when>
        	<c:otherwise>
         		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockEnd+1}" class="nav next"><i class="fas fa-angle-right"></i></a>
        	</c:otherwise>
   	   	</c:choose>
 	   	 
 	   	 <a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.lastPage}" class="nav last"><i class="fas fa-angle-double-right"></i></a>
   	   </div><!-- // section pagination -->
   	   <div class="section-button">
       		<a href="<%= request.getContextPath() %>/notice/noticewrite.do">공지 쓰기</a>
       </div>
     </div>
	
</div>
</body>
</html>