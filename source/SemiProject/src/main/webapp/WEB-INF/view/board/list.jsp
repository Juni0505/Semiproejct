<%@page import="java.util.List"%>
<%@page import="kh.semiproject.board.model.vo.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESTAURANTS</title>
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
    
    .nav {
        list-style: none;
        padding: 0;
    }
    
    .nav li {
        display: inline;
        margin-right: 10px;
    }
    
    .nav a {
        color: #fff;
        text-decoration: none;
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
    
    .board-table {
        width: 100%;
        border-collapse: collapse;
    }
    
    .board-table th, .board-table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
    }
    
    .footer {
        background-color: #333;
        color: #fff;
        text-align: center;
        padding: 10px 0;
        position: fixed;
        bottom: 0;
        width: 100%;
    }
</style>
</head>
<body>
    <div class="header">
        <h1><a href="<%=request.getContextPath()%>/main">KH RESTAURANTS</a></h1>
    </div>
    
    <div class="container">
        <h2>KH RESTAURANTS</h2>
        <table class="board-table">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
            <%
            List<BoardDto> voList = (List<BoardDto>) request.getAttribute("dto");
            for (int i = 0; i < voList.size(); i++) {
                BoardDto vo = voList.get(i);
                %>
                <tr>
                    <td><%=vo.getBno() %></td>
                    <td><a href="<%=request.getContextPath()%>/board/view?btitle=<%=vo.getBtitle() %>"><%=vo.getBtitle() %></a></td>
                    <td><%=vo.getBwriter() %></td>
                    <td><%=vo.getBwriteDate() %></td>
                </tr>
            <% } %>
        </table>
    </div>
    
    <div class="footer">
        <p>© 2023 KH RESTAURANTS. All rights reserved.</p>
    </div>
</body>
</html>
