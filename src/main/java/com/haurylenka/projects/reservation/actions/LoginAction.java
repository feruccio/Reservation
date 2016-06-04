package com.haurylenka.projects.reservation.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.haurylenka.projects.reservation.beans.User;
import com.haurylenka.projects.reservation.factories.UserDAOFactory;
import com.haurylenka.projects.reservation.forms.LoginForm;
import com.haurylenka.projects.reservation.interfaces.UserDAO;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		String login = loginForm.getLogin();
		String password = loginForm.getPassword();
		UserDAO userDAO = UserDAOFactory.getUserDAOImpl();
		User user = userDAO.getUser(login, password);
		if (user == null) {
			ActionMessages errors = new ActionMessages();
			errors.add("login", new ActionMessage("auth.err.login.invalid"));
			saveErrors(request, errors);
			return mapping.getInputForward();
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return mapping.findForward("success");
		}
	}
	
}
