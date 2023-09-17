package org.liki.client.application.port.out;

import java.util.List;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;

public interface GetStockInfoByTickersPort {

  List<StockInfoJpaEntity> getStockInfosByTickers(List<String> tickers);
}
