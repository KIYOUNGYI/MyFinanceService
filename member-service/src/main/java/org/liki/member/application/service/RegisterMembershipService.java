package org.liki.member.application.service;

import lombok.RequiredArgsConstructor;
import org.liki.member.adapter.out.persistence.MemberJpaEntity;
import org.liki.member.adapter.out.persistence.MemberMapper;
import org.liki.member.application.port.in.RegisterMemberCommand;
import org.liki.member.application.port.in.RegisterMemberUseCase;
import org.liki.member.application.port.out.RegisterMemberPort;
import org.liki.member.domain.Member;
import org.liki.member.domain.Member.MemberEmail;
import org.liki.member.domain.Member.MemberIsValid;
import org.liki.member.domain.Member.MemberName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class RegisterMembershipService implements RegisterMemberUseCase {

  private final RegisterMemberPort registerMemberPort;

  @Override
  public Member registerMember(RegisterMemberCommand command) {

    //command -> db
    MemberJpaEntity membershipJpaEntity = registerMemberPort.createMember(
        new MemberName(command.getMemberName()),
        new MemberEmail(command.getEmail()),
        new MemberIsValid(command.isValid())
    );

    //db -> domain
    return MemberMapper.jpaEntityToDomain(membershipJpaEntity);
  }
}
