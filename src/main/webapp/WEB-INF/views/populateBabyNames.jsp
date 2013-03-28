<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Example :: Spring Application</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/scripts/style.css" />" media="all">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script
	src="http://jpillora.github.com/jquery.rest/dist/jquery.rest.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/static/scripts/custom.js" />"></script>
</head>
<body>
	<h1>Baby Names</h1>
	<div class="csstable" style="width:500px">
		<table id="tableName">
		<tr>
			<td width="20px">Rank</td>
			<td width="100px">Baby Name</td>
			<td width="100px">Total Count</td>
		</tr>
		<c:forEach items="${namesMap}" var="entry" varStatus="status">
			<tr>
				<td> ${status.count} </td>
				<td> ${entry.key} </td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	<p>
		<a href="<c:url value="/index" />" >Home</a>
	</p>
</body>
</html>