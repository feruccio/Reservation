<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="res" uri="http://projects.haurylenka.com/tags-reservation" %>

<html>
	<body>
		<div class="container">
			<res:setReservation code=""/>
			<logic:empty name="reservation">
				<bean:message key="reservation.msg.reservation.absent"/>
			</logic:empty>
			<logic:notEmpty name="reservation">
				<div>
					<bean:message key="reservation.msg.reservation.code"/>
					<bean:write name="reservation" property="code"/>
				</div>
				<div>
					<bean:message key="reservation.msg.reservation.description"/>
					<bean:write name="reservation" property="description"/>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th><bean:message key="reservation.msg.column.type"/></th>
							<th><bean:message key="reservation.msg.column.time"/></th>
							<th><bean:message key="reservation.msg.column.status"/></th>
							<th><bean:message key="reservation.msg.column.sequence"/></th>
						</tr>
					</thead>
					<tbody>
						<logic:iterate id="component" name="reservation" property="components">
							<tr>
								<td><bean:write name="component" property="componentTypeCode"/></td>
								<td><bean:write name="component" property="createDateTime"/></td>
								<td><bean:write name="component" property="internalStatus"/></td>
								<td><bean:write name="component" property="sequence"/></td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
			</logic:notEmpty>
		</div>
	</body>
</html>