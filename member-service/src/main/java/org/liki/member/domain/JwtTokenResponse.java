package org.liki.member.domain;

import lombok.Data;

@Data
public class JwtTokenResponse {

  private String access_token;
  private String refresh_token;
  private AuthPayload authPayload;

  public JwtTokenResponse(String access_token, String refresh_token, AuthPayload authPayload) {
    this.access_token = access_token;
    this.refresh_token = refresh_token;
    this.authPayload = authPayload;
  }
}
