package org.liki.client.adapter.out.persistence.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QMemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashCustomRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SpringDataMemberCashCustomRepositoryImpl implements SpringDataMemberCashCustomRepository {

  private JPAQueryFactory queryFactory;

  public SpringDataMemberCashCustomRepositoryImpl(EntityManager entityManager) {
    this.queryFactory = new JPAQueryFactory(entityManager);
  }

  @Override
  public MemberCashJpaEntity getMemberCash(Long memberId) {

    MemberCashJpaEntity memberCashJpaEntity = queryFactory.select(QMemberCashJpaEntity.memberCashJpaEntity)
        .from(QMemberCashJpaEntity.memberCashJpaEntity)
        .where(QMemberCashJpaEntity.memberCashJpaEntity.memberJpaEntity.memberId.eq(memberId)).fetchFirst();

    return memberCashJpaEntity;
  }
}
