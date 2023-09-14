package org.liki.admin.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.admin.adapter.out.persistence.StockInfoJpaEntityToDomainMapper;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.application.port.in.GetStockInfoUseCase;
import org.liki.admin.application.port.out.GetStockInfoPort;
import org.liki.admin.domain.StockInfo;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@UseCase
public class GetStockInfoService implements GetStockInfoUseCase {

  private final GetStockInfoPort getStockInfoPort;

  @Override
  public StockInfo getStockInfo(String ticker) {
    StockInfoJpaEntity entity = getStockInfoPort.getStockInfoByTicker(ticker);
    //db -> domain
    return StockInfoJpaEntityToDomainMapper.stockInfoJpaEntityToDomain(entity);
  }
}
