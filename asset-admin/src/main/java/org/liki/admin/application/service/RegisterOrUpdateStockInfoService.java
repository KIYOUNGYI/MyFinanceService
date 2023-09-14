package org.liki.admin.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.admin.adapter.out.external.yfin.YahooFinStockInfoResponse;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.adapter.out.persistence.StockInfoJpaEntityToDomainMapper;
import org.liki.admin.adapter.out.persistence.YahooFinStockInfoToStockInfoDomainMapper;
import org.liki.admin.application.port.in.RegisterOrUpdateStockInfoUseCase;
import org.liki.admin.application.port.out.RegisterOrUpdateStockInfoPort;
import org.liki.admin.application.port.out.RequestYahooFinStockInfoPort;
import org.liki.admin.domain.StockInfo;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisterOrUpdateStockInfoService implements RegisterOrUpdateStockInfoUseCase {

  private final RegisterOrUpdateStockInfoPort registerStockInfoPort;
  private final RequestYahooFinStockInfoPort requestYahooFinStockInfoPort;
  @Override
  public StockInfo createOrUpdateStockInfo(String ticker) {
    log.error("RegisterStockInfoService.createOrUpdateStockInfo");
    YahooFinStockInfoResponse yahooFinStockInfoResponse = requestYahooFinStockInfoPort.getStockInfo(ticker);
    log.info("yahooFinStockInfoResponse => {}", yahooFinStockInfoResponse);

    //yahooFinStockInfoResponse -> domain
    StockInfo domain = YahooFinStockInfoToStockInfoDomainMapper.yahooFinStockInfoToStockInfoDomainMapper(yahooFinStockInfoResponse, ticker);

    //domain -> db (flush)
    StockInfoJpaEntity entity = registerStockInfoPort.registerOrUpdateStockInfo(domain);

    //db -> domain
    return StockInfoJpaEntityToDomainMapper.stockInfoJpaEntityToDomain(entity);
  }
}
