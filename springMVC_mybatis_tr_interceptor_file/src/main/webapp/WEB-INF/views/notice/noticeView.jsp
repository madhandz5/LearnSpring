<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="content">
		<div class="Menu">
			<div class="MenuBox"></div>
		</div>
		<div class="notice">
			<h2>
				<span>*공지사항</span>
			</h2>
		</div>
		<form id="noticeForm" action="" method="POST">
			<div class="notice-detail">
				<div class="notice-title">
					<h4 class="reset">${data.notice.noticeTitle}</h4>
				</div>
				<div class="info">
					<input type="hidden" name="noticeNo" value="${data.notice.noticeNo }">
					<span>게시글번호
						: ${data.notice.noticeNo}</span> <span>등록일 :
						${data.notice.noticeDate}</span> <span>작성자 :
						${data.notice.noticeWriter}</span>
				</div>
				첨부파일 :
				<c:forEach items="${data.flist}" var="filename">
					<a
						href="<%= request.getContextPath() %>/resources/upload/${filename.renameFileName}">
						${filename.originFileName} </a>&nbsp;&nbsp;
      </c:forEach>
				<div class="text">${notice.noticeContent}</div>

				<div class="section-button">
					<button>
						<span>목록</span>
					</button>
				</div>
				<c:if test="${logInInfo.m_id eq data.notice.noticeWriter }">
					<div class="section-button">
						<button id="delete" onclick="selectSubmit(this)">
							<span>삭제</span>
						</button>
					</div>&nbsp;
					<div class="section-button">
						<button id="modify" onclick="selectSubmit(this)">
							<span>수정</span>
						</button>
					</div>
				</c:if>

				<input type="hidden" name="pwVal" id="pwVal" />
			</div>
		</form>
	</div>

</body>

<script>
	function selectSubmit(e) {
		var contextPath = '<%=request.getContextPath() %>/';
		
		if(e.id == "delete"){
			document.querySelector("#noticeForm").action = contextPath + "notice/noticedelete.do";
		}else if(e.id =="modify"){
			document.querySelector("#noticeForm").action = contextPath + "notice/noticemodify.do";
		}
	}
</script>
</html>