package com.haurylenka.projects.reservation.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haurylenka.projects.reservation.beans.User;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		//nothing
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			filterChain.doFilter(request, response);
		} else {
			session.invalidate();
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// nothing
	}

}
