<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<div class="navbar navbar-default">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li>
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
			</li>
			<li>
				<a href="<c:url value="/pages/auth/reservation.jsp"/>">
					<bean:message key="header.msg.menu.reservation"/>
				</a>
			</li>
			<li>
				<a href="<c:url value="/pages/auth/customer.jsp"/>">
					<bean:message key="header.msg.menu.customer"/>
				</a>
			</li>
			<li>
				<a href="<c:url value="/pages/auth/fareFamily.jsp"/>">
					<bean:message key="header.msg.menu.fareFamily"/>
				</a>
			</li>
			<li>
				<a href="<c:url value="/auth/logout.do"/>">
					<bean:message key="header.msg.menu.logout"/>
				</a>
			</li>
		</ul>
	</div>
</div>