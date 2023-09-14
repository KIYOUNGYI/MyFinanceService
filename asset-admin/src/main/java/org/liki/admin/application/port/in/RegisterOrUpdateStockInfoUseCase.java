package org.liki.admin.application.port.in;

import org.liki.admin.domain.StockInfo;

public interface RegisterOrUpdateStockInfoUseCase {

  StockInfo createOrUpdateStockInfo(String ticker);
}
