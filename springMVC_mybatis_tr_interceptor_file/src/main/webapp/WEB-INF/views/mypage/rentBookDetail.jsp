<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="/servletBM/resources/css/book.css" />
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<div class="Menu">
		<div class="MenuBox">
		
		</div>
</div>
<br><br>
<div class="bdWrapper">
	<div class="bookimg">
		<img src="/servletBM/resources/image/book/${data.book.b_isbn}.jpg"/>
		<div><a href="/servletBM/use/extendbook.do?rm_idx=${res.rm_idx}&rb_idx=${res.rb_idx}">연장하기</a></div>
		<div><a href="/servletBM/use/returnbook.do?rm_idx=${res.rm_idx}&rb_idx=${res.rb_idx}">반납하기</a></div>
	</div>
	<div class="bookinfo">
		<div class="myWrapper">
			<div class="myInfo">
				<div>ISBN코드</div>
				<div>${data.book.b_isbn}</div>
			</div>
			<div class="myInfo">
				<div>도서명</div>
				<div>${data.book.b_title}</div>
			</div>
			<div class="myInfo">
				<div>작가</div>
				<div>${data.book.b_author}</div>
			</div>
			<div class="myInfo">
				<div>대출횟수</div>
				<div>${data.book.b_rent_cnt}</div>
			</div>
			<div class="myInfo">
				<div>대출가능여부</div>
				<div>${data.book.b_rent_yn}</div>
			</div>
		</div>
	</div>
</div>
<footer class="bottom">
		bottom
</footer>



</body>
</html>