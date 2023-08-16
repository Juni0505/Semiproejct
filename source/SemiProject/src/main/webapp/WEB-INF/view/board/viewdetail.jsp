<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 상세보기</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f8f8;
        margin: 0;
        padding: 0;
    }
    
    .header {
        background-color: #333;
        color: #fff;
        text-align: center;
        padding: 10px 0;
    }
    
    .header h1 {
        margin: 0;
        font-size: 24px;
    }
    
    .container {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
        margin: 0 0 20px;
        font-size: 28px;
    }
    
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    
    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }
    
    .btn-back {
        display: inline-block;
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        text-decoration: none;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div class="header">
        <h1>가게 상세보기</h1>
    </div>
    
    <div class="container">
        <h2>가게 상세정보</h2>
        <table>
            <tr>
                <th>글번호</th>
                <td>${dto.bno}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${dto.btitle}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${dto.bcontent}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>${dto.bwriteDate}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${dto.bwriter}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${dto.baddress}</td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>${dto.btel}</td>
            </tr>
            <tr>
                <th>가게 이름</th>
                <td>${dto.bshopName}</td>
            </tr>
        </table>
        
        <a class="btn-back" href="<%=request.getContextPath()%>/main">메인으로 돌아가기</a>
    </div>
</body>
</html>
