<%@ page language="java" contentType = "text/html; charset =ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title}</title>
	<link rel="stylesheet" href="/resources/css/test.css" type="text/css">
	<link rel="stylesheet" href="/resources/css/app.css" type="text/css">
</head>
<body>
	<div id="app">
        <c:forEach var = "item" items = "${categories}">
                    <tr>
                        <td><c:out value = "${item.name}"/></td>
                        <td><c:out value = "${item.imageUrl}"/></td>
                        <td><c:out value = "${item.description}"/></td>
                    </tr>
                 </c:forEach>
	</div>
	<script src="/resources/js/app.js"></script>
</body>
</html>