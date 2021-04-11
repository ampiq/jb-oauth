package org.jetbrains.task.oauth.view.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jetbrains.task.oauth.view.services.ShuttingDownApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class StopApplicationServlet extends HttpServlet {

  private static final int EXIT_CODE = 0;

  @Autowired
  private ShuttingDownApplicationService shuttingDownApplicationService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doStopApp(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doStopApp(req, resp);
  }

  private void doStopApp(HttpServletRequest request, HttpServletResponse response) {
    shuttingDownApplicationService.shutDown(EXIT_CODE);
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
	super.init(config);
	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
  }

}
