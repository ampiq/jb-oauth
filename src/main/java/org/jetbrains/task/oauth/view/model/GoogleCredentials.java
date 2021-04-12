package org.jetbrains.task.oauth.view.model;

public class GoogleCredentials {

  private String clientId;

  private String clientSecret;

  private String grantType;

  private String redirectUri;

  public GoogleCredentials(String clientId, String clientSecret, String grantType, String redirectUri) {
	this.clientId = clientId;
	this.clientSecret = clientSecret;
	this.grantType = grantType;
	this.redirectUri = redirectUri;
  }

  public String getClientId() {
	return clientId;
  }

  public void setClientId(String clientId) {
	this.clientId = clientId;
  }

  public String getClientSecret() {
	return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
	this.clientSecret = clientSecret;
  }

  public String getGrantType() {
	return grantType;
  }

  public void setGrantType(String grantType) {
	this.grantType = grantType;
  }

  public String getRedirectUri() {
	return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
	this.redirectUri = redirectUri;
  }

  @Override
  public String toString() {
	return "GoogleCredentials{" +
		"clientId='" + clientId + '\'' +
		", clientSecret='" + clientSecret + '\'' +
		", grantType='" + grantType + '\'' +
		", redirectUri='" + redirectUri + '\'' +
		'}';
  }
}
