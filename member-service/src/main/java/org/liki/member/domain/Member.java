package org.liki.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Member {

  private final String memberId;
  private final String email;
  private final String memberName;
  private final boolean isValid;

  public static Member generateMember(
      MemberId memberId,
      MemberName memberName,
      MemberEmail memberEmail,
      MemberIsValid memberIsValid
  ) {
    return new Member(
        memberId.memberId,
        memberName.name,
        memberEmail.emailValue,
        memberIsValid.isValidValue
    );
  }
  @Value
  public static class MemberId {

    public MemberId(String memberId) {
      this.memberId = memberId;
    }
    String memberId;
  }
  @Value
  public static class MemberName {

    public MemberName(String value) {
      this.name = value;
    }
    String name;
  }
  @Value
  public static class MemberIsValid {

    public MemberIsValid(boolean isValidValue) {
      this.isValidValue = isValidValue;
    }
    boolean isValidValue;
  }
  @Value
  public static class MemberEmail {

    public MemberEmail(String value) {
      this.emailValue = value;
    }
    String emailValue;
  }

}
