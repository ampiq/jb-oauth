package org.jetbrains.task.oauth.view.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ShuttingDownApplicationService implements ApplicationContextAware {

  private ApplicationContext context;

  @Override
  public void setApplicationContext(@NotNull ApplicationContext applicationContext) {
	context = applicationContext;
  }

  public void shutDown(int exitCode) {
	SpringApplication.exit(context, () -> exitCode);
  }
}
