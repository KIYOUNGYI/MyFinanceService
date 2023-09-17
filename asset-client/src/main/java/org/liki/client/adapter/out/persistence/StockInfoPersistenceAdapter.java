package org.liki.client.adapter.out.persistence;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataStockInfoCustomRepository;
import org.liki.client.adapter.out.persistence.repository.SpringDataStockInfoRepository;
import org.liki.client.adapter.out.persistence.repository.StockInfoSearchCondition;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.common.PersistenceAdapter;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class StockInfoPersistenceAdapter implements GetStockInfoByTickersPort {

//  private final SpringDataStockInfoRepository springDataStockInfoRepository;
  private final SpringDataStockInfoCustomRepository springDataStockInfoCustomRepository;

  @Override
  public List<StockInfoJpaEntity> getStockInfosByTickers(List<String> tickers) {

    StockInfoSearchCondition condition = StockInfoSearchCondition.builder()
        .tickers(tickers)
        .build();

    List<StockInfoJpaEntity> stockInfoJpaEntityListByTicker = springDataStockInfoCustomRepository.getStockInfoJpaEntityListByTicker(condition);

    return stockInfoJpaEntityListByTicker;
  }
}
