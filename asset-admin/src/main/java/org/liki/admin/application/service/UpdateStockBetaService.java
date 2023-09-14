package org.liki.admin.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.admin.adapter.out.persistence.StockInfoJpaEntityToDomainMapper;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.application.port.in.UpdateStockBetaUseCase;
import org.liki.admin.application.port.out.GetStockInfoPort;
import org.liki.admin.application.port.out.UpdateStockBetaPort;
import org.liki.admin.domain.StockInfo;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class UpdateStockBetaService implements UpdateStockBetaUseCase {

  private final GetStockInfoPort getStockInfoPort;

  //굳이 updateStockBetaPort 를 만들어야 할 지 의문

  @Override
  public StockInfo updateStockBeta(String ticker, Double beta) {

    StockInfoJpaEntity entity = getStockInfoPort.getStockInfoByTicker(ticker);

    entity.updateBeta(beta);

    StockInfo stockInfo = StockInfoJpaEntityToDomainMapper.stockInfoJpaEntityToDomain(entity);

    return stockInfo;
  }

}
