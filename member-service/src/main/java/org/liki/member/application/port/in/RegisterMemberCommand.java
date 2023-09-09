package org.liki.member.application.port.in;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class RegisterMemberCommand {
  //extends SelfValidating<RegisterMemberShipCommand>
  @NotNull
  private final String memberName;

  @NotNull
  private final String email;
  @AssertTrue
  private final boolean isValid;


  public RegisterMemberCommand(String memberName, String email,  boolean isValid) {

    this.memberName = memberName;
    this.email = email;
    this.isValid = isValid;

//    this.validateSelf();

  }
}
