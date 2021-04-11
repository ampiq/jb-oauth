package org.jetbrains.task.oauth.view.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleUser {
  @JsonProperty("iss")
  private String iss;
  @JsonProperty("aud")
  private String appId;
  @JsonProperty("email")
  private String email;
  @JsonProperty("email_verified")
  private String isEmailVerified;
  @JsonProperty("name")
  private String fullName;

  @JsonGetter("iss")
  public String getIss() {
	return iss;
  }

  @JsonSetter("iss")
  public void setIss(String iss) {
	this.iss = iss;
  }

  @JsonGetter("aud")
  public String getAppId() {
	return appId;
  }

  @JsonSetter("aud")
  public void setAppId(String appId) {
	this.appId = appId;
  }

  @JsonGetter("email")
  public String getEmail() {
	return email;
  }

  @JsonSetter("email")
  public void setEmail(String email) {
	this.email = email;
  }

  @JsonGetter("email_verified")
  public String getIsEmailVerified() {
	return isEmailVerified;
  }

  @JsonSetter("email_verified")
  public void setIsEmailVerified(String isEmailVerified) {
	this.isEmailVerified = isEmailVerified;
  }

  @JsonGetter("name")
  public String getFullName() {
	return fullName;
  }

  @JsonSetter("name")
  public void setFullName(String fullName) {
	this.fullName = fullName;
  }

  @Override
  public String toString() {
	return "GoogleUser{" +
		"iss='" + iss + '\'' +
		", appId='" + appId + '\'' +
		", email='" + email + '\'' +
		", isEmailVerified='" + isEmailVerified + '\'' +
		", fullName='" + fullName + '\'' +
		'}';
  }
}
