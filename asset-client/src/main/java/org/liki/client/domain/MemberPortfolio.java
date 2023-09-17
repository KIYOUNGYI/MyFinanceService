package org.liki.client.domain;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class MemberPortfolio {

  private Member member;

  private StockInfo stockInfo;

  private Long count;

  private Double avgPrice;
}
