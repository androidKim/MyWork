<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<html>
<script type="text/javascript">
	function tempFunction() 
	{
	
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
	<form action="modPortProc" method="post">
		<input type="hidden" value="${pInfo.seq}" name = "seq"/>
		<input type="text" value="${pInfo.title}" name="title"/>
		<input type="text" value="${pInfo.content}" name="content"/>
		<input type="text" value="${pInfo.my_part}" name="my_part"/>
		<input type="submit" value="submic"/>
	</form>	
</body>
</html>
