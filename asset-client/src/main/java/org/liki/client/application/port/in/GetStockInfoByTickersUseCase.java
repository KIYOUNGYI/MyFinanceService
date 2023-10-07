package org.liki.client.application.port.in;

import java.util.List;
import java.util.Map;
import org.liki.client.domain.StockInfo;

public interface GetStockInfoByTickersUseCase {

  Map<String, StockInfo> getStockInfosByTickers(List<String> tickers);
}
