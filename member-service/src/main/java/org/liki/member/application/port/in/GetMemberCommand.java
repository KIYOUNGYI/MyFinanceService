package org.liki.member.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class GetMemberCommand {

  private final Long id;

  @Builder
  public GetMemberCommand(Long id) {
    this.id = id;
  }
}
