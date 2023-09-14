package org.liki.admin.application.port.out;

import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.admin.domain.StockInfo;

public interface RegisterOrUpdateStockInfoPort {

  StockInfoJpaEntity registerStockInfo(StockInfo domain);
}
