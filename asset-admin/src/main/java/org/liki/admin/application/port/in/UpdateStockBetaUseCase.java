package org.liki.admin.application.port.in;

import org.liki.admin.domain.StockInfo;

public interface UpdateStockBetaUseCase {

  StockInfo updateStockBeta(String ticker, Double beta);

}
