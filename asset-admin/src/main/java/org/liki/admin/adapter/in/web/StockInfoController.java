package org.liki.admin.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.liki.admin.application.port.in.GetStockInfoUseCase;
import org.liki.admin.application.port.in.RegisterOrUpdateStockInfoUseCase;
import org.liki.admin.application.port.in.UpdateStockBetaUseCase;
import org.liki.admin.domain.StockInfo;
import org.liki.common.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class StockInfoController {

  private final RegisterOrUpdateStockInfoUseCase registerOrUpdateStockInfoUseCase;
  private final GetStockInfoUseCase getStockInfoUseCase;

  private final UpdateStockBetaUseCase updateStockBetaUseCase;

  @PostMapping("/api/stockInfo/{ticker}")
  StockInfo createOrUpdateTicker(@PathVariable String ticker) {

    return registerOrUpdateStockInfoUseCase.createOrUpdateStockInfo(ticker);
  }

  @GetMapping("/api/stockInfo/{ticker}")
  StockInfo getStockInfo(@PathVariable String ticker) {

    return getStockInfoUseCase.getStockInfo(ticker);
  }

  @PutMapping("/api/stockInfo/{ticker}/beta")
  StockInfo updateStockBeta(@PathVariable String ticker, @RequestBody StockBetaRequest request) {

    StockInfo stockInfo = updateStockBetaUseCase.updateStockBeta(ticker, request.getBeta());

    return stockInfo;
  }
}
