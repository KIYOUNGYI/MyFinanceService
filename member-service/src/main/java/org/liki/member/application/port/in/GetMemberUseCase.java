package org.liki.member.application.port.in;

import org.liki.member.domain.Member;

public interface GetMemberUseCase {

  Member getMember(GetMemberCommand command);
}
