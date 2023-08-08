<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
    <h1>회원가입</h1>
    
    <form action="${pageContext.request.contextPath}/join" method="post">
        <label for="member_Id">아이디:</label>
        <input type="text" name="member_Id" id="member_Id" required>
        <button type="button" id="btncheck">중복 확인</button>
        <!-- <div id="checkResult"></div><br> -->
        
        <label for="member_Pwd">비밀번호:</label>
        <input type="password" name="member_Pwd" id="member_Pwd" required><br>
        
        <label for="member_Name">이름:</label>
        <input type="text" name="member_Name" id="member_Name" required><br>
        
        <label for="member_Tel">전화번호:</label>
        <input type="tel" name="member_Tel" id="member_Tel" required><br>
        
        <label for="member_Email">이메일:</label>
        <input type="email" name="member_Email" id="member_Email" required><br>
        
        <!-- 회원 유형 선택 라디오 버튼 -->
        <label>회원 유형:</label>
        <input type="radio" name="member_Type" id="normal" value="0" checked>
        <label for="normal">일반 회원</label>
        <input type="radio" name="member_Type" id="business" value="1">
        <label for="business">비지니스 회원</label><br>
        
        <!-- 사업자 정보 입력 필드 -->
        <div id="businessFields" style="display: none;">
            <label for="bs_Number">사업자 등록번호:</label>
            <input type="text" name="bs_Number" id="bs_Number"><br>
            
            <label for="bs_Manager">담당자 이름:</label>
            <input type="text" name="bs_Manager" id="bs_Manager"><br>
        </div>
        
        <input type="submit" value="회원가입">
    </form>
    
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
                type: "POST",
                url: "${pageContext.request.contextPath}/join", // 아이디 중복 체크 서블릿 URL
                data: {
                	$("[name=member_id]").val()                    
                },
                success: function(response) {
                    if (response === "") {
                        /* document.getElementById('checkResult').innerText = '중복된 아이디입니다.'; */
                    } else {
                        /* document.getElementById('checkResult').innerText = '사용 가능한 아이디입니다.'; */
                    }
                },
                error: function() {
/*                     document.getElementById('checkResult').innerText = '서버 오류로 인해 처리되지 않았습니다.';
 */                }
            });
        }
    
    </script>
</body>
</html>
