<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/book.css" />
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<form action="<%= request.getContextPath() %>/book/innersearch.do" method="post">
	<div class="Menu">
		<div class="MenuBox">
			
				<span>검색 결과 내 검색 : </span><input type="text" name="title"/><br>
				<span>인기순 정렬 : </span><input type="radio" name="orderBy" value="B_RENT_CNT"/>
				<span>최근 도서 순 정렬 : </span><input type="radio" name="orderBy" value="B_REGDATE"/><br>
				<button>검색</button>
			
		</div>
	</div>
<br>
<br>	
<center><h1>도서검색결과</h1></center>
<hr>
	<section class=recentBook>
		<div class="recentBookWrapper">
		<div class="recentBookBox">
			<div class="recentBookLine">
			<!-- <li>번호: ${status.index}, 순번: ${status.count}, 책 이름 : ${bookTitle}</li> -->
			<c:forEach items="${booklist}" var="b" varStatus="status">
				<input type="hidden" value="${b.b_bno}" name="bnoList"/>
				<c:if test="${status.count%4 != 0 }">
				<div class="productItem">
					<div>
						<img src="<%= request.getContextPath() %>/resources/image/book/${b.b_isbn}.jpg">
					</div>
					<div class="bookTitle">${b.b_title}<br>작가:${b.b_author}</div>
					<div class="bookUse" id="bookUse">
						<div><a href="<%= request.getContextPath() %>/book/detail.do?b_bno=${b.b_bno}">상세보기</a></div>
					</div>
				</div>
				</c:if>
				<c:if test="${status.count%4 == 0 }">
				<div class="productItem">
					<div>
						<img src="<%= request.getContextPath() %>/resources/image/book/${b.b_isbn}.jpg">
					</div>
					<div class="bookTitle">${b.b_title}<br>작가:${b.b_author}</div>
					<div class="bookUse" id="bookUse">
						<div><a href="<%= request.getContextPath() %>/book/detail.do?b_bno=${b.b_bno}">상세보기</a></div>
					</div>
				</div>
				</div>
				<div class="recentBookLine">
				</c:if>
			</c:forEach>
			</div>
		</div>
		</div>
	</section>
	<footer class="bottom">
		bottom
	 </footer>
</form>
	 
<script>
	document.querySelectorAll('.productItem').forEach(function(v){
		v.addEventListener('mouseover',function(){
			v.lastElementChild.style.display = 'block';
		})
		
		v.addEventListener('mouseout',function(){
			v.lastElementChild.style.display = 'none';
		})
	})
</script>

</body>
</html>