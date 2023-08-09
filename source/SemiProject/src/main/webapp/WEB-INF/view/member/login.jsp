<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
</head>
<body>
    <h1>로그인</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="member_Id">아이디:</label>
        <input type="text" name="member_Id" id="member_Id" required><br>
        
        <label for="member_Pwd">비밀번호:</label>
        <input type="password" name="member_Pwd" id="member_Pwd" required><br>
        
        <input type="submit" value="로그인">
    </form>
    
</body>
</html>
