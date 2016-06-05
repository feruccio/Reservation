package com.haurylenka.projects.reservation.actions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ChangeLocale extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String language = request.getParameter("language");
		String country = request.getParameter("country");
		if (country == null) {
			setLocale(request, new Locale(language));
		} else {
			setLocale(request, new Locale(language, country));
		}
		return new ActionForward(mapping.findForward("success"));
	}

	
	
}
