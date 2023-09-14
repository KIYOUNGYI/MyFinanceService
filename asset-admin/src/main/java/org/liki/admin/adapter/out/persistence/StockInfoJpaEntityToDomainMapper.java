package org.liki.admin.adapter.out.persistence;

import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.domain.StockInfo;
import org.springframework.stereotype.Component;

@Component
public class StockInfoJpaEntityToDomainMapper {


  public static StockInfo stockInfoJpaEntityToDomain(StockInfoJpaEntity entity) {

    return StockInfo.builder()
        .idStockInfo(entity.getIdStockInfo())
        .ticker(entity.getTicker())
        .oneYearTargetEst(entity.getOneYearTargetEst())
        .forwardDividendAndYield(entity.getForwardDividendAndYield())
        .ask(entity.getAsk())
        .avgVolume(entity.getAvgVolume())
        .beta(entity.getBeta())
        .daysRange(entity.getDaysRange())
        .eps(entity.getEps())
        .earningsDate(entity.getEarningsDate())
        .exDividendDate(entity.getExDividendDate())
        .exDividendDate(entity.getExDividendDate())
        .forwardDividendAndYield(entity.getForwardDividendAndYield())
        .marketCap(entity.getMarketCap())
        .open(entity.getOpen())
        .peRatio(entity.getPeRatio())
        .previousClose(entity.getPreviousClose())
        .quotePrice(entity.getQuotePrice())
        .volume(entity.getVolume())
        .build();
  }

}
