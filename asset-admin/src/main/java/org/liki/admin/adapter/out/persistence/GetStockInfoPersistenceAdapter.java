package org.liki.admin.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.adapter.out.persistence.repository.SpringDataStockInfoRepository;
import org.liki.admin.application.port.out.GetStockInfoPort;
import org.liki.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetStockInfoPersistenceAdapter implements GetStockInfoPort {

  private final SpringDataStockInfoRepository stockInfoRepository;

  @Override
  public StockInfoJpaEntity getStockInfoByTicker(String ticker) {
    StockInfoJpaEntity stockInfoJpaEntityByTicker = stockInfoRepository.getStockInfoJpaEntityByTicker(ticker);
    return stockInfoJpaEntityByTicker;
  }
}
