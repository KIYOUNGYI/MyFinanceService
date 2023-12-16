package org.liki.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@JsonIgnoreProperties(ignoreUnknown = true)//에러 방지 차원
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Member {

  private Long memberId;
  private String email;
  private String memberName;

  @JsonProperty("valid")
  private boolean isValid;

  public Member() {
  }

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

    public MemberId(Long memberId) {
      this.memberId = memberId;
    }

    Long memberId;
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
