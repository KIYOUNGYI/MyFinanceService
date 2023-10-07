package org.liki.client.adapter.out.persistence.query;

import static org.liki.client.adapter.out.persistence.entity.QMemberPortfolioJpaEntity.memberPortfolioJpaEntity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberPortfolioCustomRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SpringDataMemberPortfolioCustomRepositoryImpl implements SpringDataMemberPortfolioCustomRepository {

  private final JPAQueryFactory queryFactory;

  public SpringDataMemberPortfolioCustomRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }


  @Override
  public void deleteMemberPortfolioByMemberId(Long memberId) {

    long execute = queryFactory.delete(memberPortfolioJpaEntity)
        .where(memberPortfolioJpaEntity.memberJpaEntity.memberId.eq(memberId))
        .execute();

    log.info("deleteMemberPortfolioByMemberId execute = {}", execute);
  }

  @Override
  public List<MemberPortfolioJpaEntity> getMemberPortfolioByMemberId(Long memberId) {

    List<MemberPortfolioJpaEntity> fetch = queryFactory.selectFrom(memberPortfolioJpaEntity)
        .where(memberPortfolioJpaEntity.memberJpaEntity.memberId.eq(memberId))
        .fetch();

    return fetch;
  }
}
