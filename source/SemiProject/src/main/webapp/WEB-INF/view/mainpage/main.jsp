<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>KH 맛집</title>
 <title>KH 맛집</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
    crossorigin="anonymous">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/apikey.js"></script>
<script>
    const WEATHER_API = config.apikey;
    console.log(WEATHER_API);
</script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .header {
        text-align: center;
        padding: 20px;
        background-color: #5a9e5f;
        color: white;
    }
    .menu {
        text-align: center;
        margin: 10px 0;
    }
    .menu a {
        margin: 0 10px;
        text-decoration: none;
        color: #5a9e5f;
        font-weight: bold;
    }
    .map-container {
        width: 100%;
        height: 600px;
    }
    .footer {
        text-align: center;
        margin-top: 2px;
        font-size: 0.6rem;
        background-color: #f4f4f4;
        padding: 10px;
    }
</style>
</head>
<body>
<div style = "text-align:center; margin-bottom:2px;">
    <div class="header">
        <h1 style="font-family: 'Lobster', cursive"><a href="<%=request.getContextPath()%>/main" style="color: white; text-decoration: none;">View KH
                restaurants</a></h1>
    </div>
    <div class="menu">
        <a href="<%=request.getContextPath()%>/join">회원가입</a>
        <c:if test="${not empty mid }">
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="btn btn-light">로그아웃</button>
            </form>
        </c:if>
        <c:if test="${empty mid }">
            <a href="<%=request.getContextPath()%>/login">로그인</a>
        </c:if>
        <a href="<%=request.getContextPath()%>/board" class="btn btn-success">가게등록</a>
    </div>
</div>
	<h1>지도 표시하기</h1>
	<div id="map" style="width: 100%; height: 600px;"></div>
	
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=apikey"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(37.498505, 127.032540),
			level : 3
		};
	
	/* console.log("${markerList}"); */
/* 	var makerList = "${makerList1}";
 */	var makerListArr = JSON.parse('${markerList1}');
	/* console.log(makerListArr); */
	var markerArr = [];
	for(var i = 0; i < makerListArr.length;i++) {
		var vo = makerListArr[i];
		var markerObj= {
				content : '<div>'+vo.bshop_Name+'</div>',
				latlng : new kakao.maps.LatLng(Number(vo.lat), Number(vo.lng)) 
		};
		markerArr.push(markerObj);
	}
	/* console.log(markerArr); */
		var map = new kakao.maps.Map(container, options);
		var first_positions = markerArr;
			
		// 첫번째 마커 생성

		for (var i = 0; i < first_positions.length; i++) {
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : first_positions[i].latlng
			// 마커의 위치// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			});

			// 마커에 표시할 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
				content : first_positions[i].content, // 인포윈도우에 표시할 내용
				removable : true
			});
			kakao.maps.event.addListener(marker, 'click', marker_click(map,
					marker, infowindow));
		}
		
		function marker_click(map, marker, infowindow) {
			return function() {
				infowindow.open(map, marker);
			};
		}
		
/* 
		var content = '<div class="wrap">' +
			'<div class="info">' +
					'<div class="title">' +
							'서울역' +
							'<div class="close" one click="closeOverlay()" title="닫기"> </div>'
							'<div>' +
							'<div class="body">' +
							'<div class = "img">' +
							'<img src="https://cfile181.uf.daum.net/image/250649365602043421963D" width="73" height="70">' +
							'</div>' +
							'<div class="desc">' +
							'<div class ="ellipsis">서울특별시 용산구 동자동 43-205</div>' +
							 */
 							
		
		
		
		// 마커가 표시될 위치입니다 
		/* var markerPosition  = new kakao.maps.LatLng(37.498505, 127.032540); 
		var markerPosition2  = new kakao.maps.LatLng(37.500759, 127.034269); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});

		var iwContent = '<div style="padding:5px;">KH 맛집!<br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', 
		// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다
		
		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		position : iwPosition, 
		content : iwContent 
		});
		
		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker); 
		
		
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map); */

		// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
		// marker.setMap(null);
	</script>
	<div class="footer">
        <span>공지사항</span> |
        <span>문의사항</span> |
        <span>서비스소개</span>
        <div style="margin-top: 1rem;">
            <h6 style="font-family: 'Lobster', cursive; color: #5a9e5f;">KHView KH restaurants</h6>
        </div>

</div>
</body>
</html>