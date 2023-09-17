package org.liki.client.adapter.out.persistence.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataStockInfoCustom;
import org.liki.client.adapter.out.persistence.repository.StockInfoSearchCondition;

@Slf4j
//@RequiredArgsConstructor
public class SpringDataStockInfoCustomImpl implements SpringDataStockInfoCustom {

  private final JPAQueryFactory queryFactory;

  public SpringDataStockInfoCustomImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public List<StockInfoJpaEntity> getStockInfoJpaEntityListByTicker(StockInfoSearchCondition stockInfoSearchCondition) {

//    queryFactory.select(QStockInfoJpaEntity.class)


    return null;
  }
}
