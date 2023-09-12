package org.liki.admin.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.liki.admin.application.port.in.RegisterStockInfoUseCase;
import org.liki.admin.domain.StockInfo;
import org.liki.common.WebAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class StockInfoController {

  private final RegisterStockInfoUseCase stockInfoUseCase;

  @PostMapping("/api/stockInfo/{ticker}")
  StockInfo createOrUpdateTicker(@PathVariable String ticker) {


    return stockInfoUseCase.createOrUpdateStockInfo(ticker);
  }
}
