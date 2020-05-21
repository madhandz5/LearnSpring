<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/book.css" />
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
		<img src="<%= request.getContextPath() %>/resources/image/book/${book.b_isbn}.jpg"/>
	</div>
	<div class="bookinfo">
		<div class="myWrapper">
			<div class="myInfo">
				<div>ISBN코드</div>
				<div>${book.b_isbn}</div>
			</div>
			<div class="myInfo">
				<div>도서명</div>
				<div>${book.b_title}</div>
			</div>
			<div class="myInfo">
				<div>작가</div>
				<div>${book.b_author}</div>
			</div>
			<div class="myInfo">
				<div>대출횟수</div>
				<div>${book.b_rent_cnt}</div>
			</div>
			<div class="myInfo">
				<div>대출여부</div>
				<div>${book.b_rent_yn}</div>
			</div>
		</div>
	</div>
</div>
<footer class="bottom">
		bottom
</footer>



</body>
</html>