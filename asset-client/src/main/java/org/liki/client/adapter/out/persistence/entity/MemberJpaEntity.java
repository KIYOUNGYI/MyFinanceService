package org.liki.client.adapter.out.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberJpaEntity", orphanRemoval = true)
  private List<MemberPortfolioJpaEntity> memberPortfolioJpaEntities = new ArrayList<>();

  @Builder
  public MemberJpaEntity(String name, String email, boolean isValid) {
    this.name = name;
    this.email = email;
    this.isValid = isValid;
  }
}
