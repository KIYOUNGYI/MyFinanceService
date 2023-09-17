package org.liki.client.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.StockInfoJpaEntityToDomainMapper;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.application.port.in.GetStockInfoByTickersUseCase;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.client.domain.StockInfo;
import org.liki.common.UseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@Service
@RequiredArgsConstructor
@Transactional
public class StockInfoService implements GetStockInfoByTickersUseCase {

  private final GetStockInfoByTickersPort getStockInfoByTickersPort;

  @Override
  public Map<String, StockInfo> getStockInfosByTickers(List<String> tickers) {

    List<StockInfoJpaEntity> stockInfosByTickers = getStockInfoByTickersPort.getStockInfosByTickers(tickers);

    List<StockInfo> list = new ArrayList<>();

    Map<String, StockInfo> stockInfoMap = new HashMap<>();

    for (StockInfoJpaEntity stockInfosByTicker : stockInfosByTickers) {

      StockInfo stockInfo = StockInfoJpaEntityToDomainMapper.stockInfoJpaEntityToDomain(stockInfosByTicker);
      list.add(stockInfo);

      stockInfoMap.put(stockInfo.getTicker(), stockInfo);
    }
//    log.info("StockInfoService.getStockInfosByTickers list = {}" ,list);

    return stockInfoMap;
  }
}
