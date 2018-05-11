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
	<div id='cssmenu'>
		<ul>
		   <li><a href='/meMain'>Me</a></li>
		   <li class='active'><a href='/portMain'>Portfolio</a></li>
		   <li><a href='#'>My Skill</a></li>
		   <li><a href='#'>Contact</a></li>
		</ul>
	</div>

	<div>
		<p onclick="goSetPortPage();">등록하기</p>
	</div>
	<div>
		<table>	
				<tr>
					<th></th>
				</tr>
			<c:forEach items="${pArray}" var="pArray">
				<tr>
					<td>${pArray.port_type}</td>
					<td>${pArray.title}</td>
					<td>${pArray.content}</td>
					<td>${pArray.my_part}</td>
					<td>${pArray.img}</td>
					<td>${pArray.work_date}</td>
					<td><a href="/portDetail?seq=${pArray.seq}">goDetial</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
