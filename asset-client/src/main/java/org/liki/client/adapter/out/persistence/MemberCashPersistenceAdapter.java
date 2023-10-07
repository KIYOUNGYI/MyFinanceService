package org.liki.client.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.QMemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashCustomRepository;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashJpaEntity;
import org.liki.client.application.port.out.GetMemberCashPort;
import org.liki.client.application.port.out.RegisterMemberCashPort;
import org.liki.common.PersistenceAdapter;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberCashPersistenceAdapter implements RegisterMemberCashPort, GetMemberCashPort {

  private final SpringDataMemberCashJpaEntity springDataMemberCashJpaEntity;

  private final SpringDataMemberCashCustomRepository springDataMemberCashCustomRepository;

  @Override
  public MemberCashJpaEntity registerMemberCash(MemberJpaEntity memberJpaEntity, Double cashAmount) {

    MemberCashJpaEntity save = springDataMemberCashJpaEntity.save(MemberCashJpaEntity.builder()
        .memberJpaEntity(memberJpaEntity)
        .cashAmount(cashAmount).build());

    return save;
  }


  @Override
  public MemberCashJpaEntity getMemberCash(Long memberId) {

    MemberCashJpaEntity memberCash = springDataMemberCashCustomRepository.getMemberCash(memberId);
    log.info("memberCash : {}", memberCash);
    return memberCash;

  }
}
