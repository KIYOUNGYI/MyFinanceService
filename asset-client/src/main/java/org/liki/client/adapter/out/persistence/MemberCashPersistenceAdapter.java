package org.liki.client.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberCashV2JpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashCustomRepository;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashJpaRepository;
import org.liki.client.adapter.out.persistence.repository.SpringDataMemberCashV2JpaRepository;
import org.liki.client.application.port.out.GetMemberCashPort;
import org.liki.client.application.port.out.RegisterMemberCashPort;
import org.liki.client.application.port.out.RegisterMemberCashPortV2;
import org.liki.common.PersistenceAdapter;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberCashPersistenceAdapter implements RegisterMemberCashPort, GetMemberCashPort, RegisterMemberCashPortV2 {

  private final SpringDataMemberCashV2JpaRepository springDataMemberCashV2JpaRepository;

  private final SpringDataMemberCashJpaRepository springDataMemberCashJpaRepository;

  private final SpringDataMemberCashCustomRepository springDataMemberCashCustomRepository;

  @Override
  public MemberCashJpaEntity registerMemberCash(MemberJpaEntity memberJpaEntity, Double cashAmount) {

    MemberCashJpaEntity save = springDataMemberCashJpaRepository.save(MemberCashJpaEntity.builder()
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

  @Override
  public MemberCashV2JpaEntity registerMemberCash(Long memberId, Double cashAmount) {

    MemberCashV2JpaEntity save = springDataMemberCashV2JpaRepository.save(MemberCashV2JpaEntity.builder()
            .memberId(memberId)
            .cashAmount(cashAmount)
            .build());

    return save;
  }
}
