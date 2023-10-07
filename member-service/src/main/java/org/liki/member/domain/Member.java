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
  private final String memberName;
  private final String email;
  private final boolean isValid;

  public static Member generateMember(
      MemberId memberId,
      MemberName memberName,
      MemberEmail memberEmail,
      MemberIsValid memberIsValid
  ) {
    return new Member(
        memberId.memberId,
        memberName.memberName,
        memberEmail.email,
        memberIsValid.isValid
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
      this.memberName = value;
    }
    String memberName;
  }
  @Value
  public static class MemberIsValid {

    public MemberIsValid(boolean isValid) {
      this.isValid = isValid;
    }
    boolean isValid;
  }
  @Value
  public static class MemberEmail {

    public MemberEmail(String value) {
      this.email = value;
    }
    String email;
  }

}
