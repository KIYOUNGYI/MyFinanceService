package org.liki.member.application.service;

import lombok.RequiredArgsConstructor;
import org.liki.common.UseCase;
import org.liki.member.adapter.out.persistence.MemberJpaEntity;
import org.liki.member.adapter.out.persistence.MemberMapper;
import org.liki.member.application.port.in.GetMemberCommand;
import org.liki.member.application.port.in.GetMemberUseCase;
import org.liki.member.application.port.in.RegisterMemberCommand;
import org.liki.member.application.port.in.RegisterMemberUseCase;
import org.liki.member.application.port.out.GetMemberPort;
import org.liki.member.application.port.out.RegisterMemberPort;
import org.liki.member.domain.Member;
import org.liki.member.domain.Member.MemberEmail;
import org.liki.member.domain.Member.MemberIsValid;
import org.liki.member.domain.Member.MemberName;
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
