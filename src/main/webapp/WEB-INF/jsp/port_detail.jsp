<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<html>
<script type="text/javascript">
	function goSetPortPage() 
	{
		window.location.href = "/setPortPage";
	}
	
</script>
<head>
	<meta charset='utf-8'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style><%@include file="/WEB-INF/css/styles.css"%></style>
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script src="script.js"></script>
	<title>MyWork</title>
</head>

<body>
	<div>
		<p>${pInfo.port_type}</p>
		<p>${pInfo.title}</p>
		<p>${pInfo.content}</p>
		<p>${pInfo.my_part}</p>
		<p>${pInfo.img}</p>
		<p>${pInfo.work_date}</p>
	</div>
	
	<a href="/modPortPage?seq=${pInfo.seq}">수정하기</a>
	<a href="/deletePortProc?seq=${pInfo.seq}">삭제하기</a>
</body>
</html>
