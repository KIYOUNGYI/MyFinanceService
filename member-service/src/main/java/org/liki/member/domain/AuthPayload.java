package org.liki.member.domain;

import lombok.Data;

@Data
public class AuthPayload {

  private Long memberId;
  private String email;
}
