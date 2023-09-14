package org.liki.admin.adapter.out.persistence.repository;

import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataStockInfoRepository extends JpaRepository<StockInfoJpaEntity, Long> {

      StockInfoJpaEntity getStockInfoJpaEntityByTicker(String ticker);
}
