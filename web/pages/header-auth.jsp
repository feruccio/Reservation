<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html>
	<div>
		Welcome, <bean:write name="user" property="login"/>!
		<a href="<c:url value="/auth/logout.do"/>">Logout</a>
	</div>
</html>