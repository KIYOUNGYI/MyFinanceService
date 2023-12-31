package org.liki.client.adapter.out.persistence.entity;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "member_cash")
//@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MemberCashJpaEntity {

  @Id
  @GeneratedValue
  private Long memberCashId;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "member_id")
  private MemberJpaEntity memberJpaEntity;

  private Double cashAmount;

  @Builder
  public MemberCashJpaEntity(MemberJpaEntity memberJpaEntity, Double cashAmount) {
    this.memberJpaEntity = memberJpaEntity;
    this.cashAmount = cashAmount;
  }
}
