<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
	width: 300px;
}

h1 {
	text-align: center;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 3px;
	width: 100%;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="login-container">
		<h1>로그인</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<label for="member_Id">아이디:</label> <input type="text"
				name="member_Id" id="member_Id" required> <label
				for="member_Pwd">비밀번호:</label> <input type="password"
				name="member_Pwd" id="member_Pwd" required> <input
				type="submit" value="로그인">
		</form>
	</div>
</body>
</html>
