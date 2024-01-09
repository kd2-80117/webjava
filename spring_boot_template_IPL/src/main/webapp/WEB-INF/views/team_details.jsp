<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Players list</title>
</head>
<body>
<table style="background-color: lightgrey; margin: auto">
		<caption>List Of Players from Team ${param.teamId}</caption>
		<c:forEach var="t" items="${requestScope.player_list}">
			<tr>

				<td>${t.id}</td>
				<td>${t.firstName}</td>
				<td>${t.lastName}</td>
				<td>${t.battingAvg}</td>
				<td>${t.wicketsTaken}</td>
				<spring:url var="url" value="/delete?id=${t.id}" />
				<td><a href="${url}">Delete</a></td>
				<spring:url var="url" value="/update?id=${t.id}" />
				<td><a href="${url}">Update</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>