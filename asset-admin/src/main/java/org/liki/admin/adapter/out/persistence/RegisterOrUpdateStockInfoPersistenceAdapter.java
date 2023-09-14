package org.liki.admin.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.adapter.out.persistence.repository.SpringDataStockInfoRepository;
import org.liki.admin.application.port.out.RegisterOrUpdateStockInfoPort;
import org.liki.admin.domain.StockInfo;
import org.liki.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterOrUpdateStockInfoPersistenceAdapter implements RegisterOrUpdateStockInfoPort {

  private final SpringDataStockInfoRepository stockInfoRepository;

  @Override
  public StockInfoJpaEntity registerStockInfo(StockInfo domain) {

    StockInfoJpaEntity save = stockInfoRepository.save(StockInfoJpaEntity.builder()
        .companyName(domain.getCompanyName())
        .ticker(domain.getTicker())
        .oneYearTargetEst(domain.getOneYearTargetEst())
        .fiftyTwoWeekRange(domain.getFiftyTwoWeekRange())
        .ask(domain.getAsk())
        .avgVolume(domain.getAvgVolume())
        .beta(domain.getBeta())
        .daysRange(domain.getDaysRange())
        .eps(domain.getEps())
        .earningsDate(domain.getEarningsDate())
        .exDividendDate(domain.getExDividendDate())
        .forwardDividendAndYield(domain.getForwardDividendAndYield())
        .marketCap(domain.getMarketCap())
        .open(domain.getOpen())
        .peRatio(domain.getPeRatio())
        .previousClose(domain.getPreviousClose())
        .quotePrice(domain.getQuotePrice())
        .volume(domain.getVolume())
        .build()
    );

    return save;
  }
}
