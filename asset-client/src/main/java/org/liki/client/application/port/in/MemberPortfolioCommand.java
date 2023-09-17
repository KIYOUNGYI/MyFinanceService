package org.liki.client.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.liki.client.domain.Member;
import org.liki.client.domain.StockInfo;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class MemberPortfolioCommand {


  @NotNull
  private final Member member;

  @NotNull
  private final StockInfo stockInfo;

  @NotNull
  private final Double avgPrice;

  @NotNull
  private final String count;

  public MemberPortfolioCommand( Member member, StockInfo stockInfo, Double avgPrice, String count) {
    this.member = member;
    this.stockInfo = stockInfo;
    this.avgPrice = avgPrice;
    this.count = count;
  }
}
