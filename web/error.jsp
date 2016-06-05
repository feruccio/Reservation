<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
		<div><bean:message key="error.msg.error.key"/></div>
		<div>
			<bean:message key="error.msg.error.forward"/>
			<a href="<c:url value="/auth/logout.do"/>">Home</a>
		</div>
	</body>
</html>