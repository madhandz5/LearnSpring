<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 양식</title>
</head>
<body>
	<!-- 진행하기 전에 꼭! member 테이블 m_leaveYN 넣기 -->
	<h1>회원 가입 양식</h1>
	<!-- <form action="/jsp1/empJoin.do"
	      method="post"> -->
	<form  action="<%=request.getContextPath()%>/member/joinemailCheck.do" 
		 <%-- action="<%=request.getContextPath()%>/member/joinimple.do" --%>
		method="post" onsubmit="return validate();">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="userId" id="userId" size="10" />
					<button type="button" onclick="idCheck()">아이디 확인하기</button>
					<br> <span id="idCheckMsg"></span></td>
			</tr>
			<tr>
				<td>PassWd :</td>
				<td><input type="password" name="userPwd" id="userPwd"
					size="10" /></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" name="m_email" size="10" /></td>
			</tr>
			<tr>
				<td>휴대폰번호 :</td>
				<td><input type="text" name="m_tell" size="10" /></td>
			</tr>
		</table>
		<br>
		<button type="onsubmit">전송하기</button>
	</form>

	<script src="https://code.jquery.com/jquery-3.4.1.js"
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		crossorigin="anonymous"></script>

	<script type="text/javascript">
	
	var ajaxFlag = false;
	
	function validate() {
		
        var pass = document.getElementById('userPwd');
        var regExpPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

        function chk(re, e, msg) {
            if(re.test(e.value)) {           		
                return true;          
	    }else{
           	  alert(msg);
              e.value = "";
              e.focus();
              //기본 이벤트 취소
              return false;
            }
     	}
        
        if(!ajaxFlag){
        	alert("아이디 중복검사를 해주세요");
        	return false;
        }
        
        // 비밀번호 검사
      	// 암호는 영문자와 숫자로 8글자이상  기호문자 한개이상 8글자 이상
        if(!chk(regExpPw, pass,'비밀번호 숫자,영어,특수문자가 하나 이상 포함, 8글자 이상 50글자 이하')){
        	return false;
        }

        return true;
    }
	
	function idCheck(){
		
		//jackson 라이브러리 테스트를 위한 코드
		//var jacksonTest = {m_id:$('#userId').val()};
		
		$.ajax(
			{
				url:'<%=request.getContextPath()%>/member/idcheck.do',
						type : 'get',
						data : $('#userId').serialize(),
						success : function(data) {
							console.dir(data);
							if (data != '') {
								document.querySelector('#idCheckMsg').textContent = data
										+ '는 이미 존재하는 아이디 입니다.';
							} else {
								document.querySelector('#idCheckMsg').textContent = '';
								document.querySelector('#idCheckMsg').textContent = '사용 가능한 아이디 입니다.';
								ajaxFlag = true;
								console.dir(ajaxFlag);
							}
						}
					})
		}
	</script>



</body>
</html>







