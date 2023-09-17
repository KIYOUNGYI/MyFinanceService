package org.liki.client.application.service;

import lombok.RequiredArgsConstructor;
import org.liki.client.adapter.out.persistence.MemberMapper;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.application.port.in.GetMemberCommand;
import org.liki.client.application.port.in.GetMemberUseCase;
import org.liki.client.application.port.out.GetMemberPort;
import org.liki.client.domain.Member;
import org.liki.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@UseCase
public class GetMembershipService implements GetMemberUseCase {

  private final GetMemberPort getMemberPort;

  @Override
  public Member getMember(GetMemberCommand command) {

    //command -> db
    MemberJpaEntity member = getMemberPort.getMember(command.getId());

    //db -> domain
    return MemberMapper.jpaEntityToDomain(member);
  }

}
