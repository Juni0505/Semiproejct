<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Error Info : <%= exception.getClass().getName() %>
	<hr>
	오류페이지
	<a href="javascript:windwo.history.back();">이전페이지로 이동</a>
</body>
</html>