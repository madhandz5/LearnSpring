<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h1>MyPage</h1>
	<hr>
	<div class="myWrapper">
		<div class="myInfo">
			<div>아이디</div>
			<div>${logInInfo.m_id}</div>
		</div>

		<div class="myInfo">
			<div>비밀번호</div>
			<div>pw변경</div>
		</div>
		
		<div class="myInfo">
			<div>이메일</div>
			<div>${logInInfo.m_email}</div>
		</div>

		<div class="myInfo">
			<div>등급</div>
			<div>${logInInfo.m_grade}</div>
		</div>	
	</div>
</div>	

</body>

</html>