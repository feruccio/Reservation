<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html:form action="login.do" method="post">
	<div>
		<label for="loginInp"><bean:message key="auth.msg.input.login"/></label>
		<html:text property="login" styleId="loginInp"/>
		<html:errors property="login"/>
	</div>
	<div>
		<label for="passwordInp"><bean:message key="auth.msg.input.password"/></label>
		<html:text property="password" styleId="passwordInp"/>
		<html:errors property="password"/>
	</div>
	<div>
		<button type="submit"><bean:message key="auth.msg.button.submit"/></button>
	</div>
</html:form>