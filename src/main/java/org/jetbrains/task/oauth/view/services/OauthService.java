package org.jetbrains.task.oauth.view.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.task.oauth.view.model.GoogleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OauthService {

  private static final String GOOGLE_OAUTH_ENDPOINT = "https://oauth2.googleapis.com/tokeninfo?id_token=";

  @Autowired
  private RestTemplate restTemplate;

  @Nullable
  public GoogleUser retrieveUser(@NotNull String idToken) {
    String url = GOOGLE_OAUTH_ENDPOINT + idToken;
    String json = restTemplate.getForObject(url, String.class);
    ResponseEntity<GoogleUser> responseEntity = restTemplate.getForEntity(url, GoogleUser.class);
    return responseEntity.getBody();
  }

}
