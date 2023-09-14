package org.liki.admin.application.port.out;

import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;

public interface GetStockInfoPort {

  StockInfoJpaEntity getStockInfoByTicker(String ticker);
}
