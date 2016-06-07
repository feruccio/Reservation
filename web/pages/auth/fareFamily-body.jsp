<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="res" uri="http://projects.haurylenka.com/tags-reservation" %>

<html>
	<body>
		<div class="container">
			<res:setFareFamily code=""/>
			<logic:empty name="fareFamily">
				<bean:message key="fareFamily.msg.fareFamily.absent"/>
			</logic:empty>
			<logic:notEmpty name="fareFamily">
				<div>
					<bean:message key="fareFamily.msg.fareFamily.code"/>
					<bean:write name="fareFamily" property="fareFamilyCode"/>
				</div>
				<div>
					<bean:message key="fareFamily.msg.table.name"/>
					<bean:define id="fees" name="fareFamily" property="components"/>
					<logic:empty name="fees">
						<bean:message key="fareFamily.msg.ancillaryComponent.absent"/>
					</logic:empty>
					<logic:notEmpty name="fees">
						<logic:iterate id="fee" name="fareFamily" property="components" indexId="index">
							<logic:greaterThan value="0" name="index">, </logic:greaterThan>
							<bean:write name="fee" property="ancillaryAirComponentCode"/>
						</logic:iterate>
					</logic:notEmpty>
				</div>
			</logic:notEmpty>
		</div>
	</body>
</html>