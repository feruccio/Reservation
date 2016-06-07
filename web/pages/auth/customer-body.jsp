<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="res" uri="http://projects.haurylenka.com/tags-reservation" %>

<html>
	<body>
		<div class="container">
			<res:setCustomer code=""/>
			<logic:empty name="customer">
				<bean:message key="customer.msg.customer.absent"/>
			</logic:empty>
			<logic:notEmpty name="customer">
				<div>
					<bean:message key="customer.msg.customer.email"/>
					<bean:write name="customer" property="email"/>
				</div>
				<div>
					<bean:message key="customer.msg.customer.phone"/>
					<bean:write name="customer" property="phone"/>
				</div>
				<h4><bean:message key="customer.msg.table.name"/></h4>
				<table class="table">
					<thead>
						<tr>
							<th><bean:message key="customer.msg.column.amountPaid"/></th>
							<th><bean:message key="customer.msg.column.formOfPaymentTypeCode"/></th>
							<th><bean:message key="customer.msg.column.currencyCode"/></th>
						</tr>
					</thead>
					<tbody>
						<logic:iterate id="payment" name="customer" property="payments">
							<tr>
								<td><bean:write name="payment" property="amountPaid"/></td>
								<td><bean:write name="payment" property="formOfPaymentTypeCode"/></td>
								<td><bean:write name="payment" property="currencyCode"/></td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
			</logic:notEmpty>
		</div>
	</body>
	
</html>