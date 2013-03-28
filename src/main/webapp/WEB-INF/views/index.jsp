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
	<form:form method="post" action="populateBabyNames" id="frmPopulateBabyNames" commandName="babyNames">
	<div class="csstable" style="width:500px">
		<table>
			<tr>
				<td colspan="2">Enter your details</td>
			</tr>
			<tr>
				<td><form:label path="startYear" >Start Year</form:label></td>
				<td><form:input path="startYear" maxlength="4" size="5"/></td>
			</tr>
			<tr>
				<td><form:label path="endYear">End Year</form:label></td>
				<td><form:input path="endYear" maxlength="4" size="5" /></td>
			</tr>
			<tr>
				<td><form:label path="top">Top Results</form:label></td>
				<td>
					<form:select name="top" size="1" id="rank" path="top">
					  <form:option value="20">Top 20</form:option>
					  <form:option value="50">Top 50</form:option>
					  <form:option value="100">Top 100</form:option>
					  <form:option value="500">Top 500</form:option>
					  <form:option value="1000">Top 1000</form:option>
					</form:select>
				
				</td>
				
				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" id="btnGetNames" value="Get Names" /></td>
			</tr>
		</table>
</div>
	</form:form>
</body>
</html>