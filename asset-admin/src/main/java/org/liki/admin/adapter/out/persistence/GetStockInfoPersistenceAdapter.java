package org.liki.admin.adapter.out.persistence;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.adapter.out.persistence.repository.SpringDataStockInfoRepository;
import org.liki.admin.application.port.out.GetStockInfoListPort;
import org.liki.admin.application.port.out.GetStockInfoPort;
import org.liki.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetStockInfoPersistenceAdapter implements GetStockInfoPort , GetStockInfoListPort {

  private final SpringDataStockInfoRepository stockInfoRepository;

  @Override
  public StockInfoJpaEntity getStockInfoByTicker(String ticker) {
    StockInfoJpaEntity stockInfoJpaEntityByTicker = stockInfoRepository.getStockInfoJpaEntityByTicker(ticker);
    return stockInfoJpaEntityByTicker;
  }

  @Override
  public List<StockInfoJpaEntity> getStockInfoListByTickers(List<String> tickers) {

    List<StockInfoJpaEntity> stockInfoJpaEntityByTickers = stockInfoRepository.findAllByTickerIn(tickers);
    return stockInfoJpaEntityByTickers;
  }
}
