package org.liki.client.adapter.out.persistence.query;

import static org.liki.client.adapter.out.persistence.entity.QStockInfoJpaEntity.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataStockInfoCustomRepository;
import org.liki.client.adapter.out.persistence.repository.StockInfoSearchCondition;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SpringDataStockInfoCustomRepositoryImpl implements SpringDataStockInfoCustomRepository {

  private final JPAQueryFactory queryFactory;

  public SpringDataStockInfoCustomRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public List<StockInfoJpaEntity> getStockInfoJpaEntityListByTicker(StockInfoSearchCondition stockInfoSearchCondition) {

    log.info("getStockInfoJpaEntityListByTicker() called");
    log.info("stockInfoSearchCondition = {}", stockInfoSearchCondition);

    List<String> tickers = stockInfoSearchCondition.getTickers();

    List<StockInfoJpaEntity> fetch = queryFactory.select(stockInfoJpaEntity)
        .from(stockInfoJpaEntity)
        .where(stockInfoJpaEntity.ticker.in(tickers))
        .fetch();

    log.info("fetch.size = {}", fetch.size());
    return fetch;
  }
}
