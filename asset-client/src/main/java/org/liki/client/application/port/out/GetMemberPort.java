package org.liki.client.application.port.out;


import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;

public interface GetMemberPort {

  MemberJpaEntity getMember(Long id);
}
