<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<html>
<script type="text/javascript">
	function goPortMain() 
	{
		window.location.href = "/portMain";
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
	<div id='cssmenu'>
		<ul>
		   <li class='active'><a href='#'>Me</a></li>
		   <li><a onclick="goPortMain();">Portfolio</a></li>
		   <li><a href='#'>My Skill</a></li>
		   <li><a href='#'>Contact</a></li>
		</ul>
	</div>
	
	<div>
	<p>Hello</p>
	</div>
</body>
</html>
