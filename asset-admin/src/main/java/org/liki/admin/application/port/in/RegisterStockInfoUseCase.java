package org.liki.admin.application.port.in;

import org.liki.admin.domain.StockInfo;

public interface RegisterStockInfoUseCase {

  StockInfo createOrUpdateStockInfo(String ticker);
}
