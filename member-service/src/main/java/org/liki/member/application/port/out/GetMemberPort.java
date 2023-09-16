package org.liki.member.application.port.out;

import org.liki.member.adapter.out.persistence.MemberJpaEntity;

public interface GetMemberPort {

  MemberJpaEntity getMember(Long id);
}
