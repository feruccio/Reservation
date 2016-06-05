<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="<c:url value="/style/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="<c:url value="/style/css/reservation.css"/>">
		<script type="text/javascript" src="<c:url value="/style/js/jquery.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/style/js/bootstrap.min.js"/>"></script>
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