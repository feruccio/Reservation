package com.haurylenka.projects.reservation.tags;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.haurylenka.projects.reservation.beans.Reservation;
import com.haurylenka.projects.reservation.beans.User;
import com.haurylenka.projects.reservation.exceptions.ReservationDAOException;
import com.haurylenka.projects.reservation.exceptions.ReservationException;
import com.haurylenka.projects.reservation.factories.ReservationDAOFactory;
import com.haurylenka.projects.reservation.interfaces.ReservationDAO;

public class ReservationTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String var;
	
	@Override
	public int doStartTag() throws JspException {
		String login = null;
		try {
			HttpSession session = pageContext.getSession();
			Reservation reservation = 
					(Reservation) session.getAttribute("reservation");
			if (reservation == null) {
				User user = (User) session.getAttribute("user");
				login = user.getLogin();
				ReservationDAO resDAO = ReservationDAOFactory.getResrvationDAO();
				reservation = resDAO.getReaservation(login);
				session.setAttribute("reservation", reservation);
				session.setAttribute("components", reservation.getComponents());
			}
		} catch (ReservationDAOException e) {
			throw new ReservationException(
					"Unable to get the reservation for user " + login, e);
		}
		return SKIP_BODY;
	}
	
	public String getVar() {
		return var;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
	
}
