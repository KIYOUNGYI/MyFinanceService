package org.liki.client.adapter.out.persistence.repository;

import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;

public interface SpringDataMemberCashCustomRepository {

  MemberCashJpaEntity getMemberCash(Long memberId);
}
