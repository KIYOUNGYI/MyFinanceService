package org.liki.client.adapter.out.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataStockInfoCustomRepository;
import org.liki.client.adapter.out.persistence.repository.SpringDataStockInfoRepository;
import org.liki.client.adapter.out.persistence.repository.StockInfoSearchCondition;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.client.domain.StockInfo;
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

  @Override
  public Map<String, StockInfoJpaEntity> getStockInfoMapByTickers(List<String> tickers) {

      List<StockInfoJpaEntity> stockInfosByTickers = this.getStockInfosByTickers(tickers);
      System.out.println("stockInfosByTickers = " + stockInfosByTickers);
      Map<String, StockInfoJpaEntity> stockInfoMap = new HashMap<>();

      for (StockInfoJpaEntity stockInfosByTicker : stockInfosByTickers) {
        stockInfoMap.put(stockInfosByTicker.getTicker(), stockInfosByTicker);
      }
      log.info("stockInfoMap => {}", stockInfoMap);
      return stockInfoMap;
    }
}
