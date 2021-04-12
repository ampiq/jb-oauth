package org.jetbrains.task.oauth.view.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleOauthToken {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("expires_in")
  private String expiresIn;
  @JsonProperty("scope")
  private String scope;
  @JsonProperty("token_type")
  private String tokenType;
  @JsonProperty("id_token")
  private String idToken;

  public GoogleOauthToken() {

  }

  public GoogleOauthToken(String accessToken, String refreshToken, String expiresIn,
	  String scope, String tokenType, String idToken) {
	this.accessToken = accessToken;
	this.refreshToken = refreshToken;
	this.expiresIn = expiresIn;
	this.scope = scope;
	this.tokenType = tokenType;
	this.idToken = idToken;
  }

  @JsonGetter("access_token")
  public String getAccessToken() {
	return accessToken;
  }

  @JsonSetter("access_token")
  public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
  }

  @JsonGetter("refresh_token")
  public String getRefreshToken() {
	return refreshToken;
  }

  @JsonSetter("refresh_token")
  public void setRefreshToken(String refreshToken) {
	this.refreshToken = refreshToken;
  }

  @JsonGetter("expires_in")
  public String getExpiresIn() {
	return expiresIn;
  }

  @JsonSetter("expires_in")
  public void setExpiresIn(String expiresIn) {
	this.expiresIn = expiresIn;
  }

  @JsonGetter("scope")
  public String getScope() {
	return scope;
  }

  @JsonSetter("scope")
  public void setScope(String scope) {
	this.scope = scope;
  }

  @JsonGetter("token_type")
  public String getTokenType() {
	return tokenType;
  }

  @JsonSetter("token_type")
  public void setTokenType(String tokenType) {
	this.tokenType = tokenType;
  }

  @JsonGetter("id_token")
  public String getIdToken() {
	return idToken;
  }

  @JsonSetter("id_token")
  public void setIdToken(String idToken) {
	this.idToken = idToken;
  }

  @Override
  public String toString() {
	return "GoogleOauthToken{" +
		"accessToken='" + accessToken + '\'' +
		", refreshToken='" + refreshToken + '\'' +
		", expiresIn='" + expiresIn + '\'' +
		", scope='" + scope + '\'' +
		", tokenType='" + tokenType + '\'' +
		", idToken='" + idToken + '\'' +
		'}';
  }
}
