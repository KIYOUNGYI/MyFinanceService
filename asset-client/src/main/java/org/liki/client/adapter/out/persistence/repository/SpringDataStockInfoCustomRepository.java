package org.liki.client.adapter.out.persistence.repository;

import java.util.List;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;

public interface SpringDataStockInfoCustomRepository {

  List<StockInfoJpaEntity> getStockInfoJpaEntityListByTicker(StockInfoSearchCondition condition);
}
