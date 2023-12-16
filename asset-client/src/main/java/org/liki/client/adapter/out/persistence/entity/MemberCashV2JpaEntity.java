package org.liki.client.adapter.out.persistence.entity;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
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
public class MemberCashV2JpaEntity {

  @Id
  @GeneratedValue
  private Long memberCashId;

  @Column(name = "member_id")
  private Long memberId;

  private Double cashAmount;

  @Builder
  public MemberCashV2JpaEntity(Long memberId, Double cashAmount) {
    this.memberId = memberId;
    this.cashAmount = cashAmount;
  }
}
