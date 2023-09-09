package org.liki.member.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJpaEntity {

  @Id
  @GeneratedValue
  private Long memberId;

  private String name;

  private String email;

  private boolean isValid;

  @Builder
  public MemberJpaEntity(String name, String email, boolean isValid) {
    this.name = name;
    this.email = email;
    this.isValid = isValid;
  }
}
