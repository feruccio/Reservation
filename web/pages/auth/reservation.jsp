<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert definition=".main.auth">
	<tiles:put name="title"><bean:message key="reservation.msg.title.name"/></tiles:put>
	<tiles:put name="body" value="/pages/auth/reservation-body.jsp"></tiles:put>
</tiles:insert>