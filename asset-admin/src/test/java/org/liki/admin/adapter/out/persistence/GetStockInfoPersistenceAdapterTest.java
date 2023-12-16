package org.liki.admin.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.liki.admin.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetStockInfoPersistenceAdapterTest {

  @Autowired
  private GetStockInfoPersistenceAdapter getStockInfoPersistenceAdapter;

  @Test
  void hello() {
    System.out.println("hello junit");
  }

  @Test
  void test() {

    List<StockInfoJpaEntity> stockInfoListByTickers = getStockInfoPersistenceAdapter.getStockInfoListByTickers(Arrays.asList("SPY", "QQQ"));
    System.out.println("stockInfoListByTickers = " + stockInfoListByTickers);

  }

}