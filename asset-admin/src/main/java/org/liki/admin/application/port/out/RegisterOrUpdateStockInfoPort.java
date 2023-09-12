package org.liki.admin.application.port.out;

import org.liki.admin.adapter.out.persistence.StockInfoJpaEntity;
import org.liki.admin.domain.StockInfo;

public interface RegisterOrUpdateStockInfoPort {

  StockInfoJpaEntity registerOrUpdateStockInfo(StockInfo domain);
}
