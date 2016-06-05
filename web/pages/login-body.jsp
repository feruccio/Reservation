<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html>
	<head>
	</head>
	<body>
		<div class="container">
			<h2><bean:message key="auth.msg.form.name"/></h2>
			<html:form action="login.do" method="post">
				<div class="form-group">
					<label for="loginInp"><bean:message key="auth.msg.input.login"/></label>
					<html:text property="login" styleId="loginInp" styleClass="form-control"/>
					<span class="input-error"><html:errors property="login"/></span>
				</div>
				<div class="form-group">
					<label for="passwordInp"><bean:message key="auth.msg.input.password"/></label>
					<html:text property="password" styleId="passwordInp" styleClass="form-control"/>
					<span class="input-error"><html:errors property="password"/></span>
				</div>
				<button type="submit" class="btn btn-default"><bean:message key="auth.msg.button.submit"/></button>
			</html:form>
		</div>
	</body>
</html>