package org.jetbrains.task.oauth.view.servlets;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnknownRequestController implements ErrorController {

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request) {
	return "home";
  }

  @Override
  public String getErrorPath() {
	return "/error";
  }
}
