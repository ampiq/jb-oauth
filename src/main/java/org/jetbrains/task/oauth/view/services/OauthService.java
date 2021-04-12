package org.jetbrains.task.oauth.view.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.task.oauth.view.model.GoogleCredentials;
import org.jetbrains.task.oauth.view.model.GoogleOauthToken;
import org.jetbrains.task.oauth.view.model.GoogleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OauthService {

  @Value("${google.tokenInfoEndpoint}")
  private String tokenInfoEndpoint;

  @Value("${google.accessTokensEndpoint}")
  private String accessTokensEndpoint;

  @Autowired
  private GoogleCredentials credentials;

  @Autowired
  private RestTemplate restTemplate;

  @Nullable
  public GoogleUser retrieveUser(@NotNull String code) {
    try {
      UriComponents getAccessTokensUri = UriComponentsBuilder.fromHttpUrl(tokenInfoEndpoint)
          .queryParam("id_token", retrieveIdToken(code))
          .build();
      ResponseEntity<GoogleUser> responseEntity = restTemplate.getForEntity(getAccessTokensUri.toUri(), GoogleUser.class);
      return responseEntity.getBody();
    } catch (Exception e) {
      return null;
    }
  }

  @NotNull
  private String retrieveIdToken(@NotNull String code) {
    UriComponents getAccessTokensUri = UriComponentsBuilder.fromHttpUrl(accessTokensEndpoint)
        .queryParam("code", code)
        .queryParam("client_id", credentials.getClientId())
        .queryParam("client_secret", credentials.getClientSecret())
        .queryParam("grant_type", credentials.getGrantType())
        .queryParam("redirect_uri", credentials.getRedirectUri())
        .build();
    ResponseEntity<GoogleOauthToken> responseEntity = restTemplate.postForEntity(getAccessTokensUri.toUri(), null, GoogleOauthToken.class);
    return responseEntity.getBody().getIdToken();
  }

}
