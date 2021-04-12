package org.jetbrains.task.oauth.view;

import org.jetbrains.task.oauth.view.model.GoogleCredentials;
import org.jetbrains.task.oauth.view.servlets.HomeServlet;
import org.jetbrains.task.oauth.view.servlets.LogoutServlet;
import org.jetbrains.task.oauth.view.servlets.SigningServlet;
import org.jetbrains.task.oauth.view.servlets.StopApplicationServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    @Value("${google.clientId}")
    private String clientId;

    @Value("${google.clientSecret}")
    private String clientSecret;

    @Value("${google.grantType}")
    private String grantType;

    @Value("${google.redirectUri}")
    private String redirectUri;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean signinServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SigningServlet(), "/signin");
        return bean;
    }

    @Bean
    public ServletRegistrationBean authServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new HomeServlet(), "/home");
        return bean;
    }

    @Bean
    public ServletRegistrationBean logoutServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new LogoutServlet(), "/logout");
        return bean;
    }

    @Bean
    public ServletRegistrationBean shuttingDownAppServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StopApplicationServlet(), "/stop");
        return bean;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GoogleCredentials credentials() {
        return new GoogleCredentials(clientId, clientSecret, grantType, redirectUri);
    }
}
