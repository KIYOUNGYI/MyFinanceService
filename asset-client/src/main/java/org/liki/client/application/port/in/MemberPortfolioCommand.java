package org.liki.client.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class MemberPortfolioCommand {


  @NotNull
  private final MemberJpaEntity memberJpaEntity;

  @NotNull
  private final StockInfoJpaEntity stockInfoJpaEntity;

  @NotNull
  private final Double avgPrice;

  @NotNull
  private final Long count;

  public MemberPortfolioCommand(MemberJpaEntity memberJpaEntity, StockInfoJpaEntity stockInfoJpaEntity, Double avgPrice, Long count) {
    this.memberJpaEntity = memberJpaEntity;
    this.stockInfoJpaEntity = stockInfoJpaEntity;
    this.avgPrice = avgPrice;
    this.count = count;
  }
}
