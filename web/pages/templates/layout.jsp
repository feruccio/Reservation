<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/style/css/reservation.css"/>">
		<title>
			<tiles:getAsString name="title"/>
		</title>
	</head>
	<body>
		<div class="main">
			<div class="header">
				<tiles:insert attribute="header"/>
			</div>
			<div class="content">
				<tiles:insert attribute="body"/>
			</div>
	</div>
	<div class="footer">
  		<tiles:insert attribute="footer"/>
	</div>
	</body>
</html>