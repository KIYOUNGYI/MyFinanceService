package org.liki.admin.application.port.in;

import org.liki.admin.domain.StockInfo;

public interface GetStockInfoUseCase {

  StockInfo getStockInfo(String ticker);
}
