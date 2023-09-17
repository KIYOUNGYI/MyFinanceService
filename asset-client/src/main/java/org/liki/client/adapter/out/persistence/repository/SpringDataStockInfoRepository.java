package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataStockInfoRepository extends JpaRepository<StockInfoJpaEntity, Long> {

}
