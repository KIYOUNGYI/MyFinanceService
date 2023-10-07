package org.liki.client.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.liki.client.adapter.out.persistence.entity.QMemberCashJpaEntity.memberCashJpaEntity;
import static org.liki.client.adapter.out.persistence.entity.QMemberJpaEntity.memberJpaEntity;
import static org.liki.client.adapter.out.persistence.entity.QMemberPortfolioJpaEntity.memberPortfolioJpaEntity;
import static org.liki.client.adapter.out.persistence.entity.QStockInfoJpaEntity.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QMemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QMemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QMemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QStockInfoJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * join, fetch-join 차이를 제대로 알아보고 싶어서 테스트 코드 작성
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberPersistenceAdapterTest {

  @Autowired
  EntityManager em;
  JPAQueryFactory queryFactory;

  @BeforeEach
  public void init() {
    queryFactory = new JPAQueryFactory(em);
  }

  @Test
  void 일반_조인() {

    //select
    //	memberport0_.id as id1_2_,
    //	memberport0_.average_price as average_2_2_,
    //	memberport0_.member_id as member_i4_2_,
    //	memberport0_.stock_count as stock_co3_2_,
    //	memberport0_.stock_info_id as stock_in5_2_
    //from
    //	member_portfolio memberport0_
    //inner join stock_info stockinfoj1_ on
    //	(memberport0_.stock_info_id = stockinfoj1_.stock_info_id)
    //inner join member memberjpae2_ on
    //	(memberjpae2_.member_id = memberport0_.member_id)
    //where
    //	memberjpae2_.member_id = 10;

    List<MemberPortfolioJpaEntity> fetch = queryFactory.select(memberPortfolioJpaEntity)
        .from(memberPortfolioJpaEntity)
        .innerJoin(stockInfoJpaEntity)
        .on(memberPortfolioJpaEntity.stockInfoJpaEntity.stockInfoId.eq(stockInfoJpaEntity.stockInfoId))
        .innerJoin(memberJpaEntity)
        .on(memberJpaEntity.memberId.eq(memberPortfolioJpaEntity.memberJpaEntity.memberId))
        .where(memberJpaEntity.memberId.eq(10L))
        .fetch();

    System.out.println("fetch = " + fetch);
  }

  @Test
  void 페치_조인() {



    List<MemberPortfolioJpaEntity> fetch = queryFactory.select(memberPortfolioJpaEntity)
        .from(memberPortfolioJpaEntity)
        .innerJoin(stockInfoJpaEntity)
        .fetchJoin()
        .on(memberPortfolioJpaEntity.stockInfoJpaEntity.stockInfoId.eq(stockInfoJpaEntity.stockInfoId))
        .innerJoin(memberJpaEntity)
        .fetchJoin()
        .on(memberJpaEntity.memberId.eq(memberPortfolioJpaEntity.memberJpaEntity.memberId))
        .where(memberJpaEntity.memberId.eq(10L))
        .fetch();

//    System.out.println("fetch = " + fetch);

    //
  }


}