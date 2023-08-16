<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 등록 페이지</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f8f8;
        margin: 0;
        padding: 0;
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

    label {
        display: block;
        margin-top: 10px;
    }

    input[type="text"],
    input[type="tel"],
    textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"], a {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        text-decoration: none;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
<script>
        function getLatLngFromAddress() {
            var address = document.getElementById("address").value;
            
            // 카카오 지도 API를 초기화합니다.
            kakao.maps.load(() => {
                new kakao.maps.services.Geocoder().addressSearch(address, function(result, status) {
                    if (status === kakao.maps.services.Status.OK) {
                        var lat = result[0].y; // 위도
                        var lng = result[0].x; // 경도
                        
                        // 위도와 경도 값을 출력합니다.
                        document.getElementById("lat").value = lat;
                        document.getElementById("lng").value = lng;
                    } else {
                        alert("주소를 찾을 수 없습니다.");
                    }
                });
            });
        }
    </script>
    <script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aec5b89790015b44669217946b7e53f3"></script>
</head>
<body>
<div class="container">
        <h2>가게 등록</h2>
        <form action="<%=request.getContextPath()%>/board/insert" method="post">
            <label for="bsNumber">사업자 등록번호:</label>
            <input type="text" name="bsNumber" required><br>
            
            <label for="btitle">제목:</label>
            <input type="text" name="btitle" required><br>
            
            <label for="bcontent">내용:</label>
            <textarea name="bcontent" rows="5" required></textarea><br>
            
            <label for="bwriter">작성자:</label>
            <input type="text" name="bwriter" required><br>
            
            <label for="baddress">주소:</label>
            <input type="text" name="baddress" required><br>
            
            <label for="btel">전화번호:</label>
            <input type="tel" name="btel" required><br>
            
            <label for="bshopName">가게 이름:</label>
            <input type="text" name="bshopName" required><br>
            
            <label for="lat">위도:</label>
            <input type="text" name="lat" required><br>
            
            <label for="lng">경도:</label>
            <input type="text" name="lng" required><br>
            
            <input type="submit" value="등록">
            <a href="${pageContext.request.contextPath}/main">취소</a>
        </form>
    </div>
</body>
</html>