package com.haurylenka.projects.reservation.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.haurylenka.projects.reservation.beans.Customer;
import com.haurylenka.projects.reservation.exceptions.ReservationDAOException;
import com.haurylenka.projects.reservation.exceptions.ReservationException;
import com.haurylenka.projects.reservation.factories.ReservationDAOFactory;
import com.haurylenka.projects.reservation.interfaces.ReservationDAO;

public class CustomerTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	private String code;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			ServletRequest request = pageContext.getRequest();
			ReservationDAO resDAO = ReservationDAOFactory.getResrvationDAO();
			Customer customer = resDAO.getCustomer(code);
			request.setAttribute("customer", customer);
		} catch (ReservationDAOException e) {
			throw new ReservationException(
					"Unable to get the customer for code " + code, e);
		}
		return SKIP_BODY;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
