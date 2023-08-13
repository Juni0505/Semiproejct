<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">

</head>
<body>
<div class="container mt-5">
        <h1 class="text-center mb-4">회원가입</h1>
        <form action="${pageContext.request.contextPath}/join" method="post">
            <div class="mb-3">
                <label for="member_Id" class="form-label">아이디:</label>
                <input type="text" name="member_Id" id="member_Id" class="form-control" required>
                <button type="button" id="btncheck" class="btn btn-secondary mt-2">중복 확인</button>
            </div>
            
            <div class="mb-3">
                <label for="member_Pwd" class="form-label">비밀번호:</label>
                <input type="password" name="member_Pwd" id="member_Pwd" class="form-control" required>
            </div>
            
            <div class="mb-3">
                <label for="member_Name" class="form-label">이름:</label>
                <input type="text" name="member_Name" id="member_Name" class="form-control" required>
            </div>
            
            <div class="mb-3">
                <label for="member_Tel" class="form-label">전화번호:</label>
                <input type="tel" name="member_Tel" id="member_Tel" class="form-control" required>
            </div>
            
            <div class="mb-3">
                <label for="member_Email" class="form-label">이메일:</label>
                <input type="email" name="member_Email" id="member_Email" class="form-control" required>
            </div>
            
            <div class="mb-3">
                <label class="form-label">회원 유형:</label>
                <div class="form-check">
                    <input type="radio" name="member_Type" id="normal" value="0" class="form-check-input" checked>
                    <label for="normal" class="form-check-label">일반 회원</label>
                </div>
                <div class="form-check">
                    <input type="radio" name="member_Type" id="business" value="1" class="form-check-input">
                    <label for="business" class="form-check-label">비지니스 회원</label>
                </div>
            </div>
            
            <div id="businessFields" style="display: none;">
                <div class="mb-3">
                    <label for="bs_Number" class="form-label">사업자 등록번호:</label>
                    <input type="text" name="bs_Number" id="bs_Number" class="form-control">
                </div>
                
                <div class="mb-3">
                    <label for="bs_Manager" class="form-label">담당자 이름:</label>
                    <input type="text" name="bs_Manager" id="bs_Manager" class="form-control">
                </div>
            </div>
            
            <button type="submit" class="btn btn-primary">회원가입</button>
        </form>
    </div>

	<script>
		// 회원 유형 선택에 따라 사업자 정보 입력 필드를 보이거나 숨기도록 설정
		var normalRadio = document.getElementById('normal');
		var businessRadio = document.getElementById('business');
		var businessFields = document.getElementById('businessFields');
		normalRadio.addEventListener('change', function() {
			businessFields.style.display = 'none';
		});

		businessRadio.addEventListener('change', function() {
			businessFields.style.display = 'block';
		});

		$("#btncheck").click(checkId);
		function checkId() {
			var memberId = document.getElementById('member_Id').value;

			// AJAX 요청
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/join", // 아이디 중복 체크 서블릿 URL
				data : {
					memberId : $("[name=member_id]").val()
				},
				success : function(response) {
					if (response === "") {
						/* document.getElementById('checkResult').innerText = '중복된 아이디입니다.'; */
					} else {
						/* document.getElementById('checkResult').innerText = '사용 가능한 아이디입니다.'; */
					}
				},
				error : function() {
					/*                     document.getElementById('checkResult').innerText = '서버 오류로 인해 처리되지 않았습니다.';
					 */}
			});
		}
	</script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>
