package org.liki.client.adapter.out.persistence.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QMemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashCustomRepository;

@Slf4j
@RequiredArgsConstructor
public class SpringDataMemberCashCustomRepositoryImpl implements SpringDataMemberCashCustomRepository {

  private final JPAQueryFactory queryFactory;


  @Override
  public MemberCashJpaEntity getMemberCash(Long memberId) {

    MemberCashJpaEntity memberCashJpaEntity = queryFactory.select(QMemberCashJpaEntity.memberCashJpaEntity)
        .from(QMemberCashJpaEntity.memberCashJpaEntity)
        .where(QMemberCashJpaEntity.memberCashJpaEntity.memberJpaEntity.memberId.eq(memberId)).fetchFirst();

    return memberCashJpaEntity;
  }
}
