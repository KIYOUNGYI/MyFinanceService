package org.liki.admin.application.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.admin.adapter.out.persistence.StockInfoJpaEntityToDomainMapper;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.application.port.in.GetStockInfoListUseCase;
import org.liki.admin.application.port.out.GetStockInfoListPort;
import org.liki.admin.domain.StockInfo;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@UseCase
public class GetStockInfoListService implements GetStockInfoListUseCase {

  private final GetStockInfoListPort getStockInfoListPort;

  @Override
  public List<StockInfo> getStockInfoList(List<String> tickers) {

    List<StockInfoJpaEntity> stockInfoListByTickers = getStockInfoListPort.getStockInfoListByTickers(tickers);

    List<StockInfo> list = new ArrayList<>();

    for (StockInfoJpaEntity stockInfoListByTicker : stockInfoListByTickers) {
      list.add(StockInfoJpaEntityToDomainMapper.stockInfoJpaEntityToDomain(stockInfoListByTicker));
    }

    return list;
  }
}
