package org.liki.admin.application.port.out;

import java.util.List;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;

public interface GetStockInfoListPort {

  List<StockInfoJpaEntity> getStockInfoListByTickers(List<String> tickers);

}
