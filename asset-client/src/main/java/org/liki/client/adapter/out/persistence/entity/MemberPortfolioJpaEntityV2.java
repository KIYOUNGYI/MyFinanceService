package org.liki.client.adapter.out.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "member_portfolio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Slf4j
public class MemberPortfolioJpaEntityV2 {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "member_id")
  private Long memberId;

  @Column(name = "stock_info_id")
  private Long stockInfoId;

  private Long stockCount;

  private Double averagePrice;//us dollar

  @Builder
  public MemberPortfolioJpaEntityV2(Long memberId, Long stockInfoId, Long stockCount, Double averagePrice) {
    this.memberId = memberId;
    this.stockInfoId = stockInfoId;
    this.stockCount = stockCount;
    this.averagePrice = averagePrice;
  }
}
