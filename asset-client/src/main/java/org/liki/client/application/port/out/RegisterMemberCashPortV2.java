package org.liki.client.application.port.out;

import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberCashV2JpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;

public interface RegisterMemberCashPortV2 {

  MemberCashV2JpaEntity registerMemberCash(Long memberId, Double cashAmount);
}
