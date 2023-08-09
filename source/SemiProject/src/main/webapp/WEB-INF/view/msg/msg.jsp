<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<script>
	var alertMsg = '${msg}';	//꼭 매우 중요 !
	if(alertMsg){	// js 에서는 '' 상태를 false로 인식함.
		alert(alertMsg);
	}
</script>