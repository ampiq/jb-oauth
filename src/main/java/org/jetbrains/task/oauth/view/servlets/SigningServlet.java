package org.jetbrains.task.oauth.view.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jetbrains.task.oauth.view.model.GoogleUser;
import org.jetbrains.task.oauth.view.services.OauthService;
import org.jetbrains.task.oauth.view.services.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
public class SigningServlet extends HttpServlet {

  @Autowired
  private OauthService oauthService;

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
	  HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/WEB-INF/jsp/signin.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String idToken = req.getParameter("idToken");
	GoogleUser googleUser;
	if (idToken != null) {
	  googleUser = oauthService.retrieveUser(idToken);
	} else {
	  googleUser = null;
	}
	if (googleUser != null) {
	  req.getSession().setAttribute("role", Role.AUTHENTICATED_USER);
	  req.getSession().setAttribute("name", googleUser.getEmail());
	  resp.sendRedirect(req.getContextPath() + "/home");
	} else {
	  req.getRequestDispatcher("/WEB-INF/jsp/signin.jsp").forward(req, resp);
	}
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
	super.init(config);
	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
  }

}
