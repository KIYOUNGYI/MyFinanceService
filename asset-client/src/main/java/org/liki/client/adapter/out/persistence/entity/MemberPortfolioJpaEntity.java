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
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "member_portfolio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Slf4j
public class MemberPortfolioJpaEntity {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "member_id")
  private MemberJpaEntity memberJpaEntity;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "stock_info_id")
  private StockInfoJpaEntity stockInfoJpaEntity;

  private Long stockCount;

  private Double averagePrice;//us dollar

  @Builder
  public MemberPortfolioJpaEntity(MemberJpaEntity memberJpaEntity, StockInfoJpaEntity stockInfoJpaEntity, Long stockCount, Double averagePrice) {
    this.memberJpaEntity = memberJpaEntity;
    this.stockInfoJpaEntity = stockInfoJpaEntity;
    this.stockCount = stockCount;
    this.averagePrice = averagePrice;
  }
}
