<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header class="topWrapper">
 		<div class="top">
			<div class="topLogo"><a href="<%= request.getContextPath() %>/index/index.do"><b>UCLASS <br>HTML</b></a></div>
				<div class="topSearchBar"> 
				<input Type ="text" placeholder="검색어를 입력하세요">
				<button value="" class=""><i class="fas fa-search" style="color:black"></i></button>
			</div>
			<c:if test="${logInInfo == null}">
			<div class="topLogin">
				<a href="<%=request.getContextPath()%>/member/login.do">로그인/</a>
				<a href="<%=request.getContextPath()%>/member/join.do">회원가입</a>
			</div>
			</c:if>
			<c:if test="${logInInfo != null}">
			<div class="topLogOut">
				<a href="<%=request.getContextPath()%>/mypage/mypage.do">${sessionScope.logInInfo.m_id}님 환영합니다. MyPage</a>
				<a href="<%=request.getContextPath()%>/member/logout.do">logOut</a>
			</div>
			</c:if>
 		</div>
	</header>