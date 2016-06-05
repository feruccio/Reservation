<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

	<div class="container-fluid">
		<div class="dropdown loacale-swith">
			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
				<bean:message key="header.msg.menu.language"/>
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="<c:url value="/changeLocale.do?language=en"/>">English</a></li>
				<li><a href="<c:url value="/changeLocale.do?language=ru"/>">Russian</a></li>
			</ul>
		</div>
	</div>