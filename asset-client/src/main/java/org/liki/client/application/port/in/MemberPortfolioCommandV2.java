package org.liki.client.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class MemberPortfolioCommandV2 {

  @NotNull
  private final Long memberId;

  @NotNull
  private final Long stockInfoId;

  @NotNull
  private final Double avgPrice;

  @NotNull
  private final Long count;

  public MemberPortfolioCommandV2(Long memberId, Long stockInfoId, Double avgPrice, Long count) {
    this.memberId = memberId;
    this.stockInfoId = stockInfoId;
    this.avgPrice = avgPrice;
    this.count = count;
  }
}
