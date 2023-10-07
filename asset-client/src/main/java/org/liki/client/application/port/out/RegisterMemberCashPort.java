package org.liki.client.application.port.out;

import org.liki.client.adapter.out.persistence.entity.MemberCashJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;

public interface RegisterMemberCashPort {

  MemberCashJpaEntity registerMemberCash(MemberJpaEntity memberJpaEntity, Double cashAmount);
}
