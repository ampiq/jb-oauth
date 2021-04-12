package org.jetbrains.task.oauth.view.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doLogout(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doLogout(req, resp);
  }

  private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	req.getSession().removeAttribute("role");
	req.getSession().invalidate();
	resp.sendRedirect(req.getContextPath() + "/home");
  }
}
