package org.liki.member.application.port.in;

import org.liki.member.domain.Member;

//@UseCase
public interface RegisterMemberUseCase {

  Member registerMember(RegisterMemberCommand command);
}
