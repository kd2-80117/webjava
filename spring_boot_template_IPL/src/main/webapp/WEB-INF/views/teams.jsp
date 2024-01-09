<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teams</title>
</head>
<body>
<h1>Team List</h1>
<form method="post" action="team_details">

<c:forEach var="t" items="${requestScope.team_detail}">
<input type="radio" name="team_id" value="${t.id}" /> ${t.name}
</c:forEach>
<input type="submit" value="Show Team Details" />
</form>


</body>
</html>