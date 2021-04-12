package org.jetbrains.task.oauth.view.servlets.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jetbrains.task.oauth.view.model.GoogleUser;
import org.jetbrains.task.oauth.view.model.Role;
import org.jetbrains.task.oauth.view.services.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OauthController {

  @Autowired
  private OauthService service;

  @GetMapping("/oauth")
  public String googleRedirect(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) {
    if (code == null) {
      return "forward:/home";
    }
    GoogleUser googleUser = service.retrieveUser(code);
    if (googleUser == null) {
      return "forward:/home";
    }

    request.getSession().setAttribute("role", Role.AUTHORIZED_USER);
    request.getSession().setAttribute("name", googleUser.getEmail());
    return "redirect:/home";
  }
}
